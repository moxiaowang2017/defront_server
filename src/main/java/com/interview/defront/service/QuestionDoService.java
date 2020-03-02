package com.interview.defront.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.interview.defront.domain.DefrontDoQuestion;

import java.util.List;
import java.util.Map;


public interface QuestionDoService extends IService<DefrontDoQuestion> {

    // 获取总数
    int getTotalNum(String userId);

    // 获取错题数量
    int getErrorNum(String userId);

    // 获取分类的数量
    List<Map<String,Integer>> getCategoryNum(String userId);

    // 获取分类的正确率
    List<Map<String,Integer>> getCategoryAcc(String userId);

    // 获取持续的天数
    int getContinueDay(String userId);

    //是否已经存在
    boolean ifExist(String userId,String questionId);

    // 获取个人练习题
    IPage<DefrontDoQuestion> queryDoQuestion(String userId,String type,Integer pageNo,Integer pageSize);

    // 获取当前做题统计
    List<Map<String,Integer>> getDoQuestionChart(String userId);

}
