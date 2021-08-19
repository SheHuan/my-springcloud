package com.sh.springcloud;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
// 由于消费者没注册到注册中心，所以可以不用加这个注解
//@EnableEurekaClient
@EnableFeignClients
public class OpenfeignOrderApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(OpenfeignOrderApplication80.class, args);
    }
}
