package com.interview.defront.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.interview.defront.domain.DefrontPersonalQuestion;

import java.util.List;


public interface PersonalQuestionService extends IService<DefrontPersonalQuestion> {

    /**
     * 根据userId获取个人常见问题
     * @param userId
     * @param question
     * @return
     */
    IPage<DefrontPersonalQuestion> queryByParam(Page<DefrontPersonalQuestion> page, String userId, String question);

    /**
     * 根据userId和questionId获取个人常见问题
     * @param userId
     * @param questionId
     * @return
     */
    List<DefrontPersonalQuestion> searchByQuestionId(String userId, String questionId);
}
