package com.sh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ZookeeperOrderApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(ZookeeperOrderApplication80.class, args);
    }
}
