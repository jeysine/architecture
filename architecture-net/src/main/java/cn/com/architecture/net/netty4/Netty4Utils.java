package cn.com.architecture.net.netty4;

import io.netty.channel.ChannelHandlerContext;

import java.net.InetSocketAddress;

/**
 * 
 *
 * @author Pan
 * 2015年11月10日
 */
public class Netty4Utils {

	public static String getIp(ChannelHandlerContext ctx){

		InetSocketAddress address = (InetSocketAddress) ctx.channel().remoteAddress();

		return address.getAddress().getHostAddress();
	}
}
