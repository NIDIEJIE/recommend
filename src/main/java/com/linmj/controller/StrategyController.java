package com.linmj.controller;

import com.linmj.common.Result;
import com.linmj.controller.dto.ParamInputDTO;
import com.linmj.domain.User;
import com.linmj.service.StrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/strategy")
public class StrategyController {
    @Autowired
    private StrategyService strategyService;

    @PostMapping
    public Result getStrategy(@RequestBody ParamInputDTO data){
        System.out.println(data);
        String res = strategyService.generateStrategy(data);
        return Result.success(res);
    }
}
