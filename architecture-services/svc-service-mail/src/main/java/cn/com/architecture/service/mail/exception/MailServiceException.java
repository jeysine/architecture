package cn.com.architecture.service.mail.exception;

import cn.com.architecture.exception.ServiceException;

public class MailServiceException extends ServiceException {
	public MailServiceException() {
	}

	public MailServiceException(String message) {
		super(message);
	}

	public MailServiceException(Throwable cause) {
		super(cause);
	}

	public MailServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public MailServiceException(String message, Throwable cause,
								boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}