package cn.com.architecture.net.netty4.common;

import io.netty.channel.ChannelHandlerContext;

import java.net.InetSocketAddress;

/**
 * @author lst
 * 2018年5月13日
 */
public class Netty4Utils {

	public static String getIp(ChannelHandlerContext ctx){

		InetSocketAddress address = (InetSocketAddress) ctx.channel().remoteAddress();

		return address.getAddress().getHostAddress();
	}
}
