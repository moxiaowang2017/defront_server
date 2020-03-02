package com.interview.defront.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.interview.defront.domain.DefrontMarkQuestion;


public interface MarkQuestionService extends IService<DefrontMarkQuestion> {

    /**
     * 根据userId获取个人常见问题
     * @param userId
     * @param question
     * @return
     */
    IPage<DefrontMarkQuestion> queryByParam(Page<DefrontMarkQuestion> page, String userId, String question);


    /**
     * 根据用户Id和问题ID删除标注问题
     * @param userId
     * @param questionId
     * @return
     */
    int deleteByQuestionId(String userId,String questionId);

    /**
     * 获取当前标注的问题数
     * @param userId
     * @return
     */
    int getMarkQuestionCount(String userId);
}
