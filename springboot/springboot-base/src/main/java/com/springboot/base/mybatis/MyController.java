package com.springboot.base.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * sb整合mybatis
 */
@SpringBootApplication
@MapperScan("com.cny.mybatis")
@RestController
public class MyController {
    @Autowired
    private PersonMapper personMapper;


    @Autowired
    private MyService myService;
    /**
     * 基本测试
     * @param name
     * @return
     */
    @RequestMapping("findByName")
    public Person index(String name){
        Person person=personMapper.findByName(name);
        return person;
    }

    @RequestMapping("adds")
    public int adds(){
        return myService.addPersonStudent();
    }
    public static void main(String[] args) {
        SpringApplication.run(MyController.class, args);
    }
}
