package com.interview.defront.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.interview.defront.domain.DefrontClock;


public interface DefrontClockService extends IService<DefrontClock> {

    /**
     * 是否已经打卡
     * @param userId
     * @return
     */
    Boolean isClock(String userId);
}
