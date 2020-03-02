package com.interview.defront.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.interview.defront.domain.DefrontTrainingQuestion;
import com.interview.defront.domain.DefrontTrainingQuestionOption;
import com.interview.defront.domain.Enum.CategoryEum;
import com.interview.defront.mapper.TrainingOptionMapper;
import com.interview.defront.mapper.TrainingQuestionMapper;
import com.interview.defront.service.TrainingOptionService;
import com.interview.defront.service.TrainingQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TrainingOptionServiceImpl extends ServiceImpl<TrainingOptionMapper, DefrontTrainingQuestionOption> implements TrainingOptionService {


    @Autowired
    private TrainingOptionMapper trainingOptionMapper;
    @Override
    public List<DefrontTrainingQuestionOption> queryByQuestionId(String questionId) {
        QueryWrapper<DefrontTrainingQuestionOption> wrapper = Wrappers.query();
        wrapper.eq("question_id",questionId).orderByAsc("weight");
        return trainingOptionMapper.selectList(wrapper);
    }
}
