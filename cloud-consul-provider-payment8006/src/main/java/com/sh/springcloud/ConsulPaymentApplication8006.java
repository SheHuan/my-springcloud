package com.sh.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Repository;

@SpringBootApplication
@MapperScan(basePackages = "com.sh.springcloud.dao", annotationClass = Repository.class)
@EnableDiscoveryClient
public class ConsulPaymentApplication8006 {
    public static void main(String[] args) {
        SpringApplication.run(ConsulPaymentApplication8006.class, args);
    }
}
