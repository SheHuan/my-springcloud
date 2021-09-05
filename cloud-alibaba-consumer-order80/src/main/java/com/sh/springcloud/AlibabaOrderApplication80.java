package com.sh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaOrderApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaOrderApplication80.class, args);
    }
}
