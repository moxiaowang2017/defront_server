package com.interview.defront.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.interview.defront.domain.DefrontCommonQuestion;
import com.interview.defront.domain.DefrontPersonalQuestion;


public interface CommonQuestionService extends IService<DefrontCommonQuestion> {

    /**
     * 分页查询
     * 根据推荐量倒叙排序
     * @return
     */
    IPage<DefrontCommonQuestion> selectPagesByOrder(Integer pageNo,Integer pageSize);
}
