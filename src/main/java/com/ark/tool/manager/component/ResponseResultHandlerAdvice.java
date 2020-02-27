package com.ark.tool.manager.component;

import com.ark.tool.manager.bean.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * response增强
 * @author huisunan
 * @date 2020/1/14 14:26
 */
@RestControllerAdvice
@Slf4j
public class ResponseResultHandlerAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        log.info("returnType:{},converterType:{}",returnType,converterType);
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        // 判断响应的Content-Type为JSON格式的body
        if(MediaType.APPLICATION_JSON.equals(mediaType)){
            // 如果响应返回的对象为统一响应体，则直接返回body
            if(o instanceof ResponseResult){
                return o;
            }else{
                // 只有正常返回的结果才会进入这个判断流程，所以返回正常成功的状态码
                return new ResponseResult(0,"成功",o);
            }
        }
        return o;
    }
}
