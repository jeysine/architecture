package cn.com.architecture.net.netty4.websocket.protocol;

/**
 * Created by linchm on 2016/5/25.
 */
public abstract class RequestBase implements ISerialize, IEvent {

    private transient IEvent.EVENT_TYPE dragonballEventType;
    public short eventRequestId;
    public byte codeType ;

    public RequestBase(){
        this.dragonballEventType = EVENT_TYPE.EVENT_C2S;
    }

    public EVENT_TYPE getType() {
        return dragonballEventType;
    }

    public void setType(EVENT_TYPE type) {
        this.dragonballEventType = type;
    }

    public short getEventId(){
        return eventRequestId;
    }

    public void setEventId(short id){
        this.eventRequestId = id;
    }

    public byte getCodeType() {
        return codeType;
    }

    public void setCodeType(byte codeType) {
        this.codeType = codeType;
    }

    public abstract void reset();
}
