package com.company.manerger.sys.common.sms.exception;

/**
 * @description: 短信发送异常
 */
public class SmsException extends RuntimeException {

    public SmsException() {
        super();
    }


    public SmsException(String message) {
        super(message);
    }

    public SmsException(String message, Throwable cause) {
        super(message, cause);
    }


    public SmsException(Throwable cause) {
        super(cause);
    }


    protected SmsException(String message, Throwable cause,
                           boolean enableSuppression,
                           boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
