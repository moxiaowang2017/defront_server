package com.interview.defront.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.interview.defront.domain.DefrontPublish;


public interface DefrontPublishService extends IService<DefrontPublish> {

    IPage<DefrontPublish> searchByUserId(String userId,Integer pageNo,Integer pageSize);

    int clockPublish(String userId,DefrontPublish defrontPublish) throws Exception;

    int publish(String userId,DefrontPublish defrontPublish) throws Exception;

    int updateClicks(String id);
}
