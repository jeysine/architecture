/**
 * 
 */
package cn.com.architecture.net.netty4.websocket.http.event;

import java.util.List;
import java.util.Map;

/**
 * @ClassName:  IHttpEvents
 * @Description:(这里用一句话描述这个类的作用)
 * @author: lugl
 * @date:   2016年7月29日 上午11:25:48
 */
public interface IAnswerHttpEvent {
	public String process(Map<String, List<String>> p);
}
