package cn.com.architecture.service.wechat.event;

import cn.com.dingduoduo.entity.wechat.event.WechatMenuClickEvent;
import cn.com.dingduoduo.entity.wechat.event.WechatScanEvent;
import cn.com.dingduoduo.entity.wechat.event.WechatSubscribeEvent;
import cn.com.dingduoduo.service.event.EventServiceException;

import java.util.HashMap;

/**
 * Created by jeysine on 2018/1/24.
 */
public interface WechatEventService {
    void processEvent(HashMap<String, Object> data) throws Exception;

    void processSubscribeEvent(WechatSubscribeEvent subscribeEvent) throws Exception;

    void processUnSubscribeEvent(WechatSubscribeEvent unsubscribeEvent) throws EventServiceException;

    void processScanEvent(WechatScanEvent scanEvent) throws Exception;

    void processMenuClickEvent(WechatMenuClickEvent menuEvent) throws Exception;
}
