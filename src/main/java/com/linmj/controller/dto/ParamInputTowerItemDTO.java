package com.linmj.controller.dto;

import lombok.Data;

@Data
public class ParamInputTowerItemDTO {
    private String towerName;
    private ParamDataItemSingleDTO[] dataList;
}
