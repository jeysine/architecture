package cn.com.architecture.net.netty4.websocket.protocol;

/**
 * @author linchm
 * Created by linchm on 2016/6/14.
 */
public abstract class InterEvent implements IEvent {

    private transient IEvent.EVENT_TYPE type;
    protected short eventId;
    protected long playerId;

    public InterEvent(){
        this.type = EVENT_TYPE.EVENT_INTER;
    }

    public EVENT_TYPE getType() {
        return type;
    }

    public void setType(EVENT_TYPE type) {
        this.type = type;
    }

    public short getEventId(){
        return eventId;
    }

    public void setEventId(short id){
        this.eventId = id;
    }

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }
}
