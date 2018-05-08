package cn.com.architecture.net.netty4.websocket.protocol;

/**
 * Created by linchm on 2016/5/25.
 */
public abstract class ResponseBase implements ISerialize, IEvent {

    private transient IEvent.EVENT_TYPE dragonballEventType;

    public short eventResponseId;
    public short retCode;
    public byte codeType;

    public ResponseBase(){
        this.dragonballEventType = EVENT_TYPE.EVENT_S2C;
    }

    public EVENT_TYPE getType() {
        return dragonballEventType;
    }

    public void setType(EVENT_TYPE type) {
        this.dragonballEventType = type;
    }

    public short getEventId(){
        return eventResponseId;
    }

    public void setEventId(short id){
        this.eventResponseId = id;
    }

    public short getRetCode() {
        return retCode;
    }

    public void setRetCode(short retCode) {
        this.retCode = retCode;
    }

    public byte getCodeType() {
        return codeType;
    }

    public void setCodeType(byte codeType) {
        this.codeType = codeType;
    }

    public abstract void reset();
}
