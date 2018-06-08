package cn.com.architecture.shop.event.handler;

import cn.com.architecture.shop.event.BaseEvent;
import cn.com.architecture.shop.event.GoodPriceEvent;

/**
 * Created by li on 2018/6/3.
 */



public class GoodPriceEventHandler extends BaseHandler{

    private GoodPriceEvent event;


    public GoodPriceEventHandler(BaseEvent event) {
        super(event);
        this.event = (GoodPriceEvent)event;
    }
}
