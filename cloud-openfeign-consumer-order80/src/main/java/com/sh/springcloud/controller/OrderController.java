package com.sh.springcloud.controller;

import com.sh.springcloud.bean.CommonResult;
import com.sh.springcloud.bean.Payment;
import com.sh.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consumer/payment")
public class OrderController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        return paymentService.create(payment);
    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentId(@PathVariable("id") Long id) {
        return paymentService.getPaymentById(id);
    }
}
