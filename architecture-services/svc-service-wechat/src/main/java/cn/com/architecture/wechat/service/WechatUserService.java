package cn.com.architecture.wechat.service;

import cn.com.architecture.wechat.entity.WechatUser;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.util.List;

public interface WechatUserService {
	WechatUser getWechatUserInfo(String openid, String lang) throws IOException;
	List<WechatUser> getWechatUserInfoList(List<String> openids) throws IOException;

}
