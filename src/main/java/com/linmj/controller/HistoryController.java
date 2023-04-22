package com.linmj.controller;

import com.linmj.common.Result;
import com.linmj.domain.History;
import com.linmj.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/history")
public class HistoryController {
    @Autowired
    private HistoryService historyService;


    // 新增
    @PostMapping
    public Integer save(@RequestBody History history) {
        return historyService.insert(history);
    }

    //查询所有数据
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        String res = historyService.getById(id);
        return Result.success(res);
    }

    // 分页查询
    // 接口路径：/history/page?pageNum=1&pageSize=10
    // @RequestParam接受
    // TODO 根据用户id查询所有分页历史记录
    @GetMapping("/page")
    public Map<String, Object> findPage(@RequestParam Integer pageNum,
                                        @RequestParam Integer pageSize,
                                        @RequestParam Integer id) {
        return historyService.findPage(pageNum, pageSize, id);
    }

    //删除指定历史记录
    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable Integer id) {
        return historyService.deleteById(id);
    }
}
