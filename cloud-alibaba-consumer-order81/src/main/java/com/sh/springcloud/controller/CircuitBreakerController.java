package com.sh.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sh.springcloud.bean.CommonResult;
import com.sh.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer/payment")
public class CircuitBreakerController {
    @Value("${service-url.payment-service}")
    private String PAYMENT_URL;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/get/{id}")
//    @SentinelResource(value = "paymentGetByRibbon", blockHandler = "handleBlock", fallback = "handleFallback")
    public CommonResult getPaymentId(@PathVariable("id") Long id) {
        CommonResult result = restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        return result;
    }

//    public CommonResult handleBlock(Long id, BlockException e) {
//        return CommonResult.error("服务调用失败，请稍后再试！" + e.getMessage());
//    }
//
//    public CommonResult handleFallback(Long id, Throwable e) {
//        return CommonResult.error("出现异常，请稍后再试！" + e.getMessage());
//    }

    /*************************************************************************************/

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/get2/{id}")
    public CommonResult getPaymentId2(@PathVariable("id") Long id) {
        CommonResult result = paymentService.getPaymentById(id);
        return result;
    }
}
