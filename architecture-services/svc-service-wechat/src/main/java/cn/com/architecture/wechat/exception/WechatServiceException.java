package cn.com.architecture.wechat.exception;

/**
 * Created by Administrator on 2017/9/25.
 */
public class WechatServiceException extends Exception {
    private static final long serialVersionUID = -4874131699753029243L;

    public WechatServiceException() {
        super();
    }

    public WechatServiceException(String message) {
        super(message);
    }

    public WechatServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public WechatServiceException(Throwable cause) {
        super(cause);
    }

    public WechatServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
