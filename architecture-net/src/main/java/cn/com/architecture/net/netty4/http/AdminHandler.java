/**
 * 2011-1-26
 * XiYouGameServer
 * @author eric.chan
 **/
package cn.com.architecture.net.netty4.http;

import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class AdminHandler implements IAdminHandler {

	private static final Logger logger = LoggerFactory
			.getLogger(AdminHandler.class);

	@Override
	public void exec(FullHttpRequest request, FullHttpResponse response) {
		if (request.uri().endsWith("stop")) {//请求关服
			System.out.println("服务器已经停止");
		} else if (request.getUri().endsWith("thread")) {
			Map<Thread, StackTraceElement[]> maps = Thread.getAllStackTraces();
			for (Thread t : maps.keySet()) {
				StackTraceElement[] st = maps.get(t);
				System.out.println(t.getName());
				for (StackTraceElement s : st) {
					System.out.println(s);
				}
				System.out.println("-----------------------");
			}
		}
	}

}
