package com.sh.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// 实现配置自动更新
@RefreshScope
@RequestMapping("/config")
public class ConfigTestController {
    @Value("${config.info}")
    private String info;

    @GetMapping("/info")
    public String info(){
        return info;
    }
}
