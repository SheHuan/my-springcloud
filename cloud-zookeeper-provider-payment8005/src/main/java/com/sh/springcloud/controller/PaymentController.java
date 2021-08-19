package com.sh.springcloud.controller;

import com.sh.springcloud.bean.CommonResult;
import com.sh.springcloud.bean.Payment;
import com.sh.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/payment")
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
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return CommonResult.success(payment, "查询成功，port=" + port);
        } else {
            return CommonResult.error("未查询到数据，port=" + port);
        }
    }
}
