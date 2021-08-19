package com.sh.springcloud.service;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

// FallbackFactory 可以监听到服务降级的原因
@Component
public class PaymentFallbackFactoryService implements FallbackFactory<PaymentService> {
    @Override
    public PaymentService create(Throwable throwable) {
        System.out.println("fallback reason ===>" + throwable.getMessage());
        return new PaymentFallbackService();
    }
}
