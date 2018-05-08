package cn.com.architecture.net.netty4.udp;

import cn.com.architecture.net.IHandlerNetty4Udp;
import cn.com.architecture.net.utils.IpUtil;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.epoll.EpollChannelOption;
import io.netty.channel.epoll.EpollDatagramChannel;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * netty4启动
 *
 * @author Pan
 * 2015年11月12日
 */
public final class Netty4UdpSocketServer {

	private static final Logger logger = LoggerFactory.getLogger(Netty4UdpSocketServer.class);

	private final IHandlerNetty4Udp handler;
	private final int port;
	private String[] ips = null;//绑定哪些ip,不指定就绑定所有,new String[]{"183.60.126.110","183.232.43.121","163.177.25.10"};

	/**
	 * @param handler 处理类
	 * @param _ips 指定绑定的ip(多网卡时),不指定就绑定所有
	 * @param port port
	 */
	public Netty4UdpSocketServer(IHandlerNetty4Udp handler, String[] _ips,int port) {
		this.handler = handler;
		this.ips = _ips;
		this.port = port;
		
		if(this.ips == null){//绑定所有
			this.ips = IpUtil.getAllLocalHostIPv4();
		}
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
	 * UDP服务器:通用模式
	 * @throws InterruptedException
	 */
	private void startNormal() throws InterruptedException {
		logger.info("Netty4UdpSocketServer startUdp---Normal, port = " + port);
		
//		 int DEFAULT_EVENT_LOOP_THREADS = Math.max(1, SystemPropertyUtil.getInt(
//	                "io.netty.eventLoopThreads", Runtime.getRuntime().availableProcessors() * 2));
		
		int RCVBUF = 900*1024;//接收缓存多少合适?大了影响延迟,小了影响丢包率^v^
		int SNDBUF = 900*1024;//发送缓存多少合适?

		final NioEventLoopGroup group = new NioEventLoopGroup();//DEFAULT_EVENT_LOOP_THREADS
		Bootstrap bootstrap = new Bootstrap();
		bootstrap.group(group);
		bootstrap.channel(NioDatagramChannel.class);
//		bootstrap.option(ChannelOption.SO_BROADCAST, true);
		bootstrap.option(ChannelOption.SO_RCVBUF,RCVBUF);
		bootstrap.option(ChannelOption.SO_SNDBUF,SNDBUF);
		
//		bootstrap.option(ChannelOption.RCVBUF_ALLOCATOR,new FixedRecvByteBufAllocator(512));//是否需要设置接收buff上限(数据包最大长度),默认是2048
		bootstrap.option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);//是否使用内存池
		
		bootstrap.handler(new Netty4UdpSocketHandler(handler));
//		bootstrap.handler(new ChannelInitializer<NioDatagramChannel>() {
//			@Override
//			protected void initChannel(NioDatagramChannel ch) throws Exception {
//				ChannelPipeline cp = ch.pipeline();
//				cp.addLast("handler", new Netty4UdpSocketHandler(handler));//处理类
//				
//				logger.info("ChannelOption.ALLOCATOR=" + ch.config().getOption(ChannelOption.ALLOCATOR));
//			}
//		});
		
		logger.info("bootstrap=" +bootstrap.toString());
		
		// 绑定并监听端口
		for (String ip : ips) {
			logger.info("Upd绑定ip=" + ip + ",port=" + port);
			ChannelFuture f = bootstrap.bind(ip,port).sync();//线程同步阻塞等待服务器绑定到指定端口
		}
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				group.shutdownGracefully();
			}
		});
//		// 监听服务器关闭监听
//		f.channel().closeFuture().sync();//成功绑定到端口之后,给channel增加一个 管道关闭的监听器并同步阻塞,直到channel关闭,线程才会往下执行,结束进程
		
		logger.info("Netty4UdpSocketServer ok,bind at :" + port + ",RCVBUF=" + RCVBUF);
	}
	
	/**
	 * UDP服务器:Linux专用模式,单进程多线程绑定同一端口
	 * @throws InterruptedException
	 */
	private void startEpoll() throws InterruptedException {
		logger.info("Netty4UdpSocketServer startUdp---Epoll, port = " + port);
		
//		 int DEFAULT_EVENT_LOOP_THREADS = Math.max(1, SystemPropertyUtil.getInt(
//	                "io.netty.eventLoopThreads", Runtime.getRuntime().availableProcessors() * 2));
		
		int RCVBUF = 900*1024;//接收缓存多少合适?大了影响延迟,小了影响丢包率^v^
		int SNDBUF = 900*1024;//发送缓存多少合适?
		
		Bootstrap bootstrap = new Bootstrap();
		final EventLoopGroup group = new EpollEventLoopGroup();
		bootstrap.group(group)
				.channel(EpollDatagramChannel.class)
				.option(EpollChannelOption.SO_REUSEPORT, true)
				.option(ChannelOption.SO_RCVBUF,RCVBUF)
				.option(ChannelOption.SO_SNDBUF,SNDBUF);
		
//		bootstrap.option(ChannelOption.RCVBUF_ALLOCATOR,new FixedRecvByteBufAllocator(512));//是否需要设置接收buff上限(数据包最大长度),默认是2048
		bootstrap.option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);//是否使用内存池
		
		final Netty4UdpSocketHandler h = new Netty4UdpSocketHandler(handler);
		bootstrap.handler(h);
//		bootstrap.handler(new ChannelInitializer<EpollDatagramChannel>() {
//			@Override
//			protected void initChannel(EpollDatagramChannel ch) throws Exception {
//				ChannelPipeline cp = ch.pipeline();
//				cp.addLast("handler",h);//处理类
//				
//				logger.info("ChannelOption.ALLOCATOR=" + ch.config().getOption(ChannelOption.ALLOCATOR));
//			}
//		});
		
		logger.info("bootstrap=" +bootstrap.toString());
		int workerThreads = Math.max(1, Runtime.getRuntime().availableProcessors()/2);//启动几个监听比较合适?
		for (String ip : ips) {
			logger.info("Upd绑定ip=" + ip + ",port=" + port);
			for (int i = 0; i < workerThreads; ++i) {// 绑定并监听端口
				logger.info("      Epoll bind:" + (i + 1) + "/" + workerThreads);
				ChannelFuture future = bootstrap.bind(ip,port).await();
				if (!future.isSuccess()) {
					logger.error(String.format("绑定失败: bind on port = %d.", port),future.cause());
				}else{
//					logger.info("成功绑定: bind on port = " + port);
				}
			}
		}

		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				group.shutdownGracefully();
			}
		});
		
//		// 监听服务器关闭监听
//		f.channel().closeFuture().sync();
		
		logger.info("Netty4UdpSocketServer ok,bind at :" + port + ",RCVBUF=" + RCVBUF);
	}

}
