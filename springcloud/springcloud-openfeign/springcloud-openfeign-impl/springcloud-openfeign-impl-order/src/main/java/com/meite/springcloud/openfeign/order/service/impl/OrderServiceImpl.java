package com.meite.springcloud.openfeign.order.service.impl;

import com.meite.springcloud.openfeign.api.member.MemberService;
import com.meite.springcloud.openfeign.order.httpclient.MemberServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderServiceImpl {
        @Autowired
    private MemberServiceFeign memberServiceFeign;


    /**
     * 基于我们的fegin客户端形式实现rpc远程调用
     *
     * @return
     */
    @RequestMapping("/o2m")
    public String orderFeignToMember(Integer userId) {
//        String result = memberServiceFeign.getUser(userId);
        String result = memberServiceFeign.getUser(userId);
        return "我是订单服务调用会员服务的接口,返回结果" + result;
    }
}
