package com.interview.defront.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.interview.defront.domain.DefrontTrainingQuestion;
import com.interview.defront.domain.Enum.CategoryEum;

import java.util.List;
import java.util.Map;


public interface TrainingQuestionService extends IService<DefrontTrainingQuestion> {

    /**
     * 根据分类查找练习题
     * @param userId 用户Id
     * @param category
     * @return
     */
    IPage<DefrontTrainingQuestion> queryByCategory(String userId,Integer category, Integer pageNo,Integer pageSize);

    // 获取分类的数量
    List<Map<String,Integer>> getCategoryNum();
}
