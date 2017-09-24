package cn.com.architecture.wechat.entity.menu;

/**
 * 微信click类型的菜单
 */
public class WechatClickButton extends WechatButton {
	private static final long serialVersionUID = -6415702988196776253L;
	private String type;

	private String key;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
