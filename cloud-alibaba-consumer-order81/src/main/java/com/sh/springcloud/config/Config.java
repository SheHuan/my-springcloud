package com.sh.springcloud.config;

import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sh.springcloud.bean.CommonResult;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {
    @Bean
    // 实现负载均衡
    @LoadBalanced
    @SentinelRestTemplate( fallbackClass = ExceptionUtils.class, fallback = "handleFallback",
            blockHandlerClass = ExceptionUtils.class, blockHandler = "handleBlock")
    public RestTemplate initRestTemplate() {
        return new RestTemplate();
    }
}
