package cn.com.architecture.wechat.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WechatMenuDto implements Serializable{
	private static final long serialVersionUID = -2672453090337574100L;
	/** 菜单名称 **/
	private String name;

	/** 编码或url **/
	private String value;

	/** 菜单级别 **/
	private Integer level;

	/** 菜单序号 **/
	private Integer seq;

	/** 图文消息内容 **/
	private String description;

	/** 菜单类型 **/
	private String type;

	/** 父菜单id **/
	private Object parentId;

	/** 图文消息标题 **/
	private String title;

	/** 图文消息图片链接 **/
	private String picUrl;

	/** 图文消息网页链接 **/
	private String webUrl;

	/**
	 * 小程序appid
	 */
	private String miniprogramAppid;

	/**
	 * 小程序路径
	 */
	private String pagepath;

	@Override
	public String toString() {
		return "WechatMenuDto{" +
				"name='" + name + '\'' +
				", value='" + value + '\'' +
				", level=" + level +
				", seq=" + seq +
				", description='" + description + '\'' +
				", type='" + type + '\'' +
				", parentId=" + parentId +
				", title='" + title + '\'' +
				", picUrl='" + picUrl + '\'' +
				", webUrl='" + webUrl + '\'' +
				", miniprogramAppid='" + miniprogramAppid + '\'' +
				", pagepath='" + pagepath + '\'' +
				'}';
	}
}
