package com.interview.defront.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.interview.defront.domain.DefrontCompany;
import com.interview.defront.domain.DefrontInterview;


public interface DefrontInterviewService extends IService<DefrontInterview> {

    int addInterviewRecord(String userId,DefrontCompany defrontCompany);

    /**
     * 获取面试记录 分页
     * @param userId
     * @return
     */
    IPage<DefrontInterview> getInterviewRecords(String userId,Integer pageNo,Integer pageSize);

    /**
     * 更新评价状态
     * @param id
     * @return
     */
    int updateRecordReview(String id);

    /**
     * 获取未评价的面试记录数量
     * @param userId
     * @return
     */
    int getUnreviewCount(String userId);
}
