package com.ark.tool.manager.util;


import com.ark.tool.manager.bean.ResponseResult;

public class ResponseUtil {
    public static ResponseResult fail(){
        return fail("系统异常",null);
    }
    public static ResponseResult fail(String message){
        return fail(message,null);
    }
    public static ResponseResult fail(String message,Object data){
        return new ResponseResult(1,message,data);
    }
    public static ResponseResult success(String message){
        return success(message,null);
    }
    public static ResponseResult success(String message,Object data){
        return new ResponseResult(0,message,data);
    }
    public static ResponseResult newInstance(Integer code,String message,Object data){
        return new ResponseResult(code,message,data);
    }
    public static ResponseResult add(){
        return success("添加成功！");
    }
    public static ResponseResult update(){
        return success("更新成功！");
    }
    public static ResponseResult delete(){
        return success("删除成功！");
    }
}
