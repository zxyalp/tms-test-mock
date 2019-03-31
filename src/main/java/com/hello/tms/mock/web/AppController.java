package com.hello.tms.mock.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alp.zxy
 * @date 2019/3/30
 */
@RestController
@RequestMapping("/app")
public class AppController {

    @RequestMapping("/test")
    public String index(){
        return "这是一个简单的测试页面.";
    }

}
