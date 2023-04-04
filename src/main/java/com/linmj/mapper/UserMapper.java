package com.linmj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.linmj.controller.dto.UserPasswordDTO;
import com.linmj.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user")
    List<User> findAll();

    @Insert("INSERT into user(username, password, avatarurl) VALUES (#{username}, #{password}," +
            " #{avatarurl})")
    int insert(User user);

    int update(User user);

    @Delete("delete from user where id = #{id}")
    Integer deleteById(Integer id);

    @Update("update user set password = #{newPassword} where username = #{username} and password = #{password}")
    int updatePassword(UserPasswordDTO userPasswordDTO);

}
