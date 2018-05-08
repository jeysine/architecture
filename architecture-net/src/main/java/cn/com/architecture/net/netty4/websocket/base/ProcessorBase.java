package cn.com.architecture.net.netty4.websocket.base;

import cn.com.architecture.net.netty4.websocket.session.IPlayerSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Created by linchm on 2016/5/25.
 */
public abstract class ProcessorBase<REQ extends RequestBase, RESP extends ResponseBase> implements IProcessor {
    private static final Logger logger = LoggerFactory.getLogger(ProcessorBase.class);

    protected RESP response;
    private Entrance entrance;

    public ProcessorBase(){
        initResponse();
    }

    protected abstract void initResponse();

    public void handle(IPlayerSession playerSession, RequestBase request) {

        try {
            initResponse();
        //    response.setRetCode((short) 0);
        //    response.reset();
//            if (playerSession.getPlayer() != null){
//                PlayerComponent playerComponent = (PlayerComponent) playerSession.getPlayer().getComponent(PlayerComponent.class);
//                if (playerComponent != null){
//                    playerComponent.clickIncrement();
//                }
//            }

            process(playerSession, (REQ) request);
        } catch (Exception e) {
            e.printStackTrace();
//            logger.error("消息处理出错，code:" + request.getEventId() + ", msg:" + request.toString());
//            logger.error(e.getMessage(),e);
        }
    }

    protected void process(IPlayerSession playerSession, REQ request) throws Exception{
        short retCode = handleRequest(playerSession, request);
//        response.setRetCode(retCode);
//        playerSession.sendMessage(response);
    }

    /**
     *  处理请求并返回错误码，正常流程返回0
     * @param playerSession
     * @param request
     * @return ErrorCode.SUCESS
     */
    protected abstract short handleRequest(IPlayerSession playerSession, REQ request);

    protected RESP getResponse() {
        return response;
    }


    public void handleException(IPlayerSession playerSession, short errorCode){
//        response.setRetCode(errorCode);
//        playerSession.sendMessage(response);
    }

    public void setEntrance(Entrance entrance) {
        this.entrance = entrance;
    }

    public boolean isOpen(){
        if (null == entrance)
            return true;
        return entrance.isOpenFlag();
    }

}