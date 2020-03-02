package com.interview.defront.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.interview.defront.domain.DefrontDoQuestion;
import com.interview.defront.mapper.QuestionDoMapper;
import com.interview.defront.service.QuestionDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class QuestionDoServiceImpl extends ServiceImpl<QuestionDoMapper, DefrontDoQuestion> implements QuestionDoService {

    @Autowired
    private QuestionDoMapper questionDoMapper;

    @Override
    public int getTotalNum(String userId) {
        QueryWrapper<DefrontDoQuestion> wrapper = Wrappers.query();
        wrapper.eq("user_id",userId);
        return questionDoMapper.selectCount(wrapper);
    }

    @Override
    public int getErrorNum(String userId) {
        QueryWrapper<DefrontDoQuestion> wrapper = Wrappers.query();
        wrapper.eq("user_id",userId)
                .eq("is_true",0);
        return questionDoMapper.selectCount(wrapper);
    }

    @Override
    public List<Map<String,Integer>> getCategoryNum(String userId) {
        return questionDoMapper.getCategoryNum(userId);
    }

    @Override
    public List<Map<String,Integer>> getCategoryAcc(String userId) {
        return questionDoMapper.getCategoryAcc(userId);
    }

    @Override
    public int getContinueDay(String userId) {
        List<String> dayList = questionDoMapper.getContinueDay(userId);
        if(dayList != null){
            return dayList.size();
        }
        return 0;
    }

    @Override
    public boolean ifExist(String userId, String questionId) {
        QueryWrapper<DefrontDoQuestion> wrapper = Wrappers.query();
        wrapper.eq("user_id",userId);
        wrapper.eq("question_id",questionId);
        int count = questionDoMapper.selectCount(wrapper);
        if(count > 0){
            return true;
        }
        return false;
    }

    @Override
    public IPage<DefrontDoQuestion> queryDoQuestion(String userId, String type, Integer pageNo, Integer pageSize) {
        Page<DefrontDoQuestion> page = new Page<DefrontDoQuestion>(pageNo, pageSize);
        QueryWrapper<DefrontDoQuestion> wrapper = Wrappers.query();
        wrapper.eq("user_id",userId);
        if(type.equals("error")){
            wrapper.eq("is_true",0);
        }
        return questionDoMapper.selectPage(page,wrapper);
    }

    @Override
    public List<Map<String,Integer>> getDoQuestionChart(String userId) {
        return questionDoMapper.getDoQuestionChart(userId);
    }
}
