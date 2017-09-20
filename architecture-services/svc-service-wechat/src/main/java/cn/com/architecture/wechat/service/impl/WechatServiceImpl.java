package cn.com.architecture.wechat.service.impl;

import cn.com.architecture.jedis.JedisTemplate;
import cn.com.architecture.wechat.contants.WechatParams;
import cn.com.architecture.wechat.entity.WechatAccessToken;
import cn.com.architecture.wechat.service.WechatService;
import com.google.gson.Gson;
import okhttp3.Call;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import utils.okhttputil.OkHttpUtils;
import utils.okhttputil.callback.StringCallback;

@Service
public class WechatServiceImpl implements WechatService{

	@Value("${wechat.test.appid}")
	private String appid;
	@Value("${wechat.test.appsecret}")
	private String appsecret;

	@Autowired
	private static JedisPool jedisPool;

	@Autowired
	private JedisTemplate jedisTemplate;

	private static Logger logger = LoggerFactory.getLogger(WechatServiceImpl.class);
	@Override
	public void getAccessTokenFromWechat() {
		String url = "https://api.weixin.qq.com/cgi-bin/token";
		OkHttpUtils.get().url(url)
				.addParams("grant_type","client_credential")
				.addParams("appid",appid)
				.addParams("secret",appsecret)
				.id(101)
				.build().execute(new StringCallback() {

			@Override
			public void onError(Call call, Exception e, int id) {
				logger.error("get wechat access token error:", e);
			}

			@Override
			public void onResponse(String response, int id) {
				logger.debug("get wechat access token suucess:{}", response);

			}
		});
	}

	public static void main(String[] args) {
		String url = "https://api.weixin.qq.com/cgi-bin/token";
		OkHttpUtils.get().url(url)
				.addParams("grant_type","client_credential")
				.addParams("appid","wxc896cbf87e374920")
				.addParams("secret","485903fc8d413e3ee05d86f37db81c6e")
				.id(101)
				.build().execute(new StringCallback() {

			@Override
			public void onError(Call call, Exception e, int id) {

			}

			@Override
			public void onResponse(String response, int id) {
				System.out.println(response);
				Gson gson = new Gson();
				WechatAccessToken wechatAccessToken = gson.fromJson(response, WechatAccessToken.class);
				Jedis jedis = jedisPool.getResource();
				jedis.set(WechatParams.ACCESS_TOKEN_KEY, wechatAccessToken.getAccess_token());
			}
		});
	}
}
