package cn.com.architecture.net.netty4.websocket.processors;

import cn.com.architecture.net.netty4.websocket.base.IModule;
import cn.com.architecture.net.netty4.websocket.base.IProcessor;
import cn.com.architecture.net.netty4.websocket.base.Module;
import cn.com.architecture.net.netty4.websocket.base.ModuleEntrance;
import cn.com.architecture.net.netty4.websocket.constant.ErrorCode;
import cn.com.architecture.net.netty4.websocket.protocol.RequestBase;
import cn.com.architecture.net.netty4.websocket.session.IPlayerSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by linchm on 2016/5/25.
 */
public class MsgDispatcher {
    private static final Logger logger = LoggerFactory.getLogger(MsgDispatcher.class);

    private static final List<ModuleEntrance> entrances;

    private List<IModule> modules;

    //private Set<Integer> lockProtoSet = JsonTableService.getJsonTableKey(SafeLockBean.class);

    private Set<Integer> lockProtoSet = null;

    static {
        entrances = new ArrayList<>();
        int moduleSize = 0;
        for (MsgProcessorRegister register : MsgProcessorRegister.values()) {
            short type = getModIdByMsg(register.getMsgCode());
            if (moduleSize < type)
                moduleSize = type;
        }

        for (int i = 0; i < moduleSize + 1; i++){
            entrances.add(i, new ModuleEntrance());
        }

        for (MsgProcessorRegister register : MsgProcessorRegister.values()) {
            short requestId = register.getMsgCode();
            short moduleId = getModIdByMsg(requestId);
            ModuleEntrance moduleEntrance = entrances.get(moduleId);
            moduleEntrance.init(requestId, register.getRequest());
        }
        logger.info("初始化 消息处理器成功");
    }

    public MsgDispatcher() throws Exception{
        this.modules = new ArrayList<>();
        initModules();
    }

    /**
     * init Modules
     */
    private void initModules(){
        int moduleSize = 0;
        for (MsgProcessorRegister register : MsgProcessorRegister.values()) {
            short type = getModIdByMsg(register.getMsgCode());
            if (moduleSize < type)
                moduleSize = type;
        }
        for (int i = 0; i < moduleSize + 1; i++){
            ModuleEntrance moduleEntrance = entrances.get(i);
            modules.add(i, new Module(i, moduleEntrance.getModuleEntrance()));
        }

        for (MsgProcessorRegister register : MsgProcessorRegister.values()) {
            addToModule(register);
        }
    }
    /**
     * add to module
     * @param register
     */
    private void addToModule(MsgProcessorRegister register){
        short moduleId = getModIdByMsg(register.getMsgCode());
        IModule module = modules.get(moduleId);
        ModuleEntrance moduleEntrance = entrances.get(moduleId);
        IProcessor processor = getProcessor(register.getMsgProcessor());
        if(null == processor) return;
        processor.setEntrance(moduleEntrance.getEntrance(register.getMsgCode()));
        module.addProcessor(register.getMsgCode(), processor);
    }

    public IProcessor getProcessor(Class processor) {
        if (null != processor){
            try {
                return (IProcessor)processor.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 设置模块的开放权限
     * 由后台GM控制
     * @param moduleId
     * @param openFlag
     */
    public static void setModuleOpen(short moduleId, boolean openFlag){
//        ModuleEntrance moduleEntrance = entrances.get(moduleId);
//        if (null == moduleEntrance)
//            return;
//        moduleEntrance.setModuleEntrance(openFlag);
    }

    /**
     * 设置处理器的开放权限
     * 由后台GM控制
     * @param msgId
     * @param openFlag
     */
    public static void setProcessorOpen(short msgId, boolean openFlag){
//        short moduleId = getModIdByMsg(msgId);
//        ModuleEntrance moduleEntrance = entrances.get(moduleId);
//        if (null == moduleEntrance)
//            return;
//        moduleEntrance.setEntrance(msgId, openFlag);
    }

    private long oldTime;
    /**
     * 派发玩家的消息到每个处理器去处理
     * @param playerSession
     * @param request
     */
    public void dispatch(IPlayerSession playerSession, RequestBase request) {
//        short requestId = request.getEventId();
//        IModule module = getMsgModule(requestId);
//        if (null == module) {
//            logger.error("module is null when request id is " + requestId);
//            return;
//        }
//
//        IProcessor processor = module.getProcessor(requestId);
//        if (null == processor) {
//            logger.error("processor is null when request id is " + requestId);
//            return;
//        }
//
//        if(!module.isOpen() || !processor.isOpen()){
//            processor.handleException(playerSession, ErrorCode.MODULE_NOT_OPEN);
//            return;
//        }
//
//        if (playerSession.isLogin() && lockProtoSet.contains((int)requestId)) { // 安全锁拦截协议
//            ExtendComponent extendComponent = (ExtendComponent) playerSession.getPlayer().createIfNotExist(ExtendComponent.class);
//            if (extendComponent.getLockState() == 1) {
//                processor.handleException(playerSession, ErrorCode.SAVE_LOCK_LOCKED);
//            }
//        }
//
//        processor.handle(playerSession, request);

    }

    public static RequestBase getRequest(short requestId) {
        ModuleEntrance moduleEntrance = entrances.get(getModIdByMsg(requestId));
        //if (null == moduleEntrance)
            return null;
        //return moduleEntrance.getRequest(requestId);
    }


    private IModule getMsgModule(short requestId) {
        //todo: 找不到的时候异常
        short msgId = getModIdByMsg(requestId);
        if (msgId >= modules.size())
            return null;
        return modules.get(msgId);
    }

    public static short getModIdByMsg(short msgId){
        return (short)(msgId / 100 % 100);
    }

}
