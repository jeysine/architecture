package cn.com.architecture.wechat.entity.menu;

import java.io.Serializable;

public class WechatButton implements Serializable{
	private static final long serialVersionUID = 4345471289814405479L;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
