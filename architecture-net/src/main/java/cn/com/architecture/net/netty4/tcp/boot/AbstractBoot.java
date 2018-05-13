package cn.com.architecture.net.netty4.tcp.boot;

import cn.com.architecture.net.IHandlerNetty4;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by li on 2018/5/13.
 */

public abstract class AbstractBoot {

    private static final Logger logger = LoggerFactory
            .getLogger(AbstractBoot.class);

    protected final IHandlerNetty4 handler;
    protected final int port;
    protected final int timeout;

    /**
     * @param handler
     *            处理类
     * @param timeout
     *            超时时间（秒）
     */
    public AbstractBoot(IHandlerNetty4 handler, int port, int timeout) {
        this.handler = handler;
        this.port = port;
        this.timeout = timeout;
    }

    public abstract void start() throws Exception;


    public static AbstractBoot create(IHandlerNetty4 handler,int port,int timeout) throws Exception{
        String OSName = System.getProperty("os.name").toLowerCase();//操作系统名称
        String osVersion = System.getProperty("os.version"); //操作系统版本
        System.out.println("OSName=" + OSName + ",osVersion=" + osVersion);
        if(OSName.indexOf("linux") != -1){//linux系统:OSName=linux,osVersion=3.10.0-229.el7.x86_64
            AbstractBoot boot = new LinuxBoot(handler,port,timeout);
            boot.start();
            return boot;
        }else{
            AbstractBoot boot = new NormalBoot(handler,port,timeout);
            boot.start();
            return boot;
        }
    }

}
