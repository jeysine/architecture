package cn.com.architecture.service.notification;

import java.util.List;

public interface NotificationSenderService {
	void sendToMail(List<String> recipients, List<String> ccList, String subject, String content,
					List<String> filePathList);
}
