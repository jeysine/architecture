package cn.com.architecture.net.netty4.tcp.boot;

import cn.com.architecture.net.IHandlerNetty4;
import cn.com.architecture.net.netty4.common.Netty4Decoder;
import cn.com.architecture.net.netty4.common.Netty4Encoder;
import cn.com.architecture.net.netty4.common.NettyHeartbeat;
import cn.com.architecture.net.netty4.tcp.handler.Netty4SocketHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.timeout.IdleStateHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by li on 2018/5/13.
 */

public class NormalBoot extends AbstractBoot{

    private static final Logger logger = LoggerFactory
            .getLogger(NormalBoot.class);


    /**
     * @param handler 处理类
     * @param port
     * @param timeout
     */
    public NormalBoot(IHandlerNetty4 handler, int port, int timeout) {
        super(handler, port, timeout);
    }

    /**
     * TCP服务器
     * @throws InterruptedException
     */
    @Override
    public void start() throws InterruptedException {
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

}
