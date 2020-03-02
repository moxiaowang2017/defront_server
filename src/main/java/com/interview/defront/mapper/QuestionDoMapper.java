package com.interview.defront.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.interview.defront.domain.DefrontDoQuestion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;


@Mapper
public interface QuestionDoMapper extends BaseMapper<DefrontDoQuestion> {

    @Select("select category,count(*) as num from defront_do_question where user_id = '${userId}' group by category")
    List<Map<String, Integer>> getCategoryNum(String userId);

    @Select("select category,is_true,count(*) as num from defront_do_question where user_id = '${userId}' and is_true = 1 group by category")
    List<Map<String, Integer>> getCategoryAcc(String userId);

    @Select("select distinct str_date from defront_do_question")
    List<String> getContinueDay(String userId);

    @Select("select question_id from defront_do_question where user_id = '${userId}'")
    List<String> getQuestionIdsByUserId(String userId);

    @Select("select str_date,count(*) as num from defront_do_question where user_id = '${userId}' group by str_date limit 0,10")
    List<Map<String,Integer>> getDoQuestionChart(String userId);
}
