package com.sh.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Repository;

@SpringBootApplication
@MapperScan(basePackages = "com.sh.springcloud.dao", annotationClass = Repository.class)
@EnableDiscoveryClient
public class NacosPaymentApplication9002 {
    public static void main(String[] args) {
        SpringApplication.run(NacosPaymentApplication9002.class, args);
    }
}
