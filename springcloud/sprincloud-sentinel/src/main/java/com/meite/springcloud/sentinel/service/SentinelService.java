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

    /**
     * 在sentinel控制台配置限流规则，再进行测试.
     * 其实和dubbo的mock差不多一个意思
     * 特别注意：1、该函数的传参必须与资源点的传参一样，并且最后加上BlockException异常参数；同时，返回类型也必须一样。
     *          2、如果不加该处理函数，则默认会直接给用户抛出“No message available...”异常
     * @return
     */
    @SentinelResource(value = "testSentinelLimit", blockHandler = "limitQpsException")//如果不加注解则默认的vlue就是路径"/getSentinel",记得要加"/"
    @RequestMapping("/testSentinelLimit")
    public String testSentinelLimit(){
        return "testSentinelLimit世界和平。。。。。";
    }
    public String limitQpsException(BlockException e){
        System.out.println("cny输出错误："+e.getMessage());
        return "世界不太平，被限流了~ ";
    }



    /**
     * 在sentinel控制台配置RT=1000ms、时间窗口=5s降级规则，再进行测试.
     * 其实和dubbo的mock差不多一个意思
     * 特别注意：1、该函数的传参必须与资源点的传参一样，并且最后加上BlockException异常参数；同时，返回类型也必须一样。
     *          2、如果不加该处理函数，则默认会直接给用户抛出“No message available...”异常
     * @return
     * @remark
     *  特别注意：如果用Thread.sleep(4000)浏览器、RT=1000ms、重复多次刷新来模拟RT超时,会发现返回的都是正确的结果，不会出现预期的降级
     *  因为：1.RT表示1秒内5次请求的平均响应时间，如果超过这个时间则走降级逻辑。 这里应该要在1s内至少要有6次的请求
     *       2.对于浏览器，手工点击刷新时，在一次点击请求未达到一定的时间，第二次点击请求是不会发送出去。
     *  所以：可以利用jmeter等一些工具做单线程循环发送请求测试。 注意不是多线程并发，多线程并发则情况更加复杂。
     */
    @SentinelResource(value = "testSentinelMock", fallback = "limitMock")//如果不加注解则默认的vlue就是路径"/getSentinel",记得要加"/"
    @RequestMapping("/testSentinelMock")
    public String testSentinelMock()  {
        try {
            Thread.sleep(4000);//模拟响应时间超时
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("testSentinelMock visit..................");
        return "testSentinelMock世界和平。。。。。";
    }


    public String limitMock(){
        return "世界不太平，被降级了~ ";
    }





}
