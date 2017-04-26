package com.tts.dto;

/**
 * Created by joe on 17/4/25.
 * 封装支付结果
 */
public class PayResult<T> {

    private T object;

    private boolean success;

    private String error;

    public PayResult() {
    }

    public PayResult(T object, boolean success, String error) {
        this.object = object;
        this.success = success;
        this.error = error;
    }

    public PayResult(T object, boolean success) {
        this.object = object;
        this.success = success;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
