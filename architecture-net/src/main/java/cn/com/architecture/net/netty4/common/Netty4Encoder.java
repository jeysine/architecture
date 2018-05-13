package cn.com.architecture.net.netty4.common;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 编码器
 */
public final class Netty4Encoder extends MessageToByteEncoder<byte[]>{

	@Override
	protected void encode(ChannelHandlerContext ctx, byte[] sendBytes, ByteBuf out)
			throws Exception {
		out.writeBytes(sendBytes);
	}
	
}
