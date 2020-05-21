package com.springboot.base.mybatis;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface PersonMapper {

    @Select("SELECT * FROM person WHERE NAME = #{name}")
    Person findByName(String name);

    @Insert("INSERT INTO person(Id,Name, Age) VALUES(#{id},#{name},#{age})")
    int insert(@Param("id")Integer id,@Param("name")String name, @Param("age")Integer age);
}
