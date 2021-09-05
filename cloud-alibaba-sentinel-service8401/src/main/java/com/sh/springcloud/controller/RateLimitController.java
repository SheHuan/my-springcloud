package com.sh.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sh.springcloud.bean.CommonResult;
import com.sh.springcloud.handler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * blockHandler 函数访问范围需要是 public，返回类型需要与原方法相匹配，
 * 参数类型需要和原方法相匹配并且最后加一个额外的参数，类型为 BlockException。
 * blockHandler 函数默认需要和原方法在同一个类中。
 * 若希望使用其他类的函数，则可以指定 blockHandlerClass 为对应的类的 Class 对象，
 * 注意对应的函数必需为 static 函数，否则无法解析
 */
@RestController
public class RateLimitController {
    // 后台配置的资源名为/byResource时，访问改接口，触发限流规则时无法调用blockHandler的方法
    // 配置为byResource则可以
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleBlock")
    public CommonResult byResource(String id) {
        return CommonResult.success("", "按资源名称限流测试ok");
    }
    // 在同一个类里定义blockHandler
    public CommonResult handleBlock(String id, BlockException blockException) {
        return CommonResult.error("服务不可用！");
    }

    // 调用外部类里定义的blockHandler
    @GetMapping("/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handleBlock")
    public CommonResult customerBlockHandler() {
        return CommonResult.success("", "按资源名称限流测试ok");
    }
}
