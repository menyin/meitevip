package com.springboot.base.mybatis;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface StudentMapper {

    @Select("SELECT * FROM student WHERE NAME = #{name}")
    Student findByName(String name);

    @Insert("INSERT INTO student(id,NAME, Address) VALUES(#{id},#{name}, #{address})")
    int insert(@Param("id")Integer id,@Param("name")String name, @Param("address")String address);

}
