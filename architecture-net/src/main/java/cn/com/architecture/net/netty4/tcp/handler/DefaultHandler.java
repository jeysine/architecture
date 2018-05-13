package cn.com.architecture.net.netty4.tcp.handler;

import cn.com.architecture.net.IHandlerNetty4;
import cn.com.architecture.net.netty4.common.Netty4Utils;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.channels.ClosedChannelException;
import java.util.HashMap;

/**
 * 游戏服本身也可以是网关服务器
 *
 * @author Pan
 * 2015年10月26日
 */
public class DefaultHandler implements IHandlerNetty4 {

	private Logger logger = LoggerFactory.getLogger(getClass());


	@Override
	public void onConnect(ChannelHandlerContext ctx) {
		String ip = Netty4Utils.getIp(ctx);
		logger.info("创建连接:" + ip );
	}

	@Override
	public void onReceive(ChannelHandlerContext ctx, byte[] bytes) {
		logger.info("收到消息");
	}

	@Override
	public void onClose(ChannelHandlerContext ctx) {
		logger.info("链接关闭");
	}

	@Override
	public void onException(ChannelHandlerContext ctx, Throwable e) {
		if (!(e instanceof ClosedChannelException)) {
			e.printStackTrace();
//			logger.error("!!!", e);
		}
	}
	
}
