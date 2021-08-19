package com.sh.springcloud.controller;

import com.sh.springcloud.bean.CommonResult;
import com.sh.springcloud.bean.Payment;
import com.sh.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        if (result > 0) {
            return CommonResult.success(result, "创建成功，port=" + port);
        } else {
            return CommonResult.error("创建失败，port=" + port);
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        CommonResult commonResult = paymentService.getPaymentById(id);
        commonResult.setMessage(commonResult.getMessage() + "，port=" + port);
        return commonResult;
    }

    @GetMapping("/get2/{id}")
    public CommonResult getPaymentById2(@PathVariable("id") Long id) {
        CommonResult commonResult = paymentService.getPaymentById2(id);
        commonResult.setMessage(commonResult.getMessage() + "，port=" + port);
        return commonResult;
    }
}
