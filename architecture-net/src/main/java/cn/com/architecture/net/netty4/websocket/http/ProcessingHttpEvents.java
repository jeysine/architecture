package cn.com.architecture.net.netty4.websocket.http;



import cn.com.architecture.net.netty4.websocket.constant.ErrorCode;
import cn.com.architecture.net.netty4.websocket.http.event.IAnswerHttpEvent;
import cn.com.architecture.net.utils.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 处理http指令
 *
 * @author lugl
 *         2016年6月20日 下午8:04:59
 */
public class ProcessingHttpEvents {
    private static final Logger logger = LoggerFactory.getLogger(ProcessingHttpEvents.class);
    private static String key = "legend";

    private static final Map<Integer, IAnswerHttpEvent> eventMap = new HashMap<>();

    static {
        for (HttpEventType eventType : HttpEventType.values()) {
            eventMap.put(eventType.getCmd(), eventType.getiHttpEvent());
        }
    }

    public static String trigger(Map<String, List<String>> p) {
        long timeOld = TimeUtil.currentTimeMillis();
        int cmd = Integer.parseInt(p.get("cmd").get(0));
        String method = "";
        try {
            logger.info("ProcessingHttpEvents.trigger.income.cmd:" + cmd + " method:" + method);
            IAnswerHttpEvent event = eventMap.get(cmd);
            if (event != null) {
                return event.process(p);
            }
            return String.valueOf(ErrorCode.HTTP_PARA_ERROR);
        } catch (Exception e) {
            logger.error("ProcessingHttpEvents::trigger exception: ", e.getMessage(), e);
            logger.error("cmd: ", cmd, "paramter: ", p);
        } finally {
            try {
                logger.debug("ProcessingHttpEvents.trigger.cmd:" + cmd + " method:" + method + " spendTime:"
                        + (TimeUtil.currentTimeMillis() - timeOld) + " p:" + p);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return "-1";
    }
}
