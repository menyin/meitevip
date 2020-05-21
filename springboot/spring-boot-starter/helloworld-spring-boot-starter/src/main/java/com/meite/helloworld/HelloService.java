package com.meite.helloworld;

public class HelloService {
    private HelloProperties properties;

    public HelloService() {
    }

    public HelloService(HelloProperties properties) {
        this.properties = properties;
    }

    public String sayHello(){
       return "大家好，我叫: " + properties.getName() + ", 今年" + properties.getAge() + "岁"
               + ", 性别: " + properties.getSex();
    }

}
