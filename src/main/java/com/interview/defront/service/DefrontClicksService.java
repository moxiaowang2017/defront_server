package com.interview.defront.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.interview.defront.domain.DefrontClicks;


public interface DefrontClicksService extends IService<DefrontClicks> {

    /**
     * 添加点赞数
     * @param userId
     * @param concatId
     * @return
     */
    int insertClicks(String userId,String concatId);

}
