package cn.com.architecture.net.netty4.websocket.base;

import cn.com.architecture.net.netty4.websocket.session.IPlayerSession;

/**
 * 标志接口，实现此处理器的processor不需要验证
 * Created by linchm on 2016/5/25.
 */
public interface IProcessor {
    void handle(IPlayerSession playerSession, RequestBase request);

    void handleException(IPlayerSession playerSession, short errorCode);

    boolean isOpen();

    void setEntrance(Entrance entrance);
}
