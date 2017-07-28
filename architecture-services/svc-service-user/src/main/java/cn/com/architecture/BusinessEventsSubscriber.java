package cn.com.architecture;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import cn.com.architecture.constants.EventConstant;
import cn.com.architecture.listener.impl.TestListener;
import cn.com.architecture.service.EventServiceException;
import cn.com.architecture.service.EventServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/4/27.
 */
@Component
public class BusinessEventsSubscriber {
	private static Logger logger = LoggerFactory.getLogger(BusinessEventsSubscriber.class);

	@Autowired
	private EventServiceImpl eventService;

	@Autowired
	private TestListener testListener;

	@PostConstruct
	public void init() {
		try {
			eventService.subscribe(EventConstant.TEST.getValue(), testListener);
		} catch (EventServiceException e) {
			logger.error("订阅业务事件失败！！ ", e);
			throw new IllegalStateException();
		}
	}

	@PreDestroy
	public void destroy() {
	}

}
