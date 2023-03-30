package com.linmj.service;

import com.linmj.domain.History;
import com.linmj.mapper.HistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HistoryService {
    @Autowired
    private HistoryMapper historyMapper;
    public Integer insert(History history) {
        return historyMapper.insert(history);
    }

    public List<History> getAll() {
        return historyMapper.getAll();
    }

    public Integer deleteById(Integer id) {
        return historyMapper.deleteById(id);
    }

    public Map<String, Object> findPage(Integer pageNum, Integer pageSize) {
        pageNum = (pageNum - 1) * pageSize;
        List<History> data = historyMapper.selectPage(pageNum, pageSize);
        Integer total = historyMapper.selectTotal();
        Map<String, Object> res = new HashMap<>();
        res.put("data", data);
        res.put("total", total);
        return res;
    }
}
