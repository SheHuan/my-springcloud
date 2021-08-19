package com.sh.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sh.springcloud.bean.CommonResult;
import com.sh.springcloud.bean.Payment;
import com.sh.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consumer/payment")
//@DefaultProperties(defaultFallback = "getPaymentByIdFallback") // 全局配置服务降级
public class OrderController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        return paymentService.create(payment);
    }

    // 使用了 DefaultProperties，HystrixCommand 不需要配置其它属性
//    @HystrixCommand
//    @HystrixCommand(fallbackMethod = "getPaymentByIdFallback",
//            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")})
    @GetMapping("/get/{id}")
    public CommonResult getPaymentId(@PathVariable("id") Long id) {
        CommonResult paymentById = paymentService.getPaymentById(id);
        return paymentById;
    }

//    public CommonResult getPaymentByIdFallback() {
//        return CommonResult.error("服务异常，请稍后再试");
//    }
}
