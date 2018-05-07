package cn.com.architecture.net.netty4.websocket.handler;

import cn.com.architecture.net.netty4.websocket.communication.NettyTCPMessageSender;
import cn.com.architecture.net.netty4.websocket.context.MsgConstant;
import cn.com.architecture.net.netty4.websocket.processors.MsgDispatcher;
import cn.com.architecture.net.netty4.websocket.protocol.RequestBase;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PingWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PongWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/**
 * @desc: ws处理
 * @author: xuwenwu
 * @date: 2017/2/5 15:10
 */
public class WSServerHandler extends SimpleChannelInboundHandler<WebSocketFrame> {

    private static final int HEAD_LEN = 5;
    private Map<Short, RequestBase> requests = new HashMap<>();

    private MsgDispatcher dispatcher;

    // 业务线程池
    private static Executor executor = Fibers.createExecutorService();



    public WSServerHandler(MsgDispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

//    public IPlayerSession getPlayerSession() {
//        return playerSession;
//    }
//
//    public void setPlayerSession(IPlayerSession playerSession) {
//        this.playerSession = playerSession;
//    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
//        if (null == playerSession) {
//            PlayerSession.PlayerSessionBuilder builder = new PlayerSession.PlayerSessionBuilder();
//            builder.validateAndSetValues();
//            playerSession = (IPlayerSession) builder.status(ISession.Status.CONNECTING).isLogin(false).writeable(true).build();
            NettyTCPMessageSender wsSender = new NettyTCPMessageSender(ctx.channel());
//            playerSession.setTcpSender(wsSender);
//        }
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, WebSocketFrame msg) throws Exception {
        handleWebSocketFrame(ctx, msg);
    }

    private RequestBase decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception{
        if(in.equals(Unpooled.EMPTY_BUFFER)){
            closeConnection(ctx);
            return null;
        }
        if(in.readableBytes() < HEAD_LEN) return null;

        in.markReaderIndex();
        short requestId = in.readShort();
        byte codeType = in.readByte();//标识
        short bodySize = in.readShort();

        if(in.readableBytes() >= bodySize){
            RequestBase request = getRequest(requestId);
            if (null == request){
                in.skipBytes(bodySize);
                return null;
            }
            request.reset();
            //todo: 重置 反系列化
            if(codeType == CodeTypeConstant.BINARY){
                request.unserial(in);
            }else if(codeType == CodeTypeConstant.MSGPACK){
                byte[] bytes = new byte[bodySize];
                in.readBytes(bytes);
                request = MsgpackUtil.readPack(bytes, request.getClass());
            }else{
                request.unserial(in);
            }
//            System.out.println("request:"+ GsonUtil.toJson(request));
            return request;
        }else{
            in.resetReaderIndex();
        }
        return null;
    }

    private RequestBase getRequest(short requestId){
        RequestBase request = requests.get(requestId);
        if (null == request){
            request = MsgDispatcher.getRequest(requestId);
            requests.put(requestId, request);
        }
        return request;
    }


    private void handleWebSocketFrame(ChannelHandlerContext ctx, WebSocketFrame frame) throws Exception {
        if(frame instanceof BinaryWebSocketFrame){
            RequestBase request = decode(ctx, frame.content());
            if(null == request)
                return;
            short eventId = request.getEventId();
            //创角，进入游戏等协议放入另外的线程池处理
            if (eventId == MsgConstant.REQ_ENTER_GAME || /**eventId == MsgConstant.REQ_CREATE_PLAYER ||**/ eventId == MsgConstant.REQ_LOGIN){
                executor.execute(() -> dispatcher.dispatch(playerSession, request));
            }else
                dispatcher.dispatch(playerSession, request);
    //        String str = ctx.channel().remoteAddress().toString();
//            if (str.contains("192.168.0.252"))
//                dispatcher.dispatch(playerSession, request);
//            else
//            {
//                short eventId = request.getEventId();
//                if (eventId == 10001 || eventId == 10002 || eventId == 10003 || eventId == 10010)
//                    dispatcher.dispatch(playerSession, request);
//
//            }
//            executor.execute(() ->{
//                if(null != request) dispatcher.dispatch(playerSession, request);
//            });
        }else if (frame instanceof PingWebSocketFrame) {
            //判断是否Ping消息 -- ping/pong心跳包
            System.out.println("ping/pong心跳包");
            ctx.channel().write(new PongWebSocketFrame(frame.content().retain()));
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        //playerLogout(ctx);
        super.channelInactive(ctx);
    }

    public void closeConnection(ChannelHandlerContext ctx) throws Exception{
        //playerLogout(ctx);
    }

    //玩家下线
    public void playerLogout(ChannelHandlerContext ctx){
        //todo 玩家下线
//        try {
//            IPlayer player = playerSession.getPlayer();
//        /*
//         * 当状态等于RE_CONNECTING,用户正通过另外的channel登录,此时不要做登录操作
//         */
////            if(null != player && playerSession.getStatus() != ISession.Status.RE_CONNECTING) {
////                if (playerSession.isLogin())
////                    player.logout();
////                playerSession.setLogin(false);
////            }
//            if (null != player){
//                if (playerSession.getStatus() == ISession.Status.RE_CONNECTING){
//                    PlayerComponent playerComponent = (PlayerComponent)player.createIfNotExist(PlayerComponent.class);
//                    playerComponent.setLoginOutTime(TimeUtil.currentTime());
//                }else {
//                    if (playerSession.isLogin())
//                        player.logout();
//                    playerSession.setLogin(false);
//                }
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        } finally {
//            if (ctx.channel().isActive()){
//                ctx.channel().close();
//            }
//            ctx.close();
//        }
    }


    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        //顶号处理
        super.channelUnregistered(ctx);
    }
}