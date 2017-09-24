package cn.com.architecture.wechat.service;

import cn.com.architecture.wechat.entity.WechatCommonResult;

import java.io.IOException;
import java.util.Map;

public interface WechatMessageService {
	void pushTextMessage(Map<String, Object> propertities);
	void pushNewsMessage(Map<String, Object> propertities);
	void pushTemplateMessage(Map<String, Object> propertities);
	WechatCommonResult pushMessgge(String wxMessage) throws IOException;

}
