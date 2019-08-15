package com.xy.studyboot.exception;

import java.io.Serializable;

/**
 * WJY
 * 自定义异常类
 */
public class CustomException extends RuntimeException implements Serializable{

    private static final long serialVersionUID = 1L;

    private Integer code;

    public CustomException(){
        super();
    }

    public CustomException(Integer code ,String message){
        super(message);
        this.setCode(code);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
