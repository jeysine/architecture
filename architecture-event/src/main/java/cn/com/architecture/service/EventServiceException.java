package cn.com.architecture.service;

import cn.com.architecture.exception.ServiceException;

public class EventServiceException extends ServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5364059020255102829L;

	public EventServiceException() {
		// TODO Auto-generated constructor stub
	}

	public EventServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public EventServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public EventServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public EventServiceException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
