package cn.com.architecture.net.netty4.websocket;

/**
 * A generic interface used to manage a server.
 * Created by linchm on 2016/5/18.
 */
public interface ServerManager {
    public void startServers() throws Exception;

    public void stopServers() throws Exception;
}


