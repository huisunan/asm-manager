package com.ark.tool.manager.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author huisunan
 * @date 2020/1/14 14:13
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseException extends RuntimeException {
    private Integer code;
    public BaseException(Integer code, String message){
        super(message);
        this.code = code;
    }
    public BaseException(Integer code, String message, Throwable cause){
        super(message,cause);
        this.code = code;
    }
}
