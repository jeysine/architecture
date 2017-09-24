package cn.com.architecture.wechat.contants;

public class WechatParams {
	// access token 在redis中的键
	public static final String ACCESS_TOKEN_KEY = "access_token";

	//从微信获取access token需要的分布式锁key
	public static final String ACCESS_TOKEN_KEY_MUTEX = ACCESS_TOKEN_KEY + "_mutex";

	public static final String WECHAT_TEMPLATE_FILE_DIR = "/wechat/";
}
