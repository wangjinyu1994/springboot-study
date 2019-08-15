package com.xy.studyboot.exception;

/**
 * WJY
 * 异常信息模版
 */
public class ErrorResponseEntity {

    private int code;

    private String message;

    public ErrorResponseEntity(int value, String defaultMessage) {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
