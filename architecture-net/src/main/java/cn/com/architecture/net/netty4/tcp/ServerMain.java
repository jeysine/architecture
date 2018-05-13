package cn.com.architecture.net.netty4.tcp;

import cn.com.architecture.net.netty4.tcp.boot.AbstractBoot;
import cn.com.architecture.net.netty4.tcp.handler.DefaultHandler;

/**
 * Created by li on 2018/5/13.
 */


public class ServerMain {


    public static void main(String args[]) throws Exception{


        AbstractBoot server = AbstractBoot.create(new DefaultHandler(), 6001, 60);
        server.start();


    }

}
