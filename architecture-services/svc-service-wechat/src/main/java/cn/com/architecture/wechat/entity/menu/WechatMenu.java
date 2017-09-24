package cn.com.architecture.wechat.entity.menu;

import java.io.Serializable;

public class WechatMenu implements Serializable{

	private static final long serialVersionUID = -3217195295528900441L;
	private WechatButton[] buttons;

	public WechatButton[] getButtons() {
		return buttons;
	}

	public void setButtons(WechatButton[] buttons) {
		this.buttons = buttons;
	}
}
