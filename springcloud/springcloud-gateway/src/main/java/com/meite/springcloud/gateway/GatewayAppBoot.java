package com.meite.springcloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 步骤：1、先启动两个springcloud-nacos-base-member服务（注册到注册中心）
 * 注意：
 *  1、因为Gateway是基于netty实现不用依赖servlet，所以不能引入spring-boot-starter-web组件，否则报错
 *  2、
 */
@SpringBootApplication
public class GatewayAppBoot {
    public static void main(String[] args) {
        SpringApplication.run(GatewayAppBoot.class, args);
    }
}
