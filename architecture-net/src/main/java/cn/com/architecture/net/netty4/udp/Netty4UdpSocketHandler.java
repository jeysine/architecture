package cn.com.architecture.net.netty4.udp;

import cn.com.architecture.net.IHandlerNetty4Udp;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;


/**
 * 
 *
 * @author Pan
 * 2015年11月10日
 */
@Sharable
public final class Netty4UdpSocketHandler extends SimpleChannelInboundHandler<DatagramPacket> {

	private IHandlerNetty4Udp handler;

	public Netty4UdpSocketHandler(IHandlerNetty4Udp handler) {
		this.handler = handler;
	}

	/**
	 * 收到消息:netty4
	 */
//	@Override
	protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket msg)	throws Exception {
//		System.out.println("收到消息:netty4");
		doRead(ctx,msg);
	}
	
	/**
	 * 收到消息:netty5
	 */
//	@Override
	protected void messageReceived(ChannelHandlerContext ctx, DatagramPacket msg) throws Exception {
//		System.out.println("收到消息:netty5");
		doRead(ctx,msg);
	}
	
	int lastM = 0;//流量统计:上一分钟,没有做同步,有可能不准的大致计算
	int inCount = 0;
	
	private void doRead(ChannelHandlerContext ctx, DatagramPacket msg) {
		try {
			
			/**
			//流量统计
			Calendar d1 = Calendar.getInstance();
			int nowM = d1.get(Calendar.MINUTE);
			if(lastM != nowM){
				System.out.println("每秒接收数量:" + inCount/60);
				lastM = nowM;
				inCount = 0;
			}else{
				inCount++;
			}
			*/
			
//			/**
//			String senderIp = msg.sender().getAddress().getHostAddress();
//			int senderPort = dp.sender().getPort();
//			System.out.println("channelRead0:收到消息:ip=" + senderIp);
//			System.out.println("channelRead0:收到消息:port=" + senderPort);
			
			ByteBuf in = msg.content();
			if(in.readableBytes() < 4){
				System.out.println("收到异常消息:in.readableBytes()=" + in.readableBytes());
				return;
			}
//			System.out.println("收到消息:in.readableBytes()=" + in.readableBytes());
			final byte[] bytes = new byte[in.readableBytes()];
			in.readBytes(bytes);
			
			handler.onReceive(ctx, msg,bytes);
			
//			*/
	    } finally {//需要收到释放吗?
//	        ReferenceCountUtil.release(msg);
	    }
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		cause.printStackTrace();
		ctx.close();
	}

}