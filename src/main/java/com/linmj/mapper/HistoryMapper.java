package com.linmj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.linmj.domain.History;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HistoryMapper extends BaseMapper<History> {
    @Select("select * from history")
    List<History> getAll();

    @Delete("delete from history where id = #{id}")
    Integer deleteById(Integer id);

    @Insert("INSERT into history(linename, strategy_id, user_id) VALUES (#{linename}, #{strategy_id}," +
            " #{user_id})")
    int insert(History history);

    @Select("SELECT * FROM history where user_id = #{id} ORDER BY date DESC limit #{pageNum}, #{pageSize}")
    List<History> selectPage(Integer pageNum, Integer pageSize, Integer id);

    @Select("select count(*) from history where user_id = #{id}")
    Integer selectTotal(Integer id);

    @Select("select strategy_id from history where id = #{id}")
    Integer selectId(Integer id);
}
