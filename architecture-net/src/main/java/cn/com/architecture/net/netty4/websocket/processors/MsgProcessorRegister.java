package cn.com.architecture.net.netty4.websocket.processors;


public enum MsgProcessorRegister {

    //processor_end
    ;
    private short msgCode;
    private Class processor;
    private Class request;
    private boolean isClose;


    MsgProcessorRegister(short msgCode, Class processor, Class request) {
        this.msgCode = msgCode;
        this.processor = processor;
        this.request = request;
        this.request = request;
        this.isClose = false;
    }

    public short getMsgCode() {
        return this.msgCode;
    }

    private boolean isClose() {
        return isClose;
    }

    private void setClose(boolean isClose) {
        this.isClose = isClose;
    }

    public Class getMsgProcessor() {
        return this.processor;
    }

    public Class getRequest() {
        return request;
    }

    public void setRequest(Class request) {
        this.request = request;
    }
}
