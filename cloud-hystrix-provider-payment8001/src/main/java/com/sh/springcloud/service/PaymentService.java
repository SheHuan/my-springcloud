package com.sh.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sh.springcloud.bean.CommonResult;
import com.sh.springcloud.bean.Payment;
import com.sh.springcloud.dao.PaymentDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    PaymentDao paymentDao;

    public int create(Payment payment) {
        return paymentDao.insert(payment);
    }

    /**
     * 调用方法执行超时、异常，会执行 getPaymentByIdFallback 实现===降级===处理
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "getPaymentByIdFallback",
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})
    public CommonResult getPaymentById(@Param("id") Long id) {
//        int i = 1/0;
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Payment payment = paymentDao.selectByPrimaryKey(id);

        if (payment != null) {
            return CommonResult.success(payment, "查询成功");
        } else {
            return CommonResult.error("未查询到数据");
        }
    }

    /**
     * 实现===熔断===处理
     * 由于一些异常原因，触发熔断条件后，熔断器打开，熔断后会开始一个休眠时间窗，在这个时间窗内，即使是正确的请求也不能被处理，直接拒绝掉，进入降级方法，
     * 当休眠时间窗结束后，熔断器将进入半开状态，释放一次请求到原来的主逻辑上，如果处理成功则熔断器关闭，主逻辑恢复，
     * 如果依旧有问题则熔断器继续打开，再次进入休眠时间窗
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "getPaymentByIdFallback",
            commandProperties = {
                    @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 是否开启熔断器
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 一个活动窗口期内触发熔断的最少请求次数
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "20000"), // 在熔断后拒绝请求的时间，之后尝试恢复
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") // 请求失败率达到多少就熔断
            })
    public CommonResult getPaymentById2(@Param("id") Long id) {

        if (id <= 0){
            throw new RuntimeException("参数异常");
        }

        Payment payment = paymentDao.selectByPrimaryKey(id);

        if (payment != null) {
            return CommonResult.success(payment, "查询成功");
        } else {
            return CommonResult.error("未查询到数据");
        }
    }

    public CommonResult getPaymentByIdFallback(Long id) {
        return CommonResult.error("服务异常，请稍后再试");
    }
}
