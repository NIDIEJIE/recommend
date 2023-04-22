package com.linmj.service;

import com.linmj.domain.History;
import com.linmj.mapper.HistoryMapper;
import com.linmj.mapper.StrategyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HistoryService {
    @Autowired
    private HistoryMapper historyMapper;
    @Autowired
    private StrategyMapper strategyMapper;
    public Integer insert(History history) {
        return historyMapper.insert(history);
    }

    public List<History> getAll() {
        return historyMapper.getAll();
    }

    public Integer deleteById(Integer id) {
        Integer strategyId = historyMapper.selectId(id);
        historyMapper.deleteById(id);
        strategyMapper.deleteById(strategyId);
        return 1;
    }

    public Map<String, Object> findPage(Integer pageNum, Integer pageSize, Integer id) {
        pageNum = (pageNum - 1) * pageSize;
        List<History> data = historyMapper.selectPage(pageNum, pageSize, id);
        Integer total = historyMapper.selectTotal(id);
        Map<String, Object> res = new HashMap<>();
        res.put("data", data);
        res.put("total", total);
        return res;
    }

    public String  getById(Integer id) {
        Integer strId = historyMapper.selectId(id);
        String res = strategyMapper.selectById(strId);
        return res;
    }
}
