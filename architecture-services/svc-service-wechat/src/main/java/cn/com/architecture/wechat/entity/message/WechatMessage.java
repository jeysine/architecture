package cn.com.architecture.wechat.entity.message;

import java.io.Serializable;

public class WechatMessage implements Serializable{
	private static final long serialVersionUID = 5822867437318610516L;
	/**
	 * 用户openid
	 */
	private String touser;
	/**
	 * 消息类型
	 */
	private String msgtype;

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
}
