package com.sh.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {
    @Bean
    // 实现负载均衡
    @LoadBalanced
    public RestTemplate initRestTemplate() {
        return new RestTemplate();
    }
}
