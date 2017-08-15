package cn.com.architecture.job;

import cn.com.architecture.system.constant.LogConstants;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import utils.UuidUtils;


/**
 * 分布式定时器运行时加入log
 * @author jeysine
 *
 */
@Aspect
@Component
public class SchedulerLogProcessAspect {

	private static Logger logger = LoggerFactory.getLogger(SchedulerLogProcessAspect.class);

	@Before("@annotation(org.springframework.scheduling.annotation.Scheduled) && within(cn.com.architecture.job..*)")
	public void addTraceIdtoMDC(JoinPoint jp) throws Throwable {
		Long traceid = new UuidUtils().nextValue();
		MDC.put(LogConstants.TRACE_ID.getValue(), traceid.toString());
		logger.trace("set traceid {} in SchedulerLogProcessAspect for {}", traceid, jp);
	}
}
