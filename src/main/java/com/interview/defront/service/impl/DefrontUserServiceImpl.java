package com.interview.defront.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.interview.defront.domain.DefrontUser;
import com.interview.defront.mapper.DefrontUserMapper;
import com.interview.defront.service.DefrontUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class DefrontUserServiceImpl extends ServiceImpl<DefrontUserMapper, DefrontUser> implements DefrontUserService {


    @Autowired
    private DefrontUserMapper defrontUserMapper;

    @Transactional
    public DefrontUser queryByOpenId(String openId){
        return defrontUserMapper.queryByOpenId(openId);
    }


}
