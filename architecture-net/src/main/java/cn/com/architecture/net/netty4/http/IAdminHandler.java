/**
 * 2010-10-10
 * XiYouGameServer
 * @author eric.chan
 **/
package cn.com.architecture.net.netty4.http;

import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;

public interface IAdminHandler extends Cloneable{

	/**
	 * 运行
	 * 
	 * @param request
	 * @param response
	 *@date 2010-10-10
	 *@author eric.chan
	 */
	public void exec(FullHttpRequest request, FullHttpResponse response);
}
