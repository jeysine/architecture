package cn.com.architecture.net.netty4.tcp.handler;

import cn.com.architecture.net.IHandlerNetty4;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;


/**
 * 
 *
 * @author lst
 * 2018年5月13日
 */
@Sharable
public final class Netty4SocketHandler extends SimpleChannelInboundHandler<Object> {

	private IHandlerNetty4 handler;

	public Netty4SocketHandler(IHandlerNetty4 handler) {
		this.handler = handler;
	}

	/**
	 * 建立链接
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
//		System.out.println("channelActive:建立链接");
		handler.onConnect(ctx);
	}
	
	/**
	 * 链接断开
	 */
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
//		System.out.println("channelInactive:链接断开");
		handler.onClose(ctx);
	}
	
	/**
	 * 收到消息:netty4
	 */
//	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		doRead(ctx,msg);
	}
	
	/**
	 * 收到消息:netty5
	 */
//	@Override
	protected void messageReceived(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		doRead(ctx,msg);
	}
	
	private void doRead(ChannelHandlerContext ctx, Object msg) {
		try {
//			System.out.println("channelRead0:收到消息:msg=" + msg);
			
			ByteBuf in = (ByteBuf) msg;
//			System.out.println("收到消息:in.readableBytes()=" + in.readableBytes());
			byte[] bytes = new byte[in.readableBytes()];
			in.readBytes(bytes);
			
			handler.onReceive(ctx, bytes);
	    } finally {//需要收到释放吗?
//	        ReferenceCountUtil.release(msg);
	    }
	}
	
	/**
	 * 异常
	 */
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
//		System.out.println("exceptionCaught:异常");
		handler.onException(ctx, cause);
	}

}