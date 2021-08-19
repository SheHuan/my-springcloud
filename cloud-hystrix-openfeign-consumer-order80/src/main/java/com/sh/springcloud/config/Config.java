package com.sh.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    // 配置 openfeign 的日志级别，和配置文件中full作用类似
//    @Bean
//    Logger.Level level() {
//        return Logger.Level.FULL;
//    }
}
