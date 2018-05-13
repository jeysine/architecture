package cn.com.architecture.net.netty4.common.hotswap;

import cn.com.architecture.net.netty4.common.dispatcher.CMD;
import cn.com.architecture.net.netty4.common.dispatcher.Dispatcher;
import groovy.lang.GroovyClassLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.DirUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by li on 2018/5/14.
 */

public class GroovyLoader {

    private static Logger logger = LoggerFactory.getLogger(GroovyLoader.class);

    private static class Inner{
        private static GroovyClassLoader gcl = new GroovyClassLoader();
        private static GroovyLoader loader = new GroovyLoader();
    }

    public static GroovyLoader getInstance(){
        return Inner.loader;
    }

    private Map<Integer, Dispatcher.Commander> commanders = new HashMap<>();

    /**
     * 通过本地文件load协议
     * @param path
     */
    public synchronized void load(String path) {
        Inner.gcl.clearCache();

        File[] files = DirUtils.ls(path, "java");

        List<Class> classes = new LinkedList<>();

        for (File file : files) {
            Class cls = null;
            try {
                logger.info("load file = {}", file.getAbsolutePath());
                cls = Inner.gcl.parseClass(file);
            } catch (IOException e) {
                logger.debug("load file ["+file.getAbsolutePath()+"] failed.", e);
            }
            classes.add(cls);
        }

        load(classes);
    }

    /**
     * 协议加载
     */
    public synchronized void load(Collection<Class> classes){

        Map<Integer, Dispatcher.Commander> newCommanders = new HashMap<>();

        String err = null;
        for (Class cls : classes) {
            try {
                Object o = cls.newInstance();
                Method[] methods = cls.getDeclaredMethods();

                for (Method method : methods) {
                    CMD cmd = method.getAnnotation(CMD.class);
                    if(cmd != null) {
                        if(newCommanders.get(cmd.id()) != null){
                            err = "协议加载异常:协议号重复 cmd.id = "+cmd.id();
                            logger.error(err);
                        }
                        newCommanders.put(cmd.id(), new Dispatcher.Commander(o, cmd.mustLogin(), method));
                    }
                }
            } catch (Exception e) {
                logger.error("协议["+cls+"]加载出错!!!",e);
            }
        }
        //协议号重复直接报错
        if(err != null){
            throw new RuntimeException(err);
        }

        commanders = newCommanders;
    }

}
