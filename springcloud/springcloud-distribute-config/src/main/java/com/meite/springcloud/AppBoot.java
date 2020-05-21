package com.meite.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * 注意：1、本地配置项不要与线上的配置项重名，
 *      2、线上配置中心的配置文件的DataID必须是"服务名-[版本号].properties|yml"，否则找不到（因为报错我找了很久）
 */

@SpringBootApplication
public class AppBoot {
    public static void main(String[] args) {
        SpringApplication.run(AppBoot.class, args);
    }
}
