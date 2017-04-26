package com.tts.exception;

/**
 * Created by joe on 17/4/25.
 * 购买异常
 */
public class PayException extends RuntimeException {

    public PayException() {
    }

    public PayException(String message) {
        super(message);
    }
}
