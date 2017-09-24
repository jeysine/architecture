package cn.com.architecture.wechat.entity.menu;

public class WechatMiniprogramButton extends WechatButton{

	private static final long serialVersionUID = -6047686361002826578L;

	/**
	 * miniprogram
	 */
	private String type;

	/**
	 * 小程序备用网址,设备不支持小程序跳转链接
	 */
	private String url;

	/**
	 * 小程序路径
	 */
	private String pagepath;

	/**
	 * 小程序appid
	 */
	private String appid;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPagepath() {
		return pagepath;
	}

	public void setPagepath(String pagepath) {
		this.pagepath = pagepath;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	@Override
	public String toString() {
		return "WechatMiniprogramButton{" +
				"type='" + type + '\'' +
				", url='" + url + '\'' +
				", pagepath='" + pagepath + '\'' +
				", appid='" + appid + '\'' +
				'}';
	}
}
