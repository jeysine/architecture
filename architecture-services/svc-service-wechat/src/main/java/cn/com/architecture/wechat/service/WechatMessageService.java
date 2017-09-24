package cn.com.architecture.wechat.service;

import cn.com.architecture.wechat.entity.WechatCommonResult;
import cn.com.architecture.wechat.entity.message.WechatNewsMessageArticle;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface WechatMessageService {
	void pushTextMessage(String openid,String content);
	void pushNewsMessage(String openid, List<WechatNewsMessageArticle> articles);
	void pushTemplateMessage(Map<String, Object> propertities);
	WechatCommonResult pushMessgge(String wxMessage) throws IOException;

}
