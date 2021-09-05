package com.sh.springcloud.service;

import com.sh.springcloud.bean.CommonResult;

/**
 * 服务降级的处理方法
 */
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult getPaymentById(Long id) {
        return CommonResult.error("请稍后再试！");
    }
}
