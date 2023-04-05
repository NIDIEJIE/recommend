package com.linmj.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StrategyMapper {
    @Select("SELECT COUNT(*) FROM strategy WHERE status_value < 0.90")
    Integer getUrgentNum();
    @Select("SELECT COUNT(*) FROM strategy WHERE status_value >= 0.90 AND status_value < 0.95")
    Integer getSeriousNum();
    @Select("SELECT COUNT(*) FROM strategy WHERE status_value >= 0.95 AND status_value < 0.99")
    Integer getNoticeNum();
    @Select("SELECT COUNT(*) FROM strategy WHERE status_value >= 0.99;")
    Integer getNormalNum();

}
