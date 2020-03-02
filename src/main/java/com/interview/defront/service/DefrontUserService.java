package com.interview.defront.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.interview.defront.domain.DefrontUser;


public interface DefrontUserService extends IService<DefrontUser> {

    /**
     * 根据OpenId查找用户
     * @param openId
     * @return
     */
    DefrontUser queryByOpenId(String openId);
}
