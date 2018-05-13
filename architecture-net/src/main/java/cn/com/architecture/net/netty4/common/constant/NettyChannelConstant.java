package cn.com.architecture.net.netty4.common.constant;
/**
 * Created by li on 2018/5/13.
 */

import io.netty.util.AttributeKey;

public class NettyChannelConstant {

    public static AttributeKey<Object> NETTY_ATTR_KEY_1 = io.netty.util.AttributeKey.valueOf("myKey1");//netty ChannelHandlerContext.attr()的key定义

    public static final String CHANNELID = "channelId";




}
