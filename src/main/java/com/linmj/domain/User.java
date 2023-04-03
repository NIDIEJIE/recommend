package com.linmj.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.beans.Transient;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String username;
    //前端可以输入密码,但不能获取密码
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String avatarurl;
//    TODO 先暂时不是先JWT
//    private String token;
}
