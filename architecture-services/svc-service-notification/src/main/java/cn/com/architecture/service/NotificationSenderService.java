package cn.com.architecture.service;

import java.util.List;

public interface NotificationSenderService {
	void sendToMail(List<String> recipients, List<String> ccList, String subject, String content,
					List<String> filePathList);
}
