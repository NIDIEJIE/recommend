package com.linmj.controller;

import com.linmj.common.Result;
import com.linmj.service.StrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/chart")
public class ChartController {

    @Autowired
    private StrategyService strategyService;

    @GetMapping()
    public Result get(@RequestParam Integer id) {
        List<Integer> data = strategyService.getChartData(id);
        return Result.success(data);
    }
}
