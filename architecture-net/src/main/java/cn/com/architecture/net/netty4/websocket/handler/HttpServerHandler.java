package cn.com.architecture.net.netty4.websocket.handler;

import cn.com.architecture.net.netty4.websocket.http.HttpHelper;
import cn.com.architecture.net.netty4.websocket.http.ProcessingHttpEvents;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.multipart.*;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.netty.buffer.Unpooled.copiedBuffer;
import static io.netty.handler.codec.http.HttpHeaders.Names.*;

/**
 * Created by linchm on 2016-7-28.
 */
public class HttpServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
    private static final Logger logger = LoggerFactory.getLogger(HttpServerHandler.class);

    private FullHttpRequest fullHttpRequest;

    private final StringBuilder responseContent = new StringBuilder();

    private HttpPostRequestDecoder decoder;

    private boolean readingChunks;

    private static final HttpDataFactory factory = new DefaultHttpDataFactory(DefaultHttpDataFactory.MINSIZE); //Disk

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest msg) throws Exception {

        fullHttpRequest = msg;

        responseContent.setLength(0);
//        responseContent.append("HTTP/1.0 200 OK");
//        responseContent.append("\r\n");

        if (fullHttpRequest.method().equals(HttpMethod.GET)) {
            //get请求
            QueryStringDecoder decoderQuery = new QueryStringDecoder(fullHttpRequest.uri());
            Map<String, List<String>> uriAttributes = decoderQuery.parameters();
            StringBuilder stringBuilder = new StringBuilder();
            uriAttributes.entrySet().forEach(entry -> stringBuilder.append(entry.getKey()).append("=").append(entry.getValue().get(0)).append(","));
            logger.info("HttpServerHandler.channelRead0:" + stringBuilder.toString());

            if (uriAttributes.size() != 0 && HttpHelper.validateSign(uriAttributes)) {
                String value = ProcessingHttpEvents.trigger(uriAttributes);
                responseContent.append(value);
            }

        } else if (fullHttpRequest.method().equals(HttpMethod.POST)) {
            //post请求
            decoder = new HttpPostRequestDecoder(factory, fullHttpRequest);
            readingChunks = HttpUtil.isTransferEncodingChunked(fullHttpRequest);
//            responseContent.append("Is Chunked: " + readingChunks + "\r\n");
//            responseContent.append("IsMultipart: " + decoder.isMultipart() + "\r\n");
            List<InterfaceHttpData> parmList = decoder.getBodyHttpDatas();
            Map<String, List<String>> uriAttributes = new HashMap<>();
            for (InterfaceHttpData parm : parmList) {
                List<String> params = new ArrayList<>();
                Attribute data = (Attribute) parm;
                params.add(data.getValue());
                uriAttributes.put(data.getName(), params);
            }
            if (uriAttributes.size() != 0 && HttpHelper.validateSign(uriAttributes)) {
                String value = ProcessingHttpEvents.trigger(uriAttributes);
                responseContent.append(value);
            }
//            try {
//                while (decoder.hasNext()) {
//                    InterfaceHttpData data = decoder.next();
//                    if (data != null) {
//                        try {
//                            System.out.println("data: " + data);
//                        } finally {
//                            data.release();
//                        }
//                    }
//                }
//            } catch (HttpPostRequestDecoder.EndOfDataDecoderException e1) {
//                responseContent.append("\r\n\r\nEND OF POST CONTENT\r\n\r\n");
//            }
        }
        writeResponse(ctx.channel());
    }

    /**
     * http返回响应数据
     *
     * @param channel
     */
    private void writeResponse(Channel channel) {
        // Convert the response content to a ChannelBuffer.
        ByteBuf buf = copiedBuffer(responseContent.toString(), CharsetUtil.UTF_8);
        responseContent.setLength(0);

        // Decide whether to close the connection or not.
        boolean close = fullHttpRequest.headers().contains(CONNECTION, HttpHeaders.Values.CLOSE, true)
                || fullHttpRequest.protocolVersion().equals(HttpVersion.HTTP_1_0)
                && !fullHttpRequest.headers().contains(CONNECTION, HttpHeaders.Values.KEEP_ALIVE, true);

        // Build the response object.
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, buf);
        response.headers().set(CONTENT_TYPE, "text/plain; charset=UTF-8");

        if (!close) {
            // There's no need to add 'Content-Length' header
            // if this is the last response.
            response.headers().set(CONTENT_LENGTH, buf.readableBytes());
        }


        // Write the response.
        ChannelFuture future = channel.writeAndFlush(response);
        // Close the connection after the write operation is done if necessary.
        if (close) {
            future.addListener(ChannelFutureListener.CLOSE);
        }
    }


    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        logger.error(cause.getMessage());
        ctx.close();
    }
}
