package com.example.sentinel.controller;

import com.example.sentinel.domain.Result;
import com.example.sentinel.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Hz~
 * @version 1.0
 * @date 2020/10/26 16:08
 * @Description sentinel限流测试控制层
 */
@RestController("/api")
public class TextController {

    @Autowired
    private TextService textService;

    @GetMapping("/hi/{name}")
    public Result<String> hi(@PathVariable String name) throws InterruptedException {
        return textService.hi(name);
    }

    @GetMapping("/hello")
    public Result<String> hello() throws InterruptedException {
        return textService.hello();
    }

}
