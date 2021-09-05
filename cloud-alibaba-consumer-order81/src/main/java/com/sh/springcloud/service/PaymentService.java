package com.sh.springcloud.service;

import com.sh.springcloud.bean.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 里边的接口声明和要调用的生产者controller里边一致
 */
@FeignClient(value = "alibaba-nacos-payment-service", fallbackFactory = PaymentFallbackFactoryService.class)
public interface PaymentService {
    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);
}
