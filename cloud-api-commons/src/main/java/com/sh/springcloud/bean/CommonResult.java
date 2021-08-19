package com.sh.springcloud.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 通用数据返回实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult {
    private Integer code;
    private String message;
    private Object data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }

    public static CommonResult success(Object data, String message) {
        return new CommonResult(200, message, data);
    }

    public static CommonResult error(String message) {
        return new CommonResult(500, message, null);
    }
}
