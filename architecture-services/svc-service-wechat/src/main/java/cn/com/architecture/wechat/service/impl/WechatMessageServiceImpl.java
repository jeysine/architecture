package cn.com.architecture.wechat.service.impl;

import cn.com.architecture.wechat.contants.WechatParams;
import cn.com.architecture.wechat.contants.WechatReponseCodeEmnu;
import cn.com.architecture.wechat.contants.WechatTemplatesEnum;
import cn.com.architecture.wechat.entity.WechatCommonResult;
import cn.com.architecture.wechat.service.WechatMessageService;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.TemplateException;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import utils.code.generate.FreeMarkerTemplateUtils;
import utils.okhttputil.OkHttpUtils;

import java.io.IOException;
import java.util.Map;

@Service("wechatMessageService")
public class WechatMessageServiceImpl implements WechatMessageService{
	@Value("${wechat.push.kf.message.url}")
	private String wechatMessageUrl;

	private Logger logger = LoggerFactory.getLogger(WechatMessageServiceImpl.class);
	@Override
	public void pushTextMessage(Map<String, Object> propertities) {
		String data = null;
		try {
			data = FreeMarkerTemplateUtils.generate(
					getTemplateName(WechatTemplatesEnum.NOTIF_USER_TEXT_MESSAGE.name()), propertities);
			logger.debug("data :{}",data);
			WechatCommonResult result = pushMessgge(data);
			if (WechatReponseCodeEmnu.OK.getCode().equals(result.getErrcode())) {
				logger.debug("push wechat text message to user success");
				return;
			} else {
				logger.error("push wechat text message to user falid,errorcode:{},errormsg:{}", result.getErrcode(), result.getErrmsg());
			}
		} catch (IOException | TemplateException e) {
			logger.error("",e);
		}
	}

	@Override
	public void pushNewsMessage(Map<String, Object> propertities) {
		String data = null;
		try {
			data = FreeMarkerTemplateUtils.generate(
					getTemplateName(WechatTemplatesEnum.NOTIF_USER_TEXT_MESSAGE.name()), propertities);
			logger.debug("data :{}",data);
			WechatCommonResult result = pushMessgge(data);
			if (WechatReponseCodeEmnu.OK.getCode().equals(result.getErrcode())) {
				logger.debug("push wechat news message to user success");
				return;
			} else {
				logger.error("push wechat news message to user falid,errorcode:{},errormsg:{}", result.getErrcode(), result.getErrmsg());
			}
		} catch (IOException | TemplateException e) {
			logger.error("",e);
		}
	}

	@Override
	public void pushTemplateMessage(Map<String, Object> propertities) {

	}

	@Override
	public WechatCommonResult pushMessgge(String wxMessage) throws IOException {
		Response response = OkHttpUtils.postString().url(wechatMessageUrl).content(wxMessage).build().execute();
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(response.body().toString(),WechatCommonResult.class);
	}

	private String getTemplateName(String name) {
		return WechatParams.WECHAT_TEMPLATE_FILE_DIR + name + ".ftl";
	}
	public static void main(String[] args) {
		/*WechatMessageServiceImpl wechatMessageService = new WechatMessageServiceImpl();
		Map<String, Object> map = new HashMap<>();
		map.put("openid", "111");
		map.put("content", "test");
		wechatMessageService.pushTextMessage(map);*/
	}
}
