package com.interview.defront.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.interview.defront.domain.DefrontPersonalQuestion;
import com.interview.defront.domain.DefrontQuestion;
import com.interview.defront.mapper.PersonalQuestionMapper;
import com.interview.defront.mapper.QuestionMapper;
import com.interview.defront.service.PersonalQuestionService;
import com.interview.defront.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class PersonalQuestionServiceImpl extends ServiceImpl<PersonalQuestionMapper, DefrontPersonalQuestion> implements PersonalQuestionService {


    @Autowired
    private PersonalQuestionMapper personalQuestionMapper;

    @Transactional
    public IPage<DefrontPersonalQuestion> queryByParam(Page<DefrontPersonalQuestion> page, String userId, String question){
        return personalQuestionMapper.queryByParam(page,userId,question);
    }

    @Override
    public List<DefrontPersonalQuestion> searchByQuestionId(String userId, String questionId) {
        QueryWrapper<DefrontPersonalQuestion> wrapper = Wrappers.query();
        wrapper.eq("user_id",userId)
                .eq("common_id",questionId);
        List<DefrontPersonalQuestion> personalQuestionList = personalQuestionMapper.selectList(wrapper);
        return personalQuestionList;
    }

}
