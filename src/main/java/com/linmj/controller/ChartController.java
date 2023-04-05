package com.linmj.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.Quarter;
import com.linmj.common.Result;
import com.linmj.service.HistoryService;
import com.linmj.service.StrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/chart")
public class ChartController {

    @Autowired
    private StrategyService strategyService;

    @GetMapping()
    public Result get() {
        List<Integer> data = strategyService.getChartData();
        return Result.success(data);
    }
}
