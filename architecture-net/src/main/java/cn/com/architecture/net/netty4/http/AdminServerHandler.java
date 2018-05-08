/*
 * Copyright 2009 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package cn.com.architecture.net.netty4.http;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import io.netty.handler.codec.http.*;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

/**
 * @author javagg
 */
public class AdminServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

	private static final Logger logger = LoggerFactory
			.getLogger(AdminServerHandler.class);

	public static HashMap<String, IAdminHandler> servlets = new HashMap<String, IAdminHandler>();
	static {
		//servlets.put("ui", new UITestHandle());
		servlets.put("admin", new AdminHandler());
		servlets.put("pay", new PayHandler());
		servlets.put("gm", new GmHandler());
	}

	public static void regServlet(String key, IAdminHandler handler){
		if(servlets.containsKey(key))
			System.out.println("wran: this handler is alive "+key);
		else{
			servlets.put(key, handler);
		}
	}
	
//	@Override
//	public void messageReceived(ChannelHandlerContext ctx, FullHttpRequest request)
//			throws Exception {
//		String uri = request.uri();
//		IAdminHandler iah = null;
//		String sutf;
//		int index = uri.indexOf('/', 1);
//		if (index == -1) {
//			sutf = uri.substring(1);
//		} else {
//			sutf = uri.substring(1, index);
//		}
//		iah = servlets.get(sutf);
//		System.out.println("uri:"+uri);
//		if (iah == null)
//			throw new RuntimeException("admin handle not found : " + sutf);
//		FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, OK);
//		ByteBuf buffer= Unpooled.copiedBuffer(buf, CharsetUtil.UTF_8);
//		response.content(buffer);
//		iah.exec(request, response);
//
//		response.headers().set("Content-Type", "text/html; charset=UTF-8");
//		response.headers().set("Content-Length", response.content().writerIndex());
//		// Write the initial line and the header.
//
//		ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
////		ch.disconnect();
////		ch.close();
//
//	}
//
//	@Override
//	public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e)
//			throws Exception {
//		Channel ch = e.getChannel();
//		Throwable cause = e.getCause();
//		if (cause instanceof TooLongFrameException) {
//			sendError(ctx, BAD_REQUEST);
//			return;
//		}
//
//		cause.printStackTrace();
//		if (ch.isConnected()) {
//			sendError(ctx, INTERNAL_SERVER_ERROR);
//		}
//	}
//
//	private void sendError(ChannelHandlerContext ctx, HttpResponseStatus status) {
//		FullHttpResponse response = new DefaultHttpResponse(HTTP_1_1, status);
//		response.headers().set(CONTENT_TYPE, "text/plain; charset=UTF-8");
//		response.content(ChannelBuffers.copiedBuffer("Failure: " + status.toString() + "\r\n", CharsetUtil.UTF_8));
//
//		// Close the connection as soon as the error message is sent.
//		ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
//	}

	@Override
	protected void channelRead0(ChannelHandlerContext channelHandlerContext, FullHttpRequest fullHttpRequest) throws Exception {

	}
}
