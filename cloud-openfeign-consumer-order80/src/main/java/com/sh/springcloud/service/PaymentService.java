package com.sh.springcloud.service;

import com.sh.springcloud.bean.CommonResult;
import com.sh.springcloud.bean.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 里边的接口声明和要调用的生产者controller里边一致
 */
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentService {
    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment);

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);
}
