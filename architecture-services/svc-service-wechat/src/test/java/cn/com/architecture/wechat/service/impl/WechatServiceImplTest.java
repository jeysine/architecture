package cn.com.architecture.wechat.service.impl;

import cn.com.architecture.wechat.contants.WechatParams;
import cn.com.architecture.wechat.service.WechatService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.concurrent.CountDownLatch;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:application-context.xml"})
public class WechatServiceImplTest {

	@Autowired
	private WechatService wechatService;

	@Autowired
	private JedisPool jedisPool;

	@org.junit.Test
	public void getAccessToken() throws Exception {
		int amount = 20;
		Thread[] threads = new Thread[amount];
		CountDownLatch endCount = new CountDownLatch(amount);
		CountDownLatch beginCount = new CountDownLatch(1);
		Jedis jedis = jedisPool.getResource();
		jedis.del(WechatParams.ACCESS_TOKEN_KEY);
		jedis.del(WechatParams.ACCESS_TOKEN_KEY_MUTEX);
		for(int i= 0;i < amount;i++){
			threads[i] = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						beginCount.await();
						wechatService.getAccessToken();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			threads[i].start();
		}
		beginCount.countDown();
	}

}