package com.sh.springcloud.service;

import com.sh.springcloud.bean.CommonResult;
import com.sh.springcloud.bean.Payment;
import org.springframework.stereotype.Component;

/**
 * 服务降级的处理方法
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult create(Payment payment) {
        return CommonResult.error("请稍后再试");
    }

    @Override
    public CommonResult getPaymentById(Long id) {
        return CommonResult.error("请稍后再试");
    }
}
