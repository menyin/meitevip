package com.springboot.base.api;

public class MyExeception extends Exception{

    public MyExeception(String message) {
        super(message);
        System.out.println("自定义异常类......");
    }
}
