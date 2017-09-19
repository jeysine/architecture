package cn.com.architecture.service.mail.impl;

import cn.com.architecture.service.mail.MailService;
import cn.com.architecture.service.mail.exception.MailServiceException;
import org.apache.poi.util.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Service
public class MailServiceImpl implements MailService {
	@Value("${mail.mailSender}")
	private String mailSender;

	@Value("${mail.mailPassword}")
	private String mailSenderPassword;

	@Value("${mail.mailHost}")
	private String mailHost;

	@Value("${mail.reply}")
	private String replyMailAddress;

	private static Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);

	@Override
	public void sendTextMail(final List<String> recipients, List<String> ccList, final String subject, final String content)
			throws MailServiceException {
		logger.debug("sending mail, recipients:{}, cc:{}, subject:{}, content:{}", recipients, ccList,
				subject, content);
		sendMail(recipients, ccList, subject, content, null);
	}

	@Override
	public void sendMailAttachedWithLocalFile(final List<String> recipients, final List<String> ccList,
											  final String subject, final String content, final List<String> filePathList) throws MailServiceException {
		logger.debug("sending attached mail with local file, recipients:{}, cc:{}, subject:{}, content:{}, file:{}",
				recipients, ccList, subject, content, filePathList);
		sendMail(recipients, ccList, subject, content, filePathList);
	}
	/**
	 *
	 * send attached mail whose attachment is produced from an Inputstream
	 */
	@Override
	public void sendMail(List<String> recipients, List<String> ccList, String subject, String content,
						  List<String> filePathList) throws MailServiceException {

		JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();

		senderImpl.setHost(mailHost);

		MimeMessage mailMessage = senderImpl.createMimeMessage();
		MimeMessageHelper messageHelper;
		List<InternetAddress> recipientAddresses = getRecipientAddressList(recipients);
		List<InternetAddress> ccAddresses = getCcList(ccList);

		try {
			messageHelper = new MimeMessageHelper(mailMessage, true, "utf-8");
			messageHelper.setTo(recipientAddresses.toArray(new InternetAddress[0]));
			messageHelper.setCc(ccAddresses.toArray(new InternetAddress[0]));
			messageHelper.setFrom(mailSender);
			messageHelper.setSubject(subject);
			messageHelper.setText(content, true);
			messageHelper.setReplyTo(new InternetAddress(replyMailAddress));

			if (filePathList != null && filePathList.size() > 0) {
				for (int i = 0; i < filePathList.size(); i++) {
					messageHelper.addAttachment(filePathList.get(i).substring(filePathList.get(i).lastIndexOf("/")),
							new ByteArrayResource(IOUtils.toByteArray(readFile(filePathList.get(i)))));
				}
			}
		} catch (MessagingException e) {
			logger.error("failed to create MimeMessageHelper", e);
			throw new MailServiceException("failed to create MimeMessageHelper");
		} catch (IOException e) {
			logger.error("failed to attach file", e);
			throw new MailServiceException("failed to attach file");
		}

		senderImpl.setUsername(mailSender);
		senderImpl.setPassword(mailSenderPassword);

		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.timeout", "25000");
		prop.put("mail.smtp.sendpartial", "true"); // 允许tolist里有无效地址
		senderImpl.setJavaMailProperties(prop);

		senderImpl.send(mailMessage);

		logger.info("mail sent successfully!");
	}

	private List<InternetAddress> getCcList(List<String> ccList) {
		List<InternetAddress> ccAddresses = new ArrayList<>();
		if (ccList != null) {
			for (String cc : ccList) {
				try {
					ccAddresses.add(new InternetAddress(cc));
				} catch (AddressException e) {
					logger.warn("Wrong cc {}.", cc, e);
				}
			}
		}
		return ccAddresses;
	}

	private List<InternetAddress> getRecipientAddressList(List<String> recipients) {
		if (recipients == null || recipients.size() <= 0) {
			logger.error("recipient must not be null.");
		}
		List<InternetAddress> recipientAddresses = new ArrayList<>();

		for (String oneRecipient : recipients) {
			try {
				recipientAddresses.add(new InternetAddress(oneRecipient));
			} catch (AddressException e) {
				logger.warn("Wrong recipient {}.", oneRecipient, e);
			}
		}
		return recipientAddresses;
	}

	private InputStream readFile(String localFile){
		InputStream input = null;
		FileSystemResource resource = new FileSystemResource(new File(localFile));
		try {
			input = resource.getInputStream();
		} catch (IOException e) {
			logger.error("failed to find attachment", e);
			return null;
		}
		return input;
	}
}
