package com.sh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StreamRabbitMQConsumerApplication8803 {
    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitMQConsumerApplication8803.class, args);
    }
}
