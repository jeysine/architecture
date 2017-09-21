package cn.com.architecture.wechat.service.impl;

import cn.com.architecture.wechat.contants.WechatParams;
import cn.com.architecture.wechat.entity.WechatAccessToken;
import cn.com.architecture.wechat.service.WechatService;
import com.google.gson.Gson;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import utils.okhttputil.OkHttpUtils;

import java.io.IOException;

@Service
public class WechatServiceImpl implements WechatService{

	@Value("${wechat.test.appid}")
	private String appid;
	@Value("${wechat.test.appsecret}")
	private String appsecret;

	@Autowired
	private static JedisPool jedisPool;

	private static Logger logger = LoggerFactory.getLogger(WechatServiceImpl.class);
	@Override
	public void getAccessTokenFromWechat() throws IOException {
		String url = "https://api.weixin.qq.com/cgi-bin/token";
		Response response = OkHttpUtils.get().url(url)
				.addParams("grant_type","client_credential")
				.addParams("appid",appid)
				.addParams("secret",appsecret)
				.id(101)
				.build().execute();
		logger.debug("get wechat access token suucess:{}", response.body().string());
		Gson gson = new Gson();
		WechatAccessToken wechatAccessToken = gson.fromJson(response.body().string(), WechatAccessToken.class);
		Jedis jedis = jedisPool.getResource();
		String result = jedis.set(WechatParams.ACCESS_TOKEN_KEY, wechatAccessToken.getAccess_token(), "NX", "EX", wechatAccessToken.getExpires_in());
		if (result != null) {
			logger.debug("set access token to redis success");
		}
	}

	@Override
	public WechatAccessToken getAccessTokenFromRedis() throws Exception {
		Jedis jedis = jedisPool.getResource();
		if (jedis == null) {
			throw new Exception("Redis is not rechable");
		}

		String mutexKey = WechatParams.ACCESS_TOKEN_KEY_MUTEX;
		return null;
	}

	public static void main(String[] args) {
		String url = "https://api.weixin.qq.com/cgi-bin/token";
		try {
			Response response = OkHttpUtils.get().url(url)
					.addParams("grant_type","client_credential")
					.addParams("appid","wxc896cbf87e374920")
					.addParams("secret","485903fc8d413e3ee05d86f37db81c6e")
					.build().execute();
			System.out.println(response.body().string());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
