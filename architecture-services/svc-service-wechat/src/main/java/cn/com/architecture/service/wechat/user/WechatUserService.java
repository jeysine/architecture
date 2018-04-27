package cn.com.architecture.service.wechat.user;

import cn.com.architecture.entity.wechat.user.WechatUser;
import cn.com.architecture.entity.wechat.user.WechatUserList;

import java.io.IOException;
import java.util.List;

public interface WechatUserService {
	WechatUser getWechatUserInfo(String openid, String lang) throws IOException;
	WechatUserList getWechatUserInfoList(List<String> openids) throws IOException;
	WechatUser getWechatUserInfoByAuth(String authAccessToken, String openid) throws IOException;
}
