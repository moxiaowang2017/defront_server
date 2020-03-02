package com.interview.defront.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.interview.defront.domain.DefrontMarkQuestion;
import com.interview.defront.domain.DefrontPersonalQuestion;
import com.interview.defront.mapper.MarkQuestionMapper;
import com.interview.defront.mapper.PersonalQuestionMapper;
import com.interview.defront.service.MarkQuestionService;
import com.interview.defront.service.PersonalQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class MarkQuestionServiceImpl extends ServiceImpl<MarkQuestionMapper, DefrontMarkQuestion> implements MarkQuestionService {


    @Autowired
    private MarkQuestionMapper markQuestionMapper;

    @Transactional
    public IPage<DefrontMarkQuestion> queryByParam(Page<DefrontMarkQuestion> page, String userId, String question){
        return markQuestionMapper.queryByParam(page,userId,question);
    }

    @Override
    public int deleteByQuestionId(String userId, String questionId) {
        QueryWrapper<DefrontMarkQuestion> wrapper = Wrappers.query();
        wrapper.eq("user_id",userId)
               .eq("question_id",questionId);
        return markQuestionMapper.delete(wrapper);
    }

    @Override
    public int getMarkQuestionCount(String userId) {
        QueryWrapper<DefrontMarkQuestion> wrapper = Wrappers.query();
        wrapper.eq("user_id",userId);
        return markQuestionMapper.selectCount(wrapper);
    }


}
