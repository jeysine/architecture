package cn.com.architecture.net.netty4.websocket.communication;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;

/**
 * Created by linchm on 2016/5/25.
 */
public interface MessageSender {

    /**
     * This method delegates to the underlying native session object to send a
     * message to the client.
     *
     * @param message The message to be sent to client.
     * @return The boolean or future associated with this operation if
     * synchronous or asynchronous implementation respectively.
     */
    public Object sendMessage(Object message);


    public void sendMessage(ByteBuf out);
    /**
     * Since message sender would have a network connection, it would require
     * some cleanup. This method can be overriden to close underlying channels
     * and so on.
     */
    public void close();


    /**
     * return channel
     * @return
     */
    Channel getChannel();

}
