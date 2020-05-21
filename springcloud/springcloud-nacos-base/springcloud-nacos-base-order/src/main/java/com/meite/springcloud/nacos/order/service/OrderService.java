package com.meite.springcloud.nacos.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController

public class OrderService {
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("/o2m")
    public String order2Menber(){
        // 1.根据服务名称从 注册中心获取集群列表地址
        List<ServiceInstance> instances =
                discoveryClient.getInstances("springcloud-nacos-base-member");
        String result= restTemplate.getForObject(instances.get(0).getUri() + "/getUser", String.class);
        return "orderResult:"+result;
    }
}
