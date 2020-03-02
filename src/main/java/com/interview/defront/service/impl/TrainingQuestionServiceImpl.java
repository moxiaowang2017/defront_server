package com.interview.defront.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.interview.defront.domain.DefrontQuestion;
import com.interview.defront.domain.DefrontTrainingQuestion;
import com.interview.defront.domain.Enum.CategoryEum;
import com.interview.defront.mapper.QuestionDoMapper;
import com.interview.defront.mapper.QuestionMapper;
import com.interview.defront.mapper.TrainingQuestionMapper;
import com.interview.defront.service.QuestionService;
import com.interview.defront.service.TrainingQuestionService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service
public class TrainingQuestionServiceImpl extends ServiceImpl<TrainingQuestionMapper, DefrontTrainingQuestion> implements TrainingQuestionService {


    @Autowired
    private TrainingQuestionMapper trainingQuestionMapper;


    public IPage<DefrontTrainingQuestion> queryByCategory(String userId,Integer category, Integer pageNo,Integer pageSize){
        Page<DefrontTrainingQuestion> page = new Page<DefrontTrainingQuestion>(pageNo, pageSize);
        QueryWrapper<DefrontTrainingQuestion> wrapper = Wrappers.query();
        wrapper.eq("category",category)
                .orderByAsc("order_index")
                .notInSql("id","select question_id from defront_do_question where user_id = '" + userId + "'" );
        return trainingQuestionMapper.selectPage(page,wrapper);
    }

    @Override
    public List<Map<String, Integer>> getCategoryNum() {
        return trainingQuestionMapper.getCategoryNum();
    }
}
