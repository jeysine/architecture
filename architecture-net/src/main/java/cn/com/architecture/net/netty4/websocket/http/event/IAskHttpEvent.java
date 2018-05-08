package cn.com.architecture.net.netty4.websocket.http.event;

import java.util.Map;

/**
 * Created by p on 2016-09-18.
 */
public interface IAskHttpEvent extends IHttpEvent{
    public int process(Map<String, String> p);
}
