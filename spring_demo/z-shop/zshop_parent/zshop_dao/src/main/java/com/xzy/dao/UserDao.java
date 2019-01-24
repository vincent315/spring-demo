package com.xzy.dao;

import com.xzy.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {
    @Select("select  id,username,password,phone,email,created,updated from t_user where id =#{userId}")
    User findByID(@Param("userId") Long userId);

    @Insert("INSERT  INTO `t_user`  (username,password,phone,email,created,updated) VALUES (#{username}, #{password},#{phone},#{email},#{created},#{updated});")
    Integer insertUser(User userEntity);

    @Select("select id,username,password,phone,email,created,updated from t_user where username =#{username}")
    User selectByName(@Param("username")String username);
}
