package cn.com.architecture.config.wechat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 微信公众号参数设置
 * Created by jeysine on 2018/1/24.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.ALWAYS)
public class WechatConfigSecret {

    /**
     * 公众号appid
     */
    private static String wechatAppId;

    /**
     * 微信公众号密钥
     */
    private static String wechatSecret;

    /**
     * 商户号
     */
    private static String wechatMchId;

    /**
     * 支付密钥
     */
    private static String wechatPaySecret;

    public static String getWechatAppId() {
        return wechatAppId;
    }

    public void setWechatAppId(String wechatAppId) {
        WechatConfigSecret.wechatAppId = wechatAppId;
    }

    public static String getWechatSecret() {
        return wechatSecret;
    }

    public void setWechatSecret(String wechatSecret) {
        WechatConfigSecret.wechatSecret = wechatSecret;
    }

    public static String getWechatMchId() {
        return wechatMchId;
    }

    public void setWechatMchId(String wechatMchId) {
        WechatConfigSecret.wechatMchId = wechatMchId;
    }

    public static String getWechatPaySecret() {
        return wechatPaySecret;
    }

    public void setWechatPaySecret(String wechatPaySecret) {
        WechatConfigSecret.wechatPaySecret = wechatPaySecret;
    }
}
