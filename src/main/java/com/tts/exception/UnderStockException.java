package com.tts.exception;

/**
 * Created by joe on 17/4/25.
 * 库存不足
 */
public class UnderStockException extends PayException {

    public UnderStockException() {
    }

    public UnderStockException(String message) {
        super(message);
    }
}
