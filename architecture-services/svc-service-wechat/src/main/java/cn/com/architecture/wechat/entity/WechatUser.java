package cn.com.architecture.wechat.entity;

import java.util.List;


public class WechatUser extends WechatCommonResult{
	private static final long serialVersionUID = 7179826176952466793L;
	/**
	 * 0表示用户没有关注该公众号,1表示有
	 */
	private Integer subscribe;
	/**
	 *
	 */
	private String openid;
	private String nickname;
	private Integer sex;
	/**
	 * 用户的语言
	 */
	private String language;
	private String city;
	private String province;
	private String country;
	/**
	 * 用户头像
	 */
	private String headimgurl;
	/**
	 * 关注时间
	 */
	private String subscribeTime;
	/**
	 * 公众号绑定到微信开放平台,才有该字段
	 */
	private String unionid;
	private String remark;
	/**
	 * 用户所在的分组id
	 */
	private String groupid;
	/**
	 * 用户被打上的标签ID列表
	 */
	private List<Integer> tagidList;

	public Integer getSubscribe() {
		return subscribe;
	}

	public void setSubscribe(Integer subscribe) {
		this.subscribe = subscribe;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getHeadimgurl() {
		return headimgurl;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	public String getSubscribeTime() {
		return subscribeTime;
	}

	public void setSubscribeTime(String subscribeTime) {
		this.subscribeTime = subscribeTime;
	}

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getGroupid() {
		return groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public List<Integer> getTagidList() {
		return tagidList;
	}

	public void setTagidList(List<Integer> tagidList) {
		this.tagidList = tagidList;
	}
}
