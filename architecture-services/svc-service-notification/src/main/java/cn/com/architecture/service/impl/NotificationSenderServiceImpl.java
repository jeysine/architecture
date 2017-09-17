package cn.com.architecture.service.impl;

import cn.com.architecture.service.MailService;
import cn.com.architecture.service.NotificationSenderService;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import cn.com.architecture.service.exception.MailServiceException;
import cn.com.architecture.threadpool.MdcThreadPoolExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class NotificationSenderServiceImpl implements NotificationSenderService {
	private BlockingQueue<Runnable> mailNotificationQueue;
	private ThreadPoolExecutor mailExecutor;

	private final int notificationPoolSize = 5;

	private int notificationQueueSize = 100000;
	private static Logger logger = LoggerFactory.getLogger(NotificationSenderServiceImpl.class);

	@Autowired
	private MailService mailService;

	@PostConstruct
	public void init() {
		mailNotificationQueue = new LinkedBlockingQueue<Runnable>(notificationQueueSize);
		mailExecutor = MdcThreadPoolExecutor.newWithInheritedMdc(4, notificationPoolSize, 10, TimeUnit.SECONDS,
				mailNotificationQueue);
	}

	@PreDestroy
	public void close() {
		mailExecutor.shutdown();
		try {
			mailExecutor.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// ignore
			logger.warn("Exception while closing ", e);
		}
	}

	@Override
	public void sendToMail(final List<String> recipients, final List<String> ccList, final String subject, final String content, final List<String> filePathList) {
		if (recipients.isEmpty()) {
			return;
		}
		mailExecutor.execute(new Runnable() {
			@Override
			public void run() {
				try {
					mailService.sendMail(recipients, ccList, subject, content, filePathList);
				} catch (MailServiceException e) {
					logger.warn("Sending mail failed", e);
				}
			}
		});
	}
}
