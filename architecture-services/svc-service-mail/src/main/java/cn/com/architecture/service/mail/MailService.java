package cn.com.architecture.service.mail;

import cn.com.architecture.service.mail.exception.MailServiceException;

import java.util.List;

public interface MailService {

	void sendTextMail(final List<String> recipients, List<String> ccList, final String subject, final String content) throws MailServiceException;

	void sendMailAttachedWithLocalFile(final List<String> recipients, final List<String> ccList,
									   final String subject, final String content, final List<String> filePathList) throws MailServiceException;

	void sendMail(List<String> recipients, List<String> ccList, String subject, String content,
				  List<String> filePathList) throws MailServiceException;
}
