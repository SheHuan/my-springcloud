package com.sh.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() throws InterruptedException {
//        TimeUnit.SECONDS.sleep(2);
        System.out.println(System.currentTimeMillis() + "-------testA------");
        return "-------testA------";
    }

    @GetMapping("/testB")
    public String testB() {
        return "-------testB------";
    }


    @GetMapping("/testC")
    public String testC() {
        // 熔断策略：慢调用比例
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


        // 熔断策略：异常比例、异常数
        int i = 1 / 0;


        return "-------testC------";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "dealHotKeyLimit")
    public String testHotKey(String p1, String p2) {
        return "-------testHotKey-----";
    }

    public String dealHotKeyLimit(String p1, String p2, BlockException blockException) {
        return "-------dealHotKeyLimit-----";
    }
}
