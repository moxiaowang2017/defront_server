package com.interview.defront.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.interview.defront.domain.DefrontQuestion;


public interface QuestionService extends IService<DefrontQuestion> {

    /**
     * 根据问题类型和查询问题
     * @param type
     * @param question
     * @return
     */
    IPage<DefrontQuestion> queryByParam(Page<DefrontQuestion> page, Integer type, String question);

    /**
     * 根据问题类型和查询问题(未标注的)
     * @param type
     * @param question
     * @return
     */
    IPage<DefrontQuestion> queryByParamNoMark(Page<DefrontQuestion> page, Integer type, String question,String userId);


}
