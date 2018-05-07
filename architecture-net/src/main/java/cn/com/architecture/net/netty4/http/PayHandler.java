/**
 * @author like
 * @date 2011-2-24
 */
package cn.com.architecture.net.netty4.http;


import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;


public class PayHandler implements IAdminHandler {

	public static int pay = 4;//正常支付
	public static int leyingshopPay = 5;//乐赢周边商城支付
	public static int leyingcoin = 6;//乐赢周边代币

	private static final Logger logger = LoggerFactory
			.getLogger(PayHandler.class);
	

	@Override
	public void exec(FullHttpRequest request, FullHttpResponse response) {
		
		String type = pay+"";
		

	}

}
