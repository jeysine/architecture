/**
 *
 */
package cn.com.architecture.net.netty4.websocket.http;


import cn.com.architecture.net.netty4.websocket.http.event.HotUpdateEvent;
import cn.com.architecture.net.netty4.websocket.http.event.IAnswerHttpEvent;

/**
 * http事件类型
 *
 * @author lugl
 *         2016年7月29日 上午11:30:57
 */
public enum HttpEventType {
    HotUpdate(2, new HotUpdateEvent());

    private int cmd;
    private IAnswerHttpEvent iHttpEvent;

    HttpEventType(int cmd, IAnswerHttpEvent iHttpEvent) {
        this.cmd = cmd;
        this.iHttpEvent = iHttpEvent;
    }

    /**
     * @return the cmd
     */
    public int getCmd() {
        return cmd;
    }


    /**
     * @return the iHttpEvent
     */
    public IAnswerHttpEvent getiHttpEvent() {
        return iHttpEvent;
    }


}
