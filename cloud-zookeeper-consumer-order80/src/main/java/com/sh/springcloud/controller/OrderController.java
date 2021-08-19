package com.sh.springcloud.controller;

import com.sh.springcloud.bean.CommonResult;
import com.sh.springcloud.bean.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer/payment")
public class OrderController {
//    public static final String PAYMENT_URL = "http://localhost:8001";
    // 目标服务集群部署，同时要实现（客户端）负载均衡，则地址写要调用的服务在注册中心中注册的名称
    public static final String PAYMENT_URL = "http://cloud-payment-service";

    // 实现负载均衡的大致原理
    // 当前服务注册到注册中心后，会拉取其它服务的信息（name、ip、host），并缓存到本地，同时30秒重新拉取更新一次
    // 当调用目标服务时，会根据服务名称从集群中选中一个可用服务，并构造请求地址，发送实际的请求
    // 默认会轮询调用可用的目标服务
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentId(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }
}
