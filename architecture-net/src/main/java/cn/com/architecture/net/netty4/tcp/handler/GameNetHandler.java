package cn.com.architecture.net.netty4.tcp.handler;
/**
 * Created by li on 2018/5/13.
 */


import cn.com.architecture.net.netty4.common.channel.UserNetChannelObj;
import cn.com.architecture.net.netty4.common.dispatcher.Dispatcher;
import cn.com.architecture.net.pack.PackCodec;
import io.netty.channel.ChannelHandlerContext;

import java.lang.reflect.InvocationTargetException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 客户端上行消息处理
 *
 * @author Pan
 * 2015年10月27日
 */
public class GameNetHandler{

    private Logger logger = LoggerFactory.getLogger(getClass());

    private Dispatcher dispatcher = new Dispatcher();

    static GameNetHandler ins = new GameNetHandler();
    private GameNetHandler(){

    }

    public static GameNetHandler getInstance() {
        return ins;
    }

    public long onConnect(String ip, ChannelHandlerContext ctx) {
//        return UserManager.getInstance().newChannel(ip,ctx);
        return 0;
    }

    public PackCodec.Pack onReceive(long channelId, PackCodec.Pack req) {

//        if (req.cmd != ProtocolCode.COMMON_HEART_BEAT) {//TOD 测试收到信息打印
////			System.out.println("req.cmd=" + req.cmd);
//        }

        Dispatcher.Commander commander = dispatcher.getCommander(req.cmd);
        if (commander == null) {
            logger.error("收到未处理协议,cmd=[" + req.cmd + "]");
            return null;
        }

//        PackCodec.Pack rep = null;
//
//        UserNetChannelObj channelObj = UserManager.getInstance().getChannelById(channelId);
//
//        if(channelObj == null || channelObj.isDead()){//已经被踢下线
//            logger.error("收到未处理协议,已经被踢下线,cmd=" + req.cmd + ",netChannelId=" + channelId);
//            return null;
//        }

        if (commander.isMustLogin()){
//            try {
//                PlayerContext pa = PlayerManager.getInstance().getOnlinePlayerById(channelObj.getPlayerId());
//                if(pa != null){
//                    pa.getPlayerActor().process(dispatcher, channelObj.getChannelId(), req);
//                }else{
//                    logger.error("协议处理出现异常,未登陆却发送了需要登录后才能执行的指令,cmd=" + req.cmd + ",ChannelId()=" + channelObj.getChannelId());
//                }
//            } catch (Exception e) {
//                logger.error("协议处理出现异常,cmd=" + req.cmd + ",DataLength=" + req.getDataLength(), e);
//            }
        }
        else {
//            try {
//                rep = dispatcher.invoke(channelObj.getChannelId(), req.cmd, req.data);
//            }  catch (InvocationTargetException e) {
//
//                if (e.getTargetException() instanceof LogicException) {
//
//                    LogicException e1 = (LogicException) e.getTargetException();
//
////					System.out.println("协议上行不合法,code=[" + e1.getCode() + "]");
//
//                    int cmd = req.cmd;
//                    int result = -1;
//                    String info = e1.getCode();
//                    int type = e1.getType();
//                    rep = CommonDefine.getS2CCommontMsg(cmd, result, info, type);
//                }
//                else {
//                    logger.error("协议处理出现异常,cmd=" + req.cmd + ",DataLength=" + req.getDataLength() + ",ChannelId()=" + channelObj.getChannelId(), e);
//
//                    int cmd = req.cmd;
//                    int result = -1;
//                    String info = ExceptionCode.getText(CommonDefine.LANG_DEFAULT, "text_5");
//                    rep = CommonDefine.getS2CCommontMsg(cmd, result, info, 2);
//                }
//            } catch (Exception e2) {
//                logger.error("协议处理出现异常,cmd=" + req.cmd + ",DataLength=" + req.getDataLength() + ",ChannelId()=" + channelObj.getChannelId(), e2);
//
//                int cmd = req.cmd;
//                int result = -1;
//                String info = ExceptionCode.getText(CommonDefine.LANG_DEFAULT, "text_5");
//                rep = CommonDefine.getS2CCommontMsg(cmd, result, info, 2);
//            }
        }

        return null;
    }

    public void onClose(long channelId) {
//        UserNetChannelObj channelObj = UserManager.getInstance().getChannelById(channelId);
//        if(channelObj == null){
//            logger.error("onClose未处理,已经被踢下线,netChannelId=" + channelId);
//            return;
//        }

//        synchronized (channelObj) {
//            if(channelObj.isDead() == false){
//                logger.info("IP:{}断开连接", channelObj.getIp());
//
//                PlayerContext playerContext = PlayerManager.getInstance().getOnlinePlayerById(channelObj.getPlayerId());
//                if (playerContext != null) {
//                    try {
//                        playerContext.onLogout(false);
//                    } catch (Exception e) {
//                        logger.error("玩家下线异常1:",e);
//                    }
//
//                    try {
//                        playerContext.setChannelId(0);
//                        PlayerManager.getInstance().playerLogout(channelId,playerContext);
//                    } catch (Exception e) {
//                        logger.error("玩家下线异常2:",e);
//                    }
//                }
//
//                UserManager.getInstance().removeChannel(channelId);
//                channelObj.stopAkkaActor();
//                channelObj.setDead(true);
//            }
//        }
    }

}
