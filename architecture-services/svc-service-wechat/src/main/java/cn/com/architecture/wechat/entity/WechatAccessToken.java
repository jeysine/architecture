package cn.com.architecture.wechat.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class WechatAccessToken extends WechatCommonResult implements Serializable{

	private static final long serialVersionUID = 926808053073105294L;
	@JsonProperty("access_token")
	private String accessToken;

	@JsonProperty("expires_in")
	private Long expiresIn;

	public WechatAccessToken() {
	}

	public WechatAccessToken(String accessToken, Long expiresIn) {
		this.accessToken = accessToken;
		this.expiresIn = expiresIn;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Long getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(Long expiresIn) {
		this.expiresIn = expiresIn;
	}

	@Override
	public String toString() {
		return "WechatAccessToken{" +
				"accessToken='" + accessToken + '\'' +
				", expiresIn=" + expiresIn +
				'}';
	}
}
