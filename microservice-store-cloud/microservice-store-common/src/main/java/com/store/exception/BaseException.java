package com.store.exception;

import lombok.Data;
import lombok.Getter;

/**
 * BaseException
 * Description:
 * 自定义基础异常类
 */
@Getter
public class BaseException extends RuntimeException {

    private int code = 200;

    public BaseException() {
    }

    public BaseException(String message, int code) {
        super(message);
        this.code = code;
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
