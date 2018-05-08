package cn.com.architecture.net;

import io.netty.channel.ChannelHandlerContext;

/**
 * IHandler
 *
 * @author lst
 */
public interface IHandlerNetty4 {
	void onConnect(ChannelHandlerContext ctx);

	void onReceive(ChannelHandlerContext ctx, byte[] bytes);

	void onClose(ChannelHandlerContext ctx);

	void onException(ChannelHandlerContext ctx, Throwable e);
}
