package com.interview.defront.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.interview.defront.domain.DefrontQuestion;
import com.interview.defront.domain.DefrontTrainingQuestion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;


@Mapper
public interface TrainingQuestionMapper extends BaseMapper<DefrontTrainingQuestion> {

    @Select("select category,count(*) as num from defront_training_question group by category")
    List<Map<String, Integer>> getCategoryNum();
}
