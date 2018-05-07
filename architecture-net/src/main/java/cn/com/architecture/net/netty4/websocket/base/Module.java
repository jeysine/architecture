package cn.com.architecture.net.netty4.websocket.base;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by p on 2016-09-27.
 */
public class Module implements IModule {
    private int type;
    private final Map<Integer, IProcessor> processorMap = new HashMap<>();
    private final Entrance entrance;

    public Module(int type, Entrance entrance){
        this.type = type;
        this.entrance = entrance;
    }


    @Override
    public IProcessor getProcessor(int msgId) {
        return processorMap.get(msgId);
    }

    @Override
    public void addProcessor(int msgId, IProcessor processor) {
        processorMap.put(msgId, processor);
    }

    public boolean isOpen() {
        return entrance.isOpenFlag();
    }

    public void setOpen(boolean open) {
       entrance.setOpenFlag(open);
    }
}
