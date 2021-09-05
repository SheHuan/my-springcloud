package com.sh.springcloud.config;

import com.alibaba.cloud.sentinel.rest.SentinelClientHttpResponse;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSON;
import com.sh.springcloud.bean.CommonResult;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;

// https://www.jianshu.com/p/453cfc584a3c
public class ExceptionUtils {
    // 熔断后处理的方法
    public static SentinelClientHttpResponse handleFallback(HttpRequest request, byte[] body, ClientHttpRequestExecution execution, BlockException e) {
        CommonResult result = CommonResult.error("出现异常，请稍后再试！");
        return new SentinelClientHttpResponse(JSON.toJSONString(result));
    }

    // 限流后处理的方法
    public static SentinelClientHttpResponse handleBlock(HttpRequest request, byte[] body, ClientHttpRequestExecution execution, BlockException e) {
        CommonResult result = CommonResult.error("服务调用失败，请稍后再试！");
        return new SentinelClientHttpResponse(JSON.toJSONString(result));
    }
}
