package cn.com.architecture.wechat.service.impl;

import cn.com.architecture.wechat.contants.WechatReponseCodeEmnu;
import cn.com.architecture.wechat.entity.WechatAccessToken;
import cn.com.architecture.wechat.entity.WechatCommonResult;
import cn.com.architecture.wechat.entity.menu.WechatMenu;
import cn.com.architecture.wechat.service.WechatAccessTokenService;
import cn.com.architecture.wechat.service.WechatMenuService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import utils.okhttputil.OkHttpUtils;

import java.io.IOException;

@Service("wechatMenuService")
public class WechatMenuServiceImpl implements WechatMenuService {
	@Value("${wechat.create.menu}")
	private String wechat_create_menu ;
	@Value("${wechat.get.menu}")
	private String wechat_get_menu;
	@Value("${wechat.delete.menu}")
	private String wechat_delete_menu;
	private static Logger logger = LoggerFactory.getLogger(WechatMenuServiceImpl.class);

	@Autowired
	private WechatAccessTokenService wechatAccessTokenService;
	@Override
	public Boolean createWechatMenu(WechatMenu wechatMenu) {
		WechatAccessToken accessToken = wechatAccessTokenService.getAccessToken();

		String wechatCreateMenuUrl = wechat_create_menu.replace("ACCESS_TOKEN", accessToken.getAccessToken());
		ObjectMapper mapper = new ObjectMapper();

		try {
			String wechatMenuJson = mapper.writeValueAsString(wechatMenu);
			logger.debug("wechatMenuJson:{}",wechatMenuJson);
			Response response = OkHttpUtils.post().url(wechatCreateMenuUrl).addParams("button", wechatMenuJson).build().execute();
			WechatCommonResult result = mapper.readValue(response.body().toString(),WechatCommonResult.class);
			if (WechatReponseCodeEmnu.OK.getCode().equals(result.getErrcode())) {
				logger.debug("create wechat menu success,code:{},msg:{}", result.getErrcode(), result.getErrmsg());
				return true;
			} else {
				logger.error("create wechat menu falid,errorcode:{},errormsg:{}", result.getErrcode(), result.getErrmsg());
			}
		} catch (JsonProcessingException e) {
			logger.error("wechat menu entity serialize error:{}", e);
		} catch (IOException e) {
			logger.error("visit wechat create menu faild:{}", e);
		}
		return false;
	}

	@Override
	public String getWechatMenu() {
		WechatAccessToken accessToken = wechatAccessTokenService.getAccessToken();
		String getWechatMenuUrl = wechat_get_menu.replace("ACCESS_TOKEN", accessToken.getAccessToken());
		ObjectMapper mapper = new ObjectMapper();
		try {
			Response response = OkHttpUtils.get().url(getWechatMenuUrl).build().execute();
			String result = response.body().string();
			logger.debug("get wechat menu result:{}",result);
			return result;
		} catch (IOException e) {
			logger.error("visit wechat get menu faild:{}", e);
		}
		return null;
	}

	@Override
	public WechatCommonResult deleteWechatMenu() {
		WechatAccessToken accessToken = wechatAccessTokenService.getAccessToken();
		String deleteWechatMenuUrl = wechat_delete_menu.replace("ACCESS_TOKEN", accessToken.getAccessToken());
		ObjectMapper mapper = new ObjectMapper();
		try {
			Response response = OkHttpUtils.get().url(deleteWechatMenuUrl).build().execute();
			WechatCommonResult result = mapper.readValue(response.body().toString(),WechatCommonResult.class);
			if (WechatReponseCodeEmnu.OK.getCode().equals(result.getErrcode())) {
				logger.debug("delete wechat menu success:{}",result);
			} else {
				logger.error("delete wechat menu faild,errcode:{},errmsg:{}",result.getErrcode(),result.getErrmsg());
			}
			return result;
		} catch (IOException e) {
			logger.error("visit wechat delete menu faild:{}", e);
		}
		return null;
	}
}
