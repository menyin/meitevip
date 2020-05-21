package com.meite.springcloud.openfeign.member.service.impl;

import com.meite.springcloud.openfeign.api.member.MemberService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberServiceImpl implements MemberService {
    @Value("${server.port}")
    private String serverPort;

    @Override
    public String getUser(@RequestParam Integer userId) {
        return "port="+serverPort+",userId = " + userId;
    }
}
