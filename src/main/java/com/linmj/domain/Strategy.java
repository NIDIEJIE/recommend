package com.linmj.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Strategy {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer user_id;
    private String strategy;
    private double status_value;
    private String date;
}

