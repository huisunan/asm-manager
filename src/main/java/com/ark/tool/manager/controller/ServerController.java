package com.ark.tool.manager.controller;

import com.ark.tool.manager.bean.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务器操作
 */

@RestController
@RequestMapping("server")
public class ServerController {
    /**
     * 获取服务器列表
     * @return
     */
    @GetMapping("list")
    public Object list(){
        return null;
    }

    /**
     * 添加服务器
     * @return
     */
    @PostMapping("add")
    public ResponseResult add(){
        return null;
    }
}
