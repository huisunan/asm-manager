package com.ark.tool.manager.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseResult implements Serializable {
    /**
     * 返回状态码
     */
    private Integer code;
    /**
     * 返回信息
     */
    private String msg;
    /**
     * 数据
     */
    private Object data;

    public ResponseResult newInstance(Integer code,String msg,Object data){
        this.code = code;
        this.msg = msg;
        this.data = data;
        return this;
    }
    public ResponseResult success(String msg,Object data){
        return newInstance(0,msg,data);
    }
    public ResponseResult success(String msg){
        return success(msg,null);
    }
    public ResponseResult fail(String msg,Object data){
        return newInstance(1,msg,data);
    }
    public ResponseResult fail(String msg){
        return fail(msg,null);
    }
}
