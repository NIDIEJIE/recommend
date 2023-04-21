package com.linmj.mapper;

import com.linmj.domain.Strategy;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;


public interface StrategyMapper {
    @Select("SELECT COUNT(*) FROM strategy WHERE status_value < 0.90 AND user_id = #{id}")
    Integer getUrgentNum(Integer id);
    @Select("SELECT COUNT(*) FROM strategy WHERE status_value >= 0.90 AND status_value < 0.95 AND user_id = #{id}")
    Integer getSeriousNum(Integer id);
    @Select("SELECT COUNT(*) FROM strategy WHERE status_value >= 0.95 AND status_value < 0.99 AND user_id = #{id}")
    Integer getNoticeNum(Integer id);
    @Select("SELECT COUNT(*) FROM strategy WHERE status_value >= 0.99 AND user_id = #{id}")
    Integer getNormalNum(Integer id);

    void insert(Strategy strategy);

    @Delete("delete from strategy where id = #{strategy_id}")
    void deleteById(Integer strategy_id);
}
