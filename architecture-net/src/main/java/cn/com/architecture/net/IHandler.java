package cn.com.architecture.net;

import org.jboss.netty.channel.ChannelHandlerContext;

/**
 * IHandler
 *
 * @author lst
 */
public interface IHandler {

	void onConnect(ChannelHandlerContext ctx);

	void onReceive(ChannelHandlerContext ctx, byte[] bytes);

	void onClose(ChannelHandlerContext ctx);

	void onException(ChannelHandlerContext ctx, Throwable e);

}
