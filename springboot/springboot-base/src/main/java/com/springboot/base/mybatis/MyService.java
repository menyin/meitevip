package com.springboot.base.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyService {
    /**
     * 整合后自带事务
     */
    @Autowired
    private PersonMapper personMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Transactional
    public int addPersonStudent(){
        int result=0;
        result+=personMapper.insert(17,"xiaomao",18);
//        int e=1/0;
        result+=studentMapper.insert(17,"laomao","金尚小区");
        return result;
    }
}
