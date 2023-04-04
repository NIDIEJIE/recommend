package com.linmj.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.linmj.common.Code;
import com.linmj.controller.dto.UserPasswordDTO;
import com.linmj.domain.User;
import com.linmj.exception.ServiceException;
import com.linmj.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public int save(User user) {
        if (user.getId() == null) {
            // user没有id，则表示是新增
            return userMapper.insert(user);
        } else { // 否则为更新
            return userMapper.update(user);
        }
    }

    public User login(User user) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, user.getUsername());
        queryWrapper.eq(User::getPassword, user.getPassword());
        queryWrapper.select(User::getId, User::getUsername, User::getPassword ,User::getAvatarurl);
        User one;
        // 处理异常情况
        try {
            one = userMapper.selectOne(queryWrapper);
        } catch (Exception e) {
            throw new ServiceException(Code.CODE_500, "系统错误");
        }
        if (one != null) {
            // 设置token
//            String token = TokenUtils.genToken(one.getId().toString(), one.getPassword());
//            one.setToken(token);
            return one;
        } else {
            throw new ServiceException(Code.CODE_600, "用户名或密码错误");
        }
    }

    public User getById(Integer id) {
        return userMapper.selectById(id);
    }

    public void updatePassword(UserPasswordDTO userPasswordDTO) {
        int update = userMapper.updatePassword(userPasswordDTO);
        if (update < 1) {
            throw new ServiceException(Code.CODE_600, "密码错误");
        }
    }
}
