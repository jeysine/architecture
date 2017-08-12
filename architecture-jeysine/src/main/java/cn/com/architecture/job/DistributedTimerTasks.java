package cn.com.architecture.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("distributedTimerTasks")
@DistributedExclusiveTask("architecture-distributed-timertasks")
public class DistributedTimerTasks {
	private static Logger logger = LoggerFactory.getLogger(DistributedTimerTasks.class);

	@Scheduled(cron = "0 0/1 * * * ?")
	public void testDistributed() {
		logger.debug("distributedTimerTasks is runing");
	}
}