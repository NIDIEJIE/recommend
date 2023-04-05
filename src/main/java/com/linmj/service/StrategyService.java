package com.linmj.service;

import com.linmj.mapper.StrategyMapper;
import com.linmj.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StrategyService {
    @Autowired
    private StrategyMapper strategyMapper;

    public List<Integer> getChartData() {
        Integer urgent = strategyMapper.getUrgentNum();
        Integer serious = strategyMapper.getSeriousNum();
        Integer notice = strategyMapper.getNoticeNum();
        Integer normal = strategyMapper.getNormalNum();
        List<Integer> data = new ArrayList<Integer>();
        data.add(urgent);
        data.add(serious);
        data.add(notice);
        data.add(normal);
        return data;
    }
}
