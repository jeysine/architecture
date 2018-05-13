package cn.com.architecture.net.netty4.common.dispatcher;

import cn.com.architecture.net.pack.PackCodec;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.TextFormat;

import io.netty.channel.ChannelHandlerContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Dispatcher
 *
 * handler函数格式:
 * <pre>
 * &#064;CMD(id=xx)
 * public byte[] xxx(ChannelHandlerContext ctx, ProtobufObj params) {...}
 * </pre>
 *
 * @author chao
 * @version 1.0 - 2014-05-30
 */
public class Dispatcher {

	private static Logger logger = LoggerFactory.getLogger(Dispatcher.class);

	public static class Commander {
		private final Object o;
		private final boolean mustLogin;
		private final Method method;
		private final Method protobufParser;

		public Commander(Object o, boolean mustLogin, Method method) throws NoSuchMethodException {
			this.o = o;
			this.mustLogin = mustLogin;
			this.method = method;
			Class paramType = method.getParameterTypes()[1];
			this.protobufParser = paramType.getMethod("parseFrom",byte[].class);
		}

		public boolean isMustLogin() {
			return mustLogin;
		}
	}

	private Map<Integer, Commander> commanders = new HashMap<>();






	/**
	 * 协议调用
	 */
	public PackCodec.Pack invoke(ChannelHandlerContext ctx, int cmd, byte[] bytes) throws Exception {
		Commander commander = commanders.get(cmd);
		if(commander != null) {
			long begin = System.currentTimeMillis();

			GeneratedMessage params = (GeneratedMessage)commander.protobufParser.invoke(null, bytes);

			logger.debug("收到协议[{}], data={}", cmd, TextFormat.shortDebugString(params));

			PackCodec.Pack res = (PackCodec.Pack) commander.method.invoke(commander.o, ctx, params);

			long used = System.currentTimeMillis() - begin;

			logger.debug("协议[{}]处理完成，耗时{}ms", cmd, used);

			// 协议处理超过1秒
			if (used > 1000) {
				logger.error("协议[{}]处理慢!!!耗时{}ms", cmd, used);
			}

			return res;
		}
		return null;
	}
	
	/**
	 * 协议调用:gameserver用
	 */
	public PackCodec.Pack invoke(long channelId, int cmd, byte[] bytes) throws Exception {
		Commander commander = commanders.get(cmd);
		if(commander != null) {
			long begin = System.currentTimeMillis();
			
			GeneratedMessage params = (GeneratedMessage)commander.protobufParser.invoke(null, bytes);
			
			logger.debug("收到协议[{}], data={}", cmd, TextFormat.shortDebugString(params));
			
			PackCodec.Pack res = (PackCodec.Pack) commander.method.invoke(commander.o, channelId, params);
			
			long used = System.currentTimeMillis() - begin;
			
			logger.debug("协议[{}]处理完成，耗时{}ms", cmd, used);
			
			// 协议处理超过1秒
			if (used > 1000) {
				logger.error("协议[{}]处理慢!!!耗时{}ms", cmd, used);
			}
			
			return res;
		}
		return null;
	}

	public Commander getCommander(int cmd){
		return commanders.get(cmd);
	}
}
