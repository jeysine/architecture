package cn.com.architecture.net.netty4.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

/**
 * 后台管理服务
 * 
 * @author javagg
 * 
 */
public class AdminServer {

//	private static final Logger logger = LoggerFactory
//			.getLogger(AdminServer.class);
//
//	public static void main(String[] args) {
//		start(Integer.parseInt(args[0]));
//	}
//
//	public static void start(int port) {
//		// 配置服务器-使用java线程池作为解释线程
//		ServerBootstrap bootstrap = new ServerBootstrap(new NioServerSocketChannelFactory(Executors.newCachedThreadPool(), Executors.newCachedThreadPool()));
//		// 设置 pipeline factory.
//		bootstrap.setPipelineFactory(new ServerPipelineFactory());
//		// 绑定端口
//		bootstrap.bind(new InetSocketAddress(port));
//		logger.info("admin start on "+port);
//	}
//
//	private static class ServerPipelineFactory implements
//            ChannelPipelineFactory {
//		public ChannelPipeline getPipeline() throws Exception {
//			// Create a default pipeline implementation.
//			ChannelPipeline pipeline = Channels.pipeline();
//			// Uncomment the following line if you want HTTPS
//			//SSLEngine engine = SecureChatSslContextFactory.getServerContext().createSSLEngine();
//			//engine.setUseClientMode(false);
//			//pipeline.addLast("ssl", new SslHandler(engine));
//			pipeline.addLast("decoder", new HttpRequestDecoder());
//			//			pipeline.addLast("aggregator", new HttpChunkAggregator(65536));
//			pipeline.addLast("encoder", new HttpResponseEncoder());
//			//			pipeline.addLast("chunkedWriter", new ChunkedWriteHandler());
//			//http处理handler
//			pipeline.addLast("handler", new AdminServerHandler());
//			return pipeline;
//		}
//	}
}
