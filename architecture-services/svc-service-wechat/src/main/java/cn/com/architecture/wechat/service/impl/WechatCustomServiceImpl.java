package cn.com.architecture.wechat.service.impl;

import cn.com.architecture.wechat.entity.WechatCommonResult;
import cn.com.architecture.wechat.entity.WechatCustom;
import cn.com.architecture.wechat.service.WechatAccessTokenService;
import cn.com.architecture.wechat.service.WechatCustomService;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import utils.okhttputil.OkHttpUtils;

import java.io.IOException;
import java.util.List;

public class WechatCustomServiceImpl implements WechatCustomService {
	@Value("${wechat.add.custom.url}")
	private String addCustomUrl;
	@Value("${wechat.update.custom.url}")
	private String updateCustomUrl;
	@Value("${wechat.delte.custom.url}")
	private String deleteCustomUrl;
	@Value("${wechat.update.custom.head.pic.url}")
	private String updateCustomHeadPicUrl;

	@Value("${wechat.get.custom.list.url}")
	private String getCustomListUrl;
	@Autowired
	private WechatAccessTokenService wechatAccessTokenService;

	private static final ObjectMapper mapper = new ObjectMapper();
	@Override
	public WechatCommonResult addCustom(WechatCustom custom) throws IOException {
		String accessToken = wechatAccessTokenService.getAccessToken().getAccessToken();
		String url = addCustomUrl.replace("ACCESS_TOKEN", accessToken);
		return addOrUpdateOrDelCustom(custom ,url);
	}

	@Override
	public WechatCommonResult updateCustom(WechatCustom custom) throws IOException {
		String accessToken = wechatAccessTokenService.getAccessToken().getAccessToken();
		String url = updateCustomUrl.replace("ACCESS_TOKEN", accessToken);
		return addOrUpdateOrDelCustom(custom ,url);
	}

	@Override
	public WechatCommonResult deleteCustom(WechatCustom custom) throws IOException {
		String accessToken = wechatAccessTokenService.getAccessToken().getAccessToken();
		String url = deleteCustomUrl.replace("ACCESS_TOKEN", accessToken);
		return addOrUpdateOrDelCustom(custom ,url);
	}

	@Override
	public WechatCommonResult updateCustomHeadPic(WechatCustom custom) throws IOException {
		String accessToken = wechatAccessTokenService.getAccessToken().getAccessToken();
		String url = updateCustomHeadPicUrl.replace("ACCESS_TOKEN", accessToken).replace("KFACCOUNT", custom.getAccount());
		return addOrUpdateOrDelCustom(custom ,url);
	}

	@Override
	public List<WechatCustom> getCustomList(WechatCustom custom) throws IOException {
		String accessToken = wechatAccessTokenService.getAccessToken().getAccessToken();
		String url = getCustomListUrl.replace("ACCESS_TOKEN", accessToken);
		Response response = OkHttpUtils.get().url(url).build().execute();
		return mapper.readValue(response.body().toString(),
				mapper.getTypeFactory().constructParametricType(List.class, WechatCustom.class));
	}

	private WechatCommonResult addOrUpdateOrDelCustom(WechatCustom custom, String url) throws IOException {
		String json = mapper.writeValueAsString(custom);
		Response response = OkHttpUtils.postString().url(url).content(json).build().execute();
		return mapper.readValue(response.body().toString(), WechatCommonResult.class);
	}
}
