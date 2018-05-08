package cn.com.architecture.net.netty4.websocket;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.ChannelGroupFuture;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by linchm on 2016/5/18.
 */
public abstract class AbstractNettyServer implements NettyServer {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractNettyServer.class);

    public static final ChannelGroup ALL_CHANNELS = new DefaultChannelGroup("DROGONBALL-CHANNELS", GlobalEventExecutor.INSTANCE);

    protected final NettyConfig nettyConfig;
    protected ChannelInitializer<? extends Channel> channelInitializer;

    public AbstractNettyServer(NettyConfig nettyConfig,
                               ChannelInitializer<? extends Channel> channelInitializer) {
        this.nettyConfig = nettyConfig;
        this.channelInitializer = channelInitializer;
    }

    @Override
    public ChannelInitializer<? extends Channel> getChannelInitializer() {
        return channelInitializer;
    }

    @Override
    public void setChannelInitializer(ChannelInitializer<? extends Channel> initializer) {
        this.channelInitializer = initializer;
    }

    public void stopServer() throws Exception {
        LOG.debug("In stopServer method of class: {}", this.getClass()
                .getName());
        ChannelGroupFuture future = ALL_CHANNELS.close();
        try {
            future.await();
        } catch (InterruptedException e) {
            LOG.error(
                    "Execption occurred while waiting for channels to close: {}",
                    e);
        } finally {

            if (null != nettyConfig.getBossGroup()) {
                nettyConfig.getBossGroup().shutdownGracefully();
            }
            if (null != nettyConfig.getWorkerGroup()) {
                nettyConfig.getWorkerGroup().shutdownGracefully();
            }
        }
    }

    @Override
    public NettyConfig getNettyConfig() {
        return nettyConfig;
    }

    protected EventLoopGroup getBossGroup() {
        return nettyConfig.getBossGroup();
    }

    protected EventLoopGroup getWorkerGroup() {
        return nettyConfig.getWorkerGroup();
    }

    /**
     * 打印nettyServer地址和端口
     */
    @Override
    public String toString() {
        return "NettyServer [socketAddress=" + nettyConfig.getSocketAddress()
                + ", portNumber=" + nettyConfig.getPortNumber() + "]";
    }

}
