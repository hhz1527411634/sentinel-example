package com.example.sentinel.service;

import cn.hutool.core.exceptions.ExceptionUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.sentinel.domain.Result;
import com.example.sentinel.handel.CommonBlockHandlerHandler;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author Hz~
 * @version 1.0
 * @date 2020/10/27 14:45
 * @Description sentinel限流测试服务层
 */
@Service
public class TextService {

    @SentinelResource(value = "hi", fallback = "fallBack", blockHandler = "blockHandler", blockHandlerClass = CommonBlockHandlerHandler.class)
    public Result<String> hi(String name) {
        return Result.ok("你好呀！ " + name);
    }

    @SentinelResource(value = "hello", blockHandler = "blockHandlerText")
    public Result<String> hello() {
        return Result.ok("你好呀！");
    }
    public Result<String> blockHandlerText(BlockException e) {
        return Result.sentinelError("兄嘚。。。您慢点儿~");
    }
}
