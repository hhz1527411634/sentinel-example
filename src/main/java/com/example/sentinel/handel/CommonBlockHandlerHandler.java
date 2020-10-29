package com.example.sentinel.handel;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.sentinel.domain.Result;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * @author Hz~
 * @version 1.0
 * @date 2020/10/26 16:13
 * @Description 自定义全局限流异常，使用反射机制获取方法，方法必须加staticjinxin
 */
public class CommonBlockHandlerHandler {

    public static Result<String> blockHandler(String name, BlockException e) throws IOException {
        return Result.sentinelError("blockHandler：" + name, e.getMessage());
    }

    public static Result<String> fallBack(String name, BlockException e) throws IOException {
        return Result.sentinelError("fallBack" + name, e.getMessage());
    }
}
