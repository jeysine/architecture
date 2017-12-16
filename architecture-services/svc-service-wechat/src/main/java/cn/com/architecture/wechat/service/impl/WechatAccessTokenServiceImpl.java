package cn.com.architecture.wechat.service.impl;

import cn.com.architecture.wechat.contants.WechatParams;
import cn.com.architecture.wechat.entity.WechatAccessToken;
import cn.com.architecture.wechat.service.WechatAccessTokenService;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import utils.UuidUtils;
import utils.okhttputil.OkHttpUtils;

import java.io.IOException;

@Service("wechatAccessTokenService")
public class WechatAccessTokenServiceImpl implements WechatAccessTokenService {


	@Autowired
	private JedisPool jedisPool;

	private static Logger logger = LoggerFactory.getLogger(WechatAccessTokenServiceImpl.class);


	@Override
	public WechatAccessToken getAccessToken() {
		WechatAccessToken wechatAccessToken = null;
		Jedis jedis = jedisPool.getResource();
		if (jedis == null) {
			logger.error("Redis is not rechable");
		}

		try {
			Long mutexKeyValue = new UuidUtils().nextValue();
			do {
				Long accessTokenExpired = jedis.ttl(WechatParams.ACCESS_TOKEN_KEY);
				String accessToken = jedis.get(WechatParams.ACCESS_TOKEN_KEY);

				if (accessToken != null && accessTokenExpired > 0) {
					wechatAccessToken =  new WechatAccessToken(accessToken, accessTokenExpired);
					logger.debug("get access token from redis success, access token:{} expired:{}",accessToken,accessTokenExpired);
				} else {
					//logger.debug("Redis is not exists access token , start get lock to get access token from wechat.");
					if (isLeader(jedis, mutexKeyValue)) {
						wechatAccessToken = getAccessTokenFromWechat();
					}
				}
			} while (wechatAccessToken == null);
		} finally {
			jedis.close();
		}
		return wechatAccessToken;
	}
	private Boolean isLeader(Jedis jedis, Long mutexKeyValue) {
		Long mutexKeyExpired = 10L;
		String existsMutexKeyValue = jedis.get(WechatParams.ACCESS_TOKEN_KEY_MUTEX);

		//防止某线程或进程第一次获得leader但获取或设置accessToken失败而进行第二次设置
		if (existsMutexKeyValue != null && mutexKeyValue.equals(existsMutexKeyValue)) {
			logger.debug("set access token not need lock");
			return true;
		} else if (existsMutexKeyValue != null){
			logger.debug("get leader faild");
			return false;
		}

		String result = jedis.set(WechatParams.ACCESS_TOKEN_KEY_MUTEX, mutexKeyValue.toString(), "NX", "EX", mutexKeyExpired);
		if (result != null) {
			logger.debug("get leader success");
			return true;
		} else {
			logger.debug("get leader faild");
		}
		return false;
	}

	private WechatAccessToken getAccessTokenFromWechat()  {
		String url = WechatParams.WECHAT_GET_ACCESSTOKEN_URL.replace("APPID", WechatParams.WECHAT_TEST_APPID)
				.replace("APPSECRET", WechatParams.WECHAT_TEST_APPSECRET);

		Response response = null;
		WechatAccessToken wechatAccessToken = null;
		try {
			response = OkHttpUtils.get().url(url)
					.build().execute();
			logger.debug("get wechat access token suucess:{}", response.body().string());

			ObjectMapper mapper = new ObjectMapper();
			wechatAccessToken = mapper.readValue(response.body().string(), WechatAccessToken.class);
			if (wechatAccessToken.getAccessToken() == null) {
				logger.error("get wechat access token error, errcode:{},errmsg:{}", wechatAccessToken.getErrcode(),wechatAccessToken.getErrmsg());
				return null;
			}

			wechatAccessToken.setExpiresIn(
					wechatAccessToken.getExpiresIn()  + (System.currentTimeMillis() / 1000) - 5L);
//		WechatAccessToken wechatAccessToken =  new WechatAccessToken("asdasdasd", 100L + (System.currentTimeMillis() / 1000));
			logger.debug("get wechat access token suucess:{}", wechatAccessToken.getAccessToken());
			setAccessTokenToRedis(wechatAccessToken);
		} catch (IOException e) {
			logger.error("visit wechat get access token faild:{}", e);
		}


		return wechatAccessToken;
	}

	private void setAccessTokenToRedis(WechatAccessToken accessToken) throws IOException {
		logger.debug("set access token to redis start.");
		Jedis jedis = jedisPool.getResource();
		Long accessTokenExpiredIn = accessToken.getExpiresIn() - (System.currentTimeMillis() / 1000) - 5L;
		if (accessTokenExpiredIn < 0) {
			return;
		}
		String result = jedis.set(WechatParams.ACCESS_TOKEN_KEY, accessToken.getAccessToken(), "NX", "EX", accessTokenExpiredIn);
		logger.debug("result:{}",result);
		if (result != null) {
			logger.debug("set access token to redis success, accessToken:{}, expired: {}.", accessToken.getAccessToken(),accessToken.getExpiresIn());
			jedis.del(WechatParams.ACCESS_TOKEN_KEY_MUTEX);
		} else {
			logger.debug("access token had saved.");
		}
	}
	public static void main(String[] args) {
		String url = "https://api.weixin.qq.com/cgi-bin/token";
		try {
			Response response = OkHttpUtils.get().url(url)
					.addParams("grant_type","client_credential")
					.addParams("appid","wxc896cbf87e374920")
					.addParams("secret","485903fc8d413e3ee05d86f37db81c6e")
					.build().execute();
			ObjectMapper mapper = new ObjectMapper();
			WechatAccessToken wechatAccessToken = mapper.readValue(response.body().string(), WechatAccessToken.class);
			System.out.println(wechatAccessToken);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
