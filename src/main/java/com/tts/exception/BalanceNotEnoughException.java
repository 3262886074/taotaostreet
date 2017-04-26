package com.tts.exception;

/**
 * Created by joe on 17/4/25.
 * 余额不足
 */
public class BalanceNotEnoughException extends PayException {

    public BalanceNotEnoughException() {
    }

    public BalanceNotEnoughException(String message) {
        super(message);
    }
}
