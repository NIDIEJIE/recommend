package com.linmj.controller;

import cn.hutool.core.util.StrUtil;
import com.linmj.common.Code;
import com.linmj.common.Result;
import com.linmj.domain.User;
import com.linmj.mapper.UserMapper;
import com.linmj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        if (StrUtil.isBlank(username) || StrUtil.isBlank(password)) {
            System.out.println(user);
            return Result.error(Code.CODE_400, "参数错误");
        }
        User out = userService.login(user);
        return Result.success(out);
    }
    // 新增和修改
    @PostMapping
    public Integer save(@RequestBody User user) {
        return userService.save(user);
    }

    //查询所有数据
    @GetMapping
    public List<User> getAll(){
        return userMapper.findAll();
    }

    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable Integer id) {
        return userMapper.deleteById(id);
    }

}
