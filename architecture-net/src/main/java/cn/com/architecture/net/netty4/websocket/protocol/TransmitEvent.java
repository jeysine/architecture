package cn.com.architecture.net.netty4.websocket.protocol;

/**
 * Created by linchm on 2016-6-28.
 */
public class TransmitEvent extends InterEvent implements IEvent {
    public ResponseBase response;

    public TransmitEvent(){
        super();
        setEventId(E_ID_S2P_TRANSMIT);
    }

    public TransmitEvent(long playerId){
        this();
        this.setPlayerId(playerId);
    }
}
