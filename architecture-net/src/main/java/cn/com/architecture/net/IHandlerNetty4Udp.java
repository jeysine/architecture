package cn.com.architecture.net;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;

/**
 * IHandler
 *
 * @author lst
 */
public interface IHandlerNetty4Udp {
	
	void onReceive(ChannelHandlerContext ctx, DatagramPacket msg, byte[] bytes);
	
}
