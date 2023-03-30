package com.linmj.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class History {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer strategy_id;
    private Integer user_id;
    private String linename;
    private String date;
}

