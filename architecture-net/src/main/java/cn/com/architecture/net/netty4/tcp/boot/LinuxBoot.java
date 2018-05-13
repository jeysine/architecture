package cn.com.architecture.net.netty4.tcp.boot;

import cn.com.architecture.net.IHandlerNetty4;
import cn.com.architecture.net.netty4.common.Netty4Decoder;
import cn.com.architecture.net.netty4.common.Netty4Encoder;
import cn.com.architecture.net.netty4.common.NettyHeartbeat;
import cn.com.architecture.net.netty4.tcp.handler.Netty4SocketHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.*;
import io.netty.channel.epoll.EpollChannelOption;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.epoll.EpollServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.timeout.IdleStateHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by li on 2018/5/13.
 */

public class LinuxBoot extends AbstractBoot{

    private static final Logger logger = LoggerFactory
            .getLogger(LinuxBoot.class);


    /**
     * @param handler 处理类
     * @param port
     * @param timeout
     */
    public LinuxBoot(IHandlerNetty4 handler, int port, int timeout) {
        super(handler, port, timeout);
    }

    @Override
    public void start() {

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
