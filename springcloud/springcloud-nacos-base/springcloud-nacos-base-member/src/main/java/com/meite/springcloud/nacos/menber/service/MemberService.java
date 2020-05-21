package com.meite.springcloud.nacos.menber.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberService {
    @Value("${server.port}")
    private String serverPort;
    /**
     * 会员服务提供的接口被订单服务调用
     *
     * @param userId
     * @return
     */
    @GetMapping("/getUser")
    public String getUser(Integer userId) {
        return "加油，戈多,端口号为:" + serverPort;
    }
}
