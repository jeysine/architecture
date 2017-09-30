package cn.com.architecture.wechat.service;

import cn.com.architecture.wechat.entity.WechatCommonResult;
import cn.com.architecture.wechat.entity.menu.WechatMenu;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;

public interface WechatMenuService {
	Boolean createWechatMenu(WechatMenu wechatMenu) throws IOException;
	String getWechatMenu() throws IOException;
	WechatCommonResult deleteWechatMenu() throws IOException;
}
