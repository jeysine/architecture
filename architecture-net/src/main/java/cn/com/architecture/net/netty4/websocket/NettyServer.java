package cn.com.architecture.net.netty4.websocket;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;

/**
 * specificed to the Netty implementation
 * Created by linchm on 2016/5/18.
 */
public interface NettyServer extends Server {
    /**
     * @return Returns the channel pipeline factory that is associated with this
     * netty server.
     */
    public ChannelInitializer<? extends Channel> getChannelInitializer();

    public void setChannelInitializer(ChannelInitializer<? extends Channel> initializer);

    public NettyConfig getNettyConfig();
}
