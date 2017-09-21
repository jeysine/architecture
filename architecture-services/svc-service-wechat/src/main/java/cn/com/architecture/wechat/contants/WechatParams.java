package cn.com.architecture.wechat.contants;

public class WechatParams {
	public static  String ACCESS_TOKEN_KEY = "access_token:";

	//从微信获取access token需要的分布式锁key
	public static  String ACCESS_TOKEN_KEY_MUTEX = ACCESS_TOKEN_KEY + "mutex";
}
