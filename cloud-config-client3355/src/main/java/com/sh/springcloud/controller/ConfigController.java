package com.sh.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// 刷新配置文件还需要添加如下注解，所有配置完成后，重启项目，
// 之后如果git上的配置文件修改，需要我们手动发送 post 请求，http://localhost:3355/actuator/refresh，
// 这样该项目就能依赖到最新的配置文件，这算是手动刷新吧，多个客户端就需要多次手动发送请求，这个功能还蛮鸡肋的。。。
// 之后，可以使用bus+mq来改进，只要刷新一次配置中心服务，监听配置中心服务的客户端就会自动刷新
@RefreshScope
public class ConfigController {
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}
