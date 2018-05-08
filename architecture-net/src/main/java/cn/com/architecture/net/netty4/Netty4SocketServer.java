package cn.com.architecture.net.netty4;

import cn.com.architecture.net.IHandlerNetty4;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.*;
import io.netty.channel.epoll.EpollChannelOption;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.epoll.EpollServerSocketChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.timeout.IdleStateHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * netty4启动
 * @author lst
 * 2015年11月12日
 */
public final class Netty4SocketServer {

	private static final Logger logger = LoggerFactory
			.getLogger(Netty4SocketServer.class);

	private final IHandlerNetty4 handler;
	private final int port;
	private final int timeout;

	/**
	 * @param handler
	 *            处理类
	 * @param timeout
	 *            超时时间（秒）
	 */
	public Netty4SocketServer(IHandlerNetty4 handler, int port, int timeout) {
		this.handler = handler;
		this.port = port;
		this.timeout = timeout;
	}
	
	public void start() throws InterruptedException{
		String OSName = System.getProperty("os.name").toLowerCase();//操作系统名称
		String osVersion = System.getProperty("os.version"); //操作系统版本
		System.out.println("OSName=" + OSName + ",osVersion=" + osVersion);
		if(OSName.indexOf("linux") != -1){//linux系统:OSName=linux,osVersion=3.10.0-229.el7.x86_64
			startEpoll();//Linux专用高效模式
		}else{
			startNormal();//通用模式
		}
	}

	/**
	 * TCP服务器
	 * @throws InterruptedException
	 */
	private void startNormal() throws InterruptedException {
		logger.info("Netty4SocketServer start---Normal, port = " + port);
		
		final NioEventLoopGroup bossGroup = new NioEventLoopGroup();
		final NioEventLoopGroup workerGroup = new NioEventLoopGroup();

		ServerBootstrap bootstrap = new ServerBootstrap();
		bootstrap.group(bossGroup, workerGroup);
		bootstrap.channel(NioServerSocketChannel.class);
		bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
		bootstrap.option(ChannelOption.TCP_NODELAY, true);
		bootstrap.option(ChannelOption.SO_BACKLOG, 128);//允许多少个新请求进入等待
		
		bootstrap.option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);//是否使用内存池
		bootstrap.childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);//是否使用内存池
		
		bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
			@Override
			protected void initChannel(SocketChannel ch) throws Exception {
				ChannelPipeline cp = ch.pipeline();
				
				cp.addLast(new Netty4Decoder(1024*1024, 0, 4, 0, 4));//基于长度的解码器:1024*1024, 0, 4, 0, 4
				cp.addLast(new LengthFieldPrepender(4));//顶层编码器
				cp.addLast(new Netty4Encoder());//我们的编码器:byte[]-->ByteBuf
				
				cp.addLast("handler", new Netty4SocketHandler(handler));//处理类
				
				if (timeout > 0) {
					cp.addLast("idleTimeoutHandler", new IdleStateHandler(0, 0, timeout, TimeUnit.SECONDS));
					cp.addLast("heartbeatHandler", new NettyHeartbeat());
				}
			}
		});
		
		logger.info("bootstrap=" +bootstrap.toString());
		
		// 绑定并监听端口
		ChannelFuture f = bootstrap.bind(port).sync();//线程同步阻塞等待服务器绑定到指定端口
		
//		// 监听服务器关闭监听
//		f.channel().closeFuture().sync();//成功绑定到端口之后,给channel增加一个 管道关闭的监听器并同步阻塞,直到channel关闭,线程才会往下执行,结束进程

		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				bossGroup.shutdownGracefully();
				workerGroup.shutdownGracefully();
			}
		});
		
		logger.info("Netty4SocketServer ok,bind at :" + port);
	}
	
	/**
	 * Linux专用模式,单进程多线程绑定同一端口
	 * @throws InterruptedException 
	 * @throws Exception
	 */
	private void startEpoll() throws InterruptedException {
		logger.info("Netty4SocketServer start---Epoll, port = " + port);
		final EventLoopGroup bossGroup = new EpollEventLoopGroup();
		final EventLoopGroup workerGroup = new EpollEventLoopGroup();
		ServerBootstrap bootstrap = new ServerBootstrap();

		bootstrap.group(bossGroup, workerGroup)
				.channel(EpollServerSocketChannel.class)
				.option(ChannelOption.SO_REUSEADDR, true)
				.option(EpollChannelOption.SO_REUSEPORT, true)
				.childOption(ChannelOption.SO_KEEPALIVE, true);

		bootstrap.option(ChannelOption.TCP_NODELAY, true);
		bootstrap.option(ChannelOption.SO_BACKLOG, 128);// 允许多少个新请求进入等待
		
		bootstrap.option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);//是否使用内存池
		bootstrap.childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);//是否使用内存池

		final Netty4SocketHandler h = new Netty4SocketHandler(handler);
		bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
			@Override
			protected void initChannel(SocketChannel ch) throws Exception {
				ChannelPipeline cp = ch.pipeline();

				cp.addLast(new Netty4Decoder(1024 * 1024, 0, 4, 0, 4));//基于长度的解码器:1024*1024, 0, 4, 0, 4
				cp.addLast(new LengthFieldPrepender(4));// 顶层编码器
				cp.addLast(new Netty4Encoder());// 我们的编码器:byte[]-->ByteBuf

				cp.addLast("handler",h);// 处理类

				if (timeout > 0) {
					cp.addLast("idleTimeoutHandler", new IdleStateHandler(0, 0,timeout, TimeUnit.SECONDS));
					cp.addLast("heartbeatHandler", new NettyHeartbeat());
				}
			}
		});
		
		logger.info("bootstrap=" +bootstrap.toString());

		int workerThreads = Math.max(1, Runtime.getRuntime().availableProcessors());//启动几个监听比较合适?
		// new thread
		for (int i = 0; i < workerThreads; ++i) {
			System.out.println("Epoll bind:" + (i + 1) + "/" + workerThreads);
			ChannelFuture future = bootstrap.bind(port).await();
			if (!future.isSuccess()) {
				logger.error(String.format("绑定失败: bind on port = %d.", port),future.cause());
			}else{
				logger.info("成功绑定: bind on port = " + port);
			}
		}
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				workerGroup.shutdownGracefully();
				bossGroup.shutdownGracefully();
			}
		});
		
		logger.info("Netty4SocketServer ok,bind at :" + port);
	}

}
