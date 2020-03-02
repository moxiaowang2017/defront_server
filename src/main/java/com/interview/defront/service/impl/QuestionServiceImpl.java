package com.interview.defront.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.interview.defront.domain.DefrontQuestion;
import com.interview.defront.mapper.QuestionMapper;
import com.interview.defront.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, DefrontQuestion> implements QuestionService {


    @Autowired
    private QuestionMapper questionMapper;

    @Transactional
    public IPage<DefrontQuestion> queryByParam(Page<DefrontQuestion> page, Integer type, String question){
        return questionMapper.queryByParam(page,type,question);
    }

    @Override
    public IPage<DefrontQuestion> queryByParamNoMark(Page<DefrontQuestion> page, Integer type, String question,String userId) {
        return questionMapper.queryByParamNoMark(page, type, question, userId);
    }


}
