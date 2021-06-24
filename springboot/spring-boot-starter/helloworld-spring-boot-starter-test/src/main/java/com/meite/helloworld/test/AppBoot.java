package com.meite.helloworld.test;

import com.meite.helloworld.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义插件规范详见csdn《Spring Boot入门教程(三十一): 自定义Starter》
 */
@SpringBootApplication
@RestController
public class AppBoot {
    @Autowired
    private HelloService helloService;

    public static void main(String[] args) {
        SpringApplication.run(AppBoot.class, args);
    }

    @RequestMapping("/hello")
    public String hello() {
       return helloService.sayHello();
    }
}
