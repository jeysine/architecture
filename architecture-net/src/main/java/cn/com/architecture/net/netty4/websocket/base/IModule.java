package cn.com.architecture.net.netty4.websocket.base;

/**
 * 对应游戏里的逻辑模块，每个模块有该模块的所有协议处理器
 * 方便处理器权限的控制
 * Created by p on 2016-09-27.
 */
public interface IModule {
    IProcessor getProcessor(int msgId);

    void addProcessor(int msgId, IProcessor processor);

    boolean isOpen();

    void setOpen(boolean open);

}
