package com.meite.springcloud.sentinel.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class SentinelService {
    @SentinelResource(value = "getSentinel", blockHandler = "getSentinelQpsException")//如果不加注解则默认的vlue就是路径"/getSentinel",记得要加"/"
    @RequestMapping("/getSentinel")
    public String getSentinel(){
        return "世界和平。。。。。";
    }
    public String getSentinelQpsException(BlockException e){
        System.out.println("cny输出错误："+e.getMessage());
        return "世界不太平，遭受攻击了~ ";
    }
}
