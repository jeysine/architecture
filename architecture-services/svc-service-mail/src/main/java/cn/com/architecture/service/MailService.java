package cn.com.architecture.service;

import cn.com.architecture.service.exception.MailServiceException;

import java.util.List;

public interface MailService {

	void sendTextMail(final List<String> recipients, List<String> ccList, final String subject, final String content) throws MailServiceException;

	void sendMailAttachedWithLocalFile(final List<String> recipients, final List<String> ccList,
									   final String subject, final String content, final List<String> filePathList) throws MailServiceException;
}
