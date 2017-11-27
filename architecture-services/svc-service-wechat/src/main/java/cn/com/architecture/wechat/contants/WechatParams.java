package cn.com.architecture.wechat.contants;

public class WechatParams {
	// access token 在redis中的键
	public static final String ACCESS_TOKEN_KEY = "access_token";

	//从微信获取access token需要的分布式锁key
	public static final String ACCESS_TOKEN_KEY_MUTEX = ACCESS_TOKEN_KEY + "_mutex";

	public static final String WECHAT_TEMPLATE_FILE_DIR = "/wechat/";

	/**
	 * 微信appid appsecret
	 */
	public static final String WECHAT_TEST_APPID = "wxc896cbf87e374920";
	public static final String WECHAT_TEST_APPSECRET = "485903fc8d413e3ee05d86f37db81c6e";

	/**
	 * 微信accesToken获取
	 */
	public static final String WECHAT_GET_ACCESSTOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

	/**
	 * 微信菜单Url
	 */
	public static final String WECHAT_CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	public static final String WECHAT_GET_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
	public static final String WECHAT_DELETE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";

	/**
	 * 微信获取用户信息url
	 */
	public static final String WEHCAT_GET_USER_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	public static final String WECHAT_GET_USER_LIST_URL  = "https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=ACCESS_TOKEN";

	/**
	 * 微信客服管理
	 */
	public static final String WEHCAT_ADD_CUSTOM_URL = "https://api.weixin.qq.com/customservice/kfaccount/add?access_token=ACCESS_TOKEN";
	public static final String WECHAT_UPDATE_CUSTOM_URL = "https://api.weixin.qq.com/customservice/kfaccount/update?access_token=ACCESS_TOKEN";
	public static final String WEHCAT_DELETE_CUSTOM_URL = "https://api.weixin.qq.com/customservice/kfaccount/del?access_token=ACCESS_TOKEN";
	public static final String WEHCAT_UPDATE_CUSTOM_HEAD_PIC_URL = "http://api.weixin.qq.com/customservice/kfaccount/uploadheadimg?access_token=ACCESS_TOKEN&kf_account=KFACCOUNT";
	public static final String WEHCAT_GET_CUSTOM_LIST_URL = "https://api.weixin.qq.com/cgi-bin/customservice/getkflist?access_token=ACCESS_TOKEN";
	public static final String WECHAT_CUSTOM_MESSAGE = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";

	public static final String WEHCAT_ANALYSE_USER_SUMMARY = "https://api.weixin.qq.com/datacube/getusersummary?access_token=ACCESS_TOKEN";
	public static final String WECHAT_ANALYSE_USER_CUMULATE = "https://api.weixin.qq.com/datacube/getusercumulate?access_token=ACCESS_TOKEN";


}
