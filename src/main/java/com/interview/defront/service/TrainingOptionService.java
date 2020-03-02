package com.interview.defront.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.interview.defront.domain.DefrontTrainingQuestionOption;

import java.util.List;


public interface TrainingOptionService extends IService<DefrontTrainingQuestionOption> {

    /**
     * 根据问题ID获取问题选项
     * @return
     */
    List<DefrontTrainingQuestionOption> queryByQuestionId(String questionId);
}
