package com.linmj.mapper;

import com.linmj.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<User> findAll();

    @Insert("INSERT into user(username, password, avatarurl) VALUES (#{username}, #{password}," +
            " #{avatarurl})")
    int insert(User user);

    int update(User user);

    @Delete("delete from user where id = #{id}")
    Integer deleteById(Integer id);
}
