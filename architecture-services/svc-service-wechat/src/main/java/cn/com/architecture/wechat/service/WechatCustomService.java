package cn.com.architecture.wechat.service;

import cn.com.architecture.wechat.entity.WechatCommonResult;
import cn.com.architecture.wechat.entity.WechatCustom;

import java.io.IOException;
import java.util.List;

public interface WechatCustomService {
	WechatCommonResult addCustom(WechatCustom custom) throws IOException;
	WechatCommonResult updateCustom(WechatCustom custom) throws IOException;
	WechatCommonResult deleteCustom(WechatCustom custom) throws IOException;
	WechatCommonResult updateCustomHeadPic(WechatCustom custom) throws IOException;
	List<WechatCustom> getCustomList(WechatCustom custom) throws IOException;
}
