package com.springboot.base.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 基本测试helloworld
 */
@RestController
@EnableAutoConfiguration
public class Hello {
    @RequestMapping("/hello")
    public String index(Model model){
        model.addAttribute("name","埃克斯好特曼");
        return "hello";
    }


}
