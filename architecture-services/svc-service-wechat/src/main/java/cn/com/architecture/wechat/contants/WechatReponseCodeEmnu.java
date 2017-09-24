package cn.com.architecture.wechat.contants;

public enum WechatReponseCodeEmnu {
	OK(1, "ok");
	private Integer code;
	private String msg;

	WechatReponseCodeEmnu(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
