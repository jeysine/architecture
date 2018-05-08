package cn.com.architecture.net.netty4.websocket;


import cn.com.architecture.net.netty4.websocket.context.AppContext;
import cn.com.architecture.net.netty4.websocket.quartz.JobStoreRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by linchm on 2016/5/18.
 */
public class ServerManagerImpl implements ServerManager {
    private Set<AbstractNettyServer> servers;
    private static final Logger LOG = LoggerFactory.getLogger(ServerManagerImpl.class);

    public ServerManagerImpl() {
        servers = new HashSet<AbstractNettyServer>();
    }


    @Override
    public void startServers() throws Exception {
        AbstractNettyServer wsServer = (AbstractNettyServer) AppContext.getBean(AppContext.WS_SERVER);
        wsServer.startServer();
        servers.add(wsServer);

        AbstractNettyServer httpServer = (AbstractNettyServer) AppContext.getBean(AppContext.HTTP_SERVER);
        httpServer.startServer();
        servers.add(httpServer);

        //初始化定时器
        JobStoreRunner qRunner = new JobStoreRunner();
        qRunner.task();
    }

    @Override
    public void stopServers() throws Exception {
        for (AbstractNettyServer nettyServer : servers) {
            try {
                nettyServer.stopServer();
            } catch (Exception e) {
                LOG.error("Unable to stop server {} due to error {}", nettyServer, e);
                throw e;
            }
        }
    }
}
