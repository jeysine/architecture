package cn.com.architecture.wechat.service;

import cn.com.architecture.wechat.entity.WechatCommonResult;
import cn.com.architecture.wechat.entity.menu.WechatMenu;

public interface WechatMenuService {
	Boolean createWechatMenu(WechatMenu wechatMenu);
	String getWechatMenu();
	WechatCommonResult deleteWechatMenu();
}
