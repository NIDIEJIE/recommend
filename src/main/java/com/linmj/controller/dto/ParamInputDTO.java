package com.linmj.controller.dto;

import lombok.Data;

@Data
public class ParamInputDTO {
    private String transmissionLineName;
    private Integer user_id;
    private ParamInputTowerItemDTO[] towerData;
}
