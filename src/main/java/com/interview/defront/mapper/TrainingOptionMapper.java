package com.interview.defront.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.interview.defront.domain.DefrontTrainingQuestion;
import com.interview.defront.domain.DefrontTrainingQuestionOption;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface TrainingOptionMapper extends BaseMapper<DefrontTrainingQuestionOption> {


}
