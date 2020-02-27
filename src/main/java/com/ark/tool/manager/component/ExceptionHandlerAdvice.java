package com.ark.tool.manager.component;


import com.ark.tool.manager.bean.ResponseResult;
import com.ark.tool.manager.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理器
 * @author huisunan
 * @date 2020/1/14 14:10
 */
@Slf4j
@RestControllerAdvice
public class ExceptionHandlerAdvice {
    /**
     * 处理业务异常BaseException
     * @param e 业务异常
     * @return 统一响应体
     */
    @ExceptionHandler(BaseException.class)
    public ResponseResult handleBaseException(BaseException e){
        log.error(e.getMessage(),e);
        return new ResponseResult(e.getCode(),e.getMessage(),null);
    }

    /**
     * 处理未捕获的RuntimeException
     * @param e 运行时异常
     * @return 统一响应体
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseResult handleRuntimeException(RuntimeException e){
        log.error(e.getMessage(),e);
        return new ResponseResult(1,e.getMessage(),null);
    }

    /**
     * 处理未捕获的Exception
     * @param e 异常
     * @return 统一响应体
     */
    @ExceptionHandler(Exception.class)
    public ResponseResult handleException(Exception e){
        log.error(e.getMessage(),e);
        return new ResponseResult(1,e.getMessage(),null);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseResult handleRequestException(HttpRequestMethodNotSupportedException e){
        log.info("{}方法不支持，请使用{}方法!",e.getMethod(), StringUtils.join(e.getSupportedHttpMethods()));
        return new ResponseResult(1,"请使用["+StringUtils.join(e.getSupportedHttpMethods())+"]方法访问!",null);
    }
}
