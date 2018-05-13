package cn.com.architecture.net.netty4.tcp.handler;

import cn.com.architecture.net.IHandlerNetty4;
import cn.com.architecture.net.netty4.common.Netty4Utils;
import cn.com.architecture.net.netty4.common.constant.NettyChannelConstant;
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
public class GateNetHandler implements IHandlerNetty4 {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void onConnect(ChannelHandlerContext ctx) {
		String ip = Netty4Utils.getIp(ctx);

		@SuppressWarnings("unchecked")
		HashMap<String,Object> context = (HashMap<String, Object>) ctx.channel().attr(NettyChannelConstant.NETTY_ATTR_KEY_1).get();
		if(context == null){
			context = new HashMap<String,Object>();
			ctx.channel().attr(NettyChannelConstant.NETTY_ATTR_KEY_1).set(context);
		}

		long channelId = GameNetHandler.getInstance().onConnect(ip,ctx);
		context.put(NettyChannelConstant.CHANNELID, channelId);

		logger.info("创建连接:" + ip + ",gateway_onConnect_local=" + channelId);
	}

	@Override
	public void onReceive(ChannelHandlerContext ctx, byte[] bytes) {
		long ti = System.currentTimeMillis();

		@SuppressWarnings("unchecked")
		HashMap<String,Object> context = (HashMap<String, Object>) ctx.channel().attr(NettyChannelConstant.NETTY_ATTR_KEY_1).get();
		long channelId = (long) context.get(NettyChannelConstant.CHANNELID);
//		UserNetChannelObj channelObj = UserManager.getInstance().getChannelById(channelId);
//		if(channelObj == null || channelObj.isDead()){//已经被踢下线
//			logger.error("收到未处理协议,已经被踢下线,netChannelId=" + channelId);
//			return;
//		}
//
//		channelObj.getActor().onReceive(channelId, bytes);

		if(System.currentTimeMillis() - ti > 100){
			logger.error("处理慢:onReceive耗时=" + (System.currentTimeMillis() - ti));
		}
	}

	@Override
	public void onClose(ChannelHandlerContext ctx) {
		long ti = System.currentTimeMillis();

//		@SuppressWarnings("unchecked")
//		HashMap<String,Object> context = (HashMap<String, Object>) ctx.channel().attr(GameMain.NETTY_ATTR_KEY_1).get();
//		long channelId = (long) context.get("channelId");
//		logger.info("断开连接,IP=" + Netty4Utils.getIp(ctx) + ",gateway_onClose_local=" + channelId);
//		GameNetHandler.getInstance().onClose(channelId);

		if(System.currentTimeMillis() - ti > 100){
			logger.error("处理慢:onClose耗时=" + (System.currentTimeMillis() - ti));
		}
	}

	@Override
	public void onException(ChannelHandlerContext ctx, Throwable e) {
		if (!(e instanceof ClosedChannelException)) {
			e.printStackTrace();
//			logger.error("!!!", e);
		}
	}
	
}
