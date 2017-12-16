package cn.com.architecture.wechat.service.impl;

import cn.com.architecture.wechat.contants.WechatParams;
import cn.com.architecture.wechat.contants.WechatReponseCodeEmnu;
import cn.com.architecture.wechat.entity.WechatAccessToken;
import cn.com.architecture.wechat.entity.WechatCommonResult;
import cn.com.architecture.wechat.entity.menu.WechatMenu;
import cn.com.architecture.wechat.service.WechatAccessTokenService;
import cn.com.architecture.wechat.service.WechatMenuService;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.okhttputil.OkHttpUtils;

import java.io.IOException;

@Service("wechatMenuService")
public class WechatMenuServiceImpl implements WechatMenuService {
	private static Logger logger = LoggerFactory.getLogger(WechatMenuServiceImpl.class);
	private static final ObjectMapper mapper = new ObjectMapper();
	@Autowired
	private WechatAccessTokenService wechatAccessTokenService;
	@Override
	public Boolean createWechatMenu(WechatMenu wechatMenu) throws IOException {
		WechatAccessToken accessToken = wechatAccessTokenService.getAccessToken();

		String url = WechatParams.WECHAT_CREATE_MENU_URL.replace("ACCESS_TOKEN", accessToken.getAccessToken());

		String wechatMenuJson = mapper.writeValueAsString(wechatMenu);
		logger.debug("wechatMenuJson:{}",wechatMenuJson);
		Response response = OkHttpUtils.post().url(url).addParams("button", wechatMenuJson).build().execute();
		WechatCommonResult result = mapper.readValue(response.body().string(),WechatCommonResult.class);
		if (WechatReponseCodeEmnu.OK.getCode().equals(result.getErrcode())) {
			logger.debug("create wechat menu success,code:{},msg:{}", result.getErrcode(), result.getErrmsg());
			return true;
		} else {
			logger.error("create wechat menu falid,errorcode:{},errormsg:{}", result.getErrcode(), result.getErrmsg());
		}
		return false;
	}

	@Override
	public String getWechatMenu() throws IOException {
		WechatAccessToken accessToken = wechatAccessTokenService.getAccessToken();
		String url = WechatParams.WECHAT_GET_MENU_URL.replace("ACCESS_TOKEN", accessToken.getAccessToken());
		Response response = OkHttpUtils.get().url(url).build().execute();
		String result = response.body().string();
		logger.debug("get wechat menu result:{}",result);
		return result;
	}

	@Override
	public WechatCommonResult deleteWechatMenu() throws IOException {
		WechatAccessToken accessToken = wechatAccessTokenService.getAccessToken();
		String url = WechatParams.WECHAT_DELETE_MENU_URL.replace("ACCESS_TOKEN", accessToken.getAccessToken());
		Response response = OkHttpUtils.get().url(url).build().execute();
		WechatCommonResult result = mapper.readValue(response.body().string(),WechatCommonResult.class);
		if (WechatReponseCodeEmnu.OK.getCode().equals(result.getErrcode())) {
			logger.debug("delete wechat menu success:{}",result);
		} else {
			logger.error("delete wechat menu faild,errcode:{},errmsg:{}",result.getErrcode(),result.getErrmsg());
		}
		return result;
	}

}
