package cn.com.architecture.net.netty4.websocket.communication;

/**
 * A class that transmits messages reliably to remote machines/vm's. Internally
 * this class uses Netty tcp {@link io.netty.channel.Channel} to transmit the message.
 * Created by linchm on 2016/5/25.
 */

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class NettyTCPMessageSender implements MessageSender {
    private final Channel channel;
    private static final Logger LOG = LoggerFactory
            .getLogger(NettyTCPMessageSender.class);

    public NettyTCPMessageSender(Channel channel) {
        super();
        this.channel = channel;
    }

    @Override
    public Object sendMessage(Object message) {
        return channel.writeAndFlush(message);
    }

    @Override
    public void sendMessage(ByteBuf out) {
        channel.writeAndFlush(new BinaryWebSocketFrame(out));
    }

    public Channel getChannel() {
        return channel;
    }

    @Override
    public void close() {
        LOG.debug("Going to close tcp connection in class: {}", this.channel);
        //todo: 关掉sender时，发
        if(channel.isOpen())
            channel.close();
//        Event event = Events.event(null, Events.DISCONNECT);
//        if (channel.isActive()) {
//            channel.write(null).addListener(ChannelFutureListener.CLOSE);
//        }
//        else
//        {
//            channel.close();
//            LOG.trace("Unable to write the Event {} with type {} to socket",
//                    event, event.getType());
//        }
    }

    @Override
    public String toString() {
        String channelId = "TCP channel: ";
        if (null != channel) {
            channelId += channel.toString();
        } else {
            channelId += "0";
        }
        String sender = "Netty " + channelId;
        return sender;
    }


}
