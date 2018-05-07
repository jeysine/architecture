package cn.com.architecture.net.netty4.websocket.protocol;

/**
 * Created by linchm on 2016/6/3.
 */
public interface IEvent {

    public enum EVENT_TYPE {
        EVENT_C2S,
        EVENT_S2C,
        EVENT_S2S,
        EVENT_INTER,
    }


    short E_ID_S2P_TRANSMIT = 1;


    public EVENT_TYPE getType();

    public void setType(EVENT_TYPE type);


}
