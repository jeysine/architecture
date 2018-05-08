package cn.com.architecture.net.netty4.websocket.base;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by p on 2016-12-15.
 */
public class ModuleEntrance {
    /**
     * 模块的入口
     */
    private Entrance moduleEntrance = new Entrance();
    /**
     * 每个协议的入口
     */
    private Map<Integer, Entrance> entrances = new HashMap<>();

    /**
     * requestMap
     */
    private Map<Integer, Class> requests = new HashMap<>();

    public void init(int requestId, Class request){
        Entrance entrance = new Entrance();
        entrances.put(requestId, entrance);
        requests.put(requestId, request);
    }


    public Entrance getEntrance(int requestId){
        return entrances.get(requestId);
    }

    public void setEntrance(int requestId, boolean flag){
        Entrance entrance = getEntrance(requestId);
        if (null == entrance)
            return;
        entrance.setOpenFlag(flag);
    }

    public Entrance getModuleEntrance() {
        return moduleEntrance;
    }

    public void setModuleEntrance(boolean flag){
        moduleEntrance.setOpenFlag(flag);
    }

    public RequestBase getRequest(int msgId) {
        Class clazz = requests.get(msgId);
        if (null != clazz){
            try {
                return (RequestBase)clazz.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
