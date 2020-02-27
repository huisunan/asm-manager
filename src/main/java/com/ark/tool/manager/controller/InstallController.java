package com.ark.tool.manager.controller;

import com.ark.tool.manager.bean.ResponseResult;
import com.ark.tool.manager.config.ArkProperties;
import com.ark.tool.manager.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 首次安装
 */
@RestController
@RequestMapping("install")
@Slf4j
public class InstallController {
    @Autowired
    private ArkProperties arkProperties;

    private Boolean success;

    private Process p;

    @GetMapping("install")
    public ResponseResult install() throws IOException {
        //创建三个目录 Logs Profiles SteamCMD
        File logDir = new File(arkProperties.getPath() + File.separator + "Logs");
        if (!logDir.exists()){
            logDir.mkdirs();
        }
        File profilesDir = new File(arkProperties.getPath() + File.separator + "Profiles");
        if (!profilesDir.exists()){
            profilesDir.mkdirs();
        }
        File steamCMDDir = new File(arkProperties.getPath() + File.separator + "SteamCMD");
        if (!steamCMDDir.exists()){
            steamCMDDir.mkdirs();
        }

        if (p==null){
            new Thread(()->{
                try {
                    //安装steamCMD
                    String name = "steamcmd.exe";
                    ClassPathResource resource = new ClassPathResource(name);
                    FileUtils.copyFileToDirectory(resource.getFile(),steamCMDDir);
//                    String cmd = steamCMDDir.getAbsolutePath() + File.separator + name +" +login anonymous +quit";
                   String cmd = "cmd /k start " +steamCMDDir.getAbsolutePath() + File.separator + name +" +login anonymous +quit";
                    success = false;
                    p = Runtime.getRuntime().exec(cmd);
                    String s = IOUtils.toString(p.getInputStream());
                    System.out.println(s);
                    int i = p.waitFor();
                    System.out.println(i);
                    if (i == 0){
                        log.info("安装成功！");
                        success = true;
                    }else {
                        log.info("安装失败！");
                        success = false;
                        File info = new File(arkProperties.getPath() + File.separator + "SteamCMD" + File.separator
                                + "logs" + File.separator + "bootstrap_log.txt");
                        if (info.exists()){
                            info.delete();
                        }
                    }
                    p = null;
                } catch (IOException | InterruptedException e) {
                    log.error(e.getMessage());
                    e.printStackTrace();
                }

            }).start();
        }else {
            return ResponseUtil.fail("正在安装中！");
        }

        return ResponseUtil.success("安装中!");
    }

    @GetMapping("info")
    public Object getInfo(){
        File info = new File(arkProperties.getPath() + File.separator + "SteamCMD" + File.separator
                + "logs" + File.separator + "bootstrap_log.txt");
        String s = "";
        try {
            s = FileUtils.readFileToString(info);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        Map<String,Object> res = new HashMap<>();
        res.put("log",s);
        res.put("status",success);
        return res;
    }

    @GetMapping("stop")
    public Object stop(){
        p.destroy();
        return ResponseUtil.success("终止成功!");
    }


}
