package com.jar.wh.mapper;

import com.jar.wh.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;

@Mapper
public interface UserDAO {

    @Select("select * from user where name = #{name}")
    public User find(String name);

    /**
     * 对于多个参数来说，每个参数之前都要加上@Param注解，
     * 要不然会找不到对应的参数进而报错
     * @param name
     * @param age
     * @return
     */
    @Select("select * from user where name = #{name} and age = #{age}")
    public User login(@Param("name")String name, @Param("age") int age);

    @Insert("insert into user(name,age,birthday) values(#{name},#{age},#{birthday})")
    public int addUser(@Param("name")String name, @Param("age")int age, @Param("birthday")Date birthday);
}
