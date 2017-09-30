package cn.com.architecture.wechat.service.impl;

import cn.com.architecture.wechat.contants.WechatParams;
import cn.com.architecture.wechat.contants.WechatReponseCodeEmnu;
import cn.com.architecture.wechat.contants.WechatTemplatesEnum;
import cn.com.architecture.wechat.entity.WechatAccessToken;
import cn.com.architecture.wechat.entity.WechatCommonResult;
import cn.com.architecture.wechat.entity.message.WechatNewsMessageArticle;
import cn.com.architecture.wechat.service.WechatAccessTokenService;
import cn.com.architecture.wechat.service.WechatMessageService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.TemplateException;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import utils.code.generate.FreeMarkerTemplateUtils;
import utils.okhttputil.OkHttpUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("wechatMessageService")
public class WechatMessageServiceImpl implements WechatMessageService{
	@Value("${wechat.push.kf.message.url}")
	private String wechatMessageUrl;

	@Autowired
	private WechatAccessTokenService wechatAccessTokenService;
	private static final ObjectMapper mapper = new ObjectMapper();

	private Logger logger = LoggerFactory.getLogger(WechatMessageServiceImpl.class);
	@Override
	public void pushTextMessage(String openid,String content) {
		String data = null;

		Map propertities = new HashMap();
		propertities.put("openid", openid);
		propertities.put("content", content);

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
	public void pushNewsMessage(String openid, List<WechatNewsMessageArticle> articles) {
		String data = null;
		ObjectMapper mapper = new ObjectMapper();

		try {
			String articlesJson = mapper.writeValueAsString(articles);
			Map propertities = new HashMap();
			propertities.put("openid", openid);
			propertities.put("articles", articlesJson);
			data = FreeMarkerTemplateUtils.generate(
					getTemplateName(WechatTemplatesEnum.NOTIF_USER_NEWS_MESSAGE.name()), propertities);
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
		WechatAccessToken accessToken = wechatAccessTokenService.getAccessToken();

		String url = wechatMessageUrl.replace("ACCESS_TOKEN", accessToken.getAccessToken());
		Response response = OkHttpUtils.postString().url(url).content(wxMessage).build().execute();
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
		WechatNewsMessageArticle test = new WechatNewsMessageArticle();
		test.setPicurl("sdsadsad");
		test.setDescription("dasds");
		List<WechatNewsMessageArticle> articles = new ArrayList<>();

		articles.add(test);
		try {
			String json = mapper.writeValueAsString(articles);
			System.out.println(json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

	}
}
