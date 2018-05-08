package cn.com.architecture.net.netty4.websocket.ws;


import cn.com.architecture.net.netty4.websocket.handler.WSServerHandler;
import cn.com.architecture.net.netty4.websocket.processors.MsgDispatcher;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.codec.http.websocketx.extensions.compression.WebSocketServerCompressionHandler;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.util.concurrent.DefaultEventExecutorGroup;

/**
 * @desc:
 * @author: xuwenwu
 * @date: 2017/1/13 11:55
 */
public class WebSocketServerInitializer extends ChannelInitializer<SocketChannel> {

    private static final String WEBSOCKET_PATH = "/ws";

    private static final int READ_TIMEOUT_SECONDS = 1200;

    private static final int MAX_BUFFER_SIZE = 65536;

    /**
     * 业务逻辑线程池
     */
    private DefaultEventExecutorGroup businessGroup;

    public WebSocketServerInitializer() {

    }

    @Override
    public void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        MsgDispatcher msgDispatcher = new MsgDispatcher();
        pipeline.addLast(new HttpServerCodec());//HttpServerCodec将请求和应答消息编码或解码为HTTP消息
        pipeline.addLast(new HttpObjectAggregator(MAX_BUFFER_SIZE));//通常接收到的http是一个片段，如果想要完整接受一次请求所有数据，我们需要绑定HttpObjectAggregator, 65536定义缓冲大小
        //pipeline.addLast(new ChunkedWriteHandler());///ChunkedWriteHandler 向客户端发送HTML5文件，主要用于支持浏览器和服务器进行WebSocket通信
        pipeline.addLast(new WebSocketServerCompressionHandler());
        pipeline.addLast(new WebSocketServerProtocolHandler(WEBSOCKET_PATH, null, true));
//        pipeline.addLast(new WebSocketIndexPageHandler(WEBSOCKET_PATH));
        pipeline.addLast(new ReadTimeoutHandler(READ_TIMEOUT_SECONDS));//在READ_TIMEOUT_SECONDS秒内没有收到数据就断掉。
        //需要判断玩家连接超时时再增加
    //    pipeline.addLast("idleStateCheck", new IdleStateHandler(MAX_IDLE_SECONDS, MAX_IDLE_SECONDS, MAX_IDLE_SECONDS));
//        pipeline.addLast(businessGroup, new WSServerHandler(msgDispatcher));


        pipeline.addLast(new WSServerHandler(msgDispatcher));
    }

    public void setBusinessGroup(DefaultEventExecutorGroup businessGroup) {
        this.businessGroup = businessGroup;
    }
}