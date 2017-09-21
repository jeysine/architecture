package cn.com.architecture.wechat.service;

import cn.com.architecture.wechat.entity.WechatAccessToken;

import java.io.IOException;

public interface WechatService {
	void getAccessTokenFromWechat() throws IOException;

	WechatAccessToken getAccessTokenFromRedis() throws Exception;
}
