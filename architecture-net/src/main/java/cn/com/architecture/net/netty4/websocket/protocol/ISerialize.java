package cn.com.architecture.net.netty4.websocket.protocol;

import io.netty.buffer.ByteBuf;

/**
 * Created by linchm on 2016/5/25.
 */
public interface ISerialize {
    /**
     * 系列化，将类属性系列化成ByteBuf
     * @param out
     */
    void serial(ByteBuf out);

    /**
     * 反序列化, 从ByteBuf读取信息到类属性
     * @param in
     */
    void unserial(ByteBuf in);
}
