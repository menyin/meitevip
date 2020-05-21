package com.springboot.base.api;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyExeceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public String runExeception(){
        return "你要的数据被外星人抓走了。。。。";
    }
    @ExceptionHandler(MyExeception.class)
    public String myException2View(){
        return "myExceptionView";
    }
}
