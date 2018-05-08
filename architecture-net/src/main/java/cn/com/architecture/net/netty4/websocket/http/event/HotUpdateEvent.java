/**
 * 
 */
package cn.com.architecture.net.netty4.websocket.http.event;

import java.util.List;
import java.util.Map;


/**
 * @ClassName:  HotUpdateEvent
 * @Description:(这里用一句话描述这个类的作用)
 * @author: lugl
 * @date:   2016年7月29日 下午2:42:44
 */
public class HotUpdateEvent implements IAnswerHttpEvent {

	/* (non-Javadoc)
	 * @see com.gzfeiyin.dragonball.net.handler.IAnswerHttpEvent#process(java.util.Map)
	 */
	@Override
	public String process(Map<String, List<String>> p) {
		// http://127.0.0.1:18093/?key=1f007300a560e0f4d073df790bbb70e9&cmd=2&randnum=1
        return "1";
	}

}
