package com.linmj.controller;

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

    // 新增和修改
    @PostMapping
    public Integer save(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping
    public List<User> getAll(){
        return userMapper.findAll();
    }

    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable Integer id) {
        return userMapper.deleteById(id);
    }
}
