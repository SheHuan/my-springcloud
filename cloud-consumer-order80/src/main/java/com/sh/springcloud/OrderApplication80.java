package com.sh.springcloud;

import com.sh.ribbon.RibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
// 使用 Ribbon 访问 CLOUD-PAYMENT-SERVICE 时使用 RibbonConfig 中的配置
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = RibbonConfig.class)
public class OrderApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication80.class, args);
    }
}
