package com.sh.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    RouteLocator routeLocator(RouteLocatorBuilder builder) {
        // 访问 http://localhost:9527/guonei 会转发到 http://news.baidu.com/guonei
        return builder.routes()
                .route("news_route", r -> r.path("/guonei").uri("http://news.baidu.com/guonei"))
                .build();
    }
}
