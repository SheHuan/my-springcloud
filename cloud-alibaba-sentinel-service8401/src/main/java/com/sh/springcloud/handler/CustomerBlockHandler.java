package com.sh.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sh.springcloud.bean.CommonResult;

public class CustomerBlockHandler {
    public static CommonResult handleBlock(BlockException blockException) {
        return CommonResult.error("服务不可用！");
    }
}
