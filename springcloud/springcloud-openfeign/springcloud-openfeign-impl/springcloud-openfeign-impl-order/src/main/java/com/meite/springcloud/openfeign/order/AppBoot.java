package com.meite.springcloud.openfeign.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * 最终目标：1、测试openfeign客户端基本使用；2、测试openfeign客户端调节负载均衡策略
 */
@SpringBootApplication
@EnableFeignClients//注册openfeign客户端
public class AppBoot {
    public static void main(String[] args) {
        SpringApplication.run(AppBoot.class, args);
    }
}