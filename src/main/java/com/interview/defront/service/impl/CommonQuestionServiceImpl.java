package com.interview.defront.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.interview.defront.domain.DefrontCommonQuestion;
import com.interview.defront.domain.DefrontPersonalQuestion;
import com.interview.defront.mapper.CommonQuestionMapper;
import com.interview.defront.mapper.PersonalQuestionMapper;
import com.interview.defront.service.CommonQuestionService;
import com.interview.defront.service.PersonalQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CommonQuestionServiceImpl extends ServiceImpl<CommonQuestionMapper, DefrontCommonQuestion> implements CommonQuestionService {

    @Autowired
    private CommonQuestionMapper commonQuestionMapper;

    @Override
    public IPage<DefrontCommonQuestion> selectPagesByOrder(Integer pageNo, Integer pageSize) {
        Page<DefrontCommonQuestion> page = new Page<DefrontCommonQuestion>(pageNo, pageSize);
        QueryWrapper<DefrontCommonQuestion> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("recommendation");
        IPage<DefrontCommonQuestion> questionIPage = commonQuestionMapper.selectPage(page, queryWrapper);
        return questionIPage;
    }


}
