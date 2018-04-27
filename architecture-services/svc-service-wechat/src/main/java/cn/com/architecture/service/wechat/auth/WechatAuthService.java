package cn.com.architecture.service.wechat.auth;



import cn.com.architecture.entity.wechat.acesstoken.WechatAuthAccessToken;

import java.io.IOException;

/**
 * Created by jeysine on 2018/2/8.
 */
public interface WechatAuthService {

    WechatAuthAccessToken getAuthAccessTokenByCode(String code) throws IOException;

    WechatAuthAccessToken getAccessTokenByRefreshToken(String refreshToken) throws IOException;
}
