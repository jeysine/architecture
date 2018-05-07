package cn.com.architecture.net.netty4.websocket;

/**
 * Interface for all server
 * Created by linchm on 2016/5/18.
 */

public interface Server {
    public interface TransmissionProtocol {

    }

    public enum TRANSMISSION_PROTOCOL implements TransmissionProtocol {
        TCP, HTTP;
    }

    TransmissionProtocol getTransmissionProtocol();

    void startServer() throws Exception;

    void stopServer() throws Exception;
}
