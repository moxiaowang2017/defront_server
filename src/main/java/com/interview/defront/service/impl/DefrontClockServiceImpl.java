package com.interview.defront.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.interview.defront.domain.DefrontClock;
import com.interview.defront.domain.DefrontPublish;
import com.interview.defront.mapper.DefrontClockMapper;
import com.interview.defront.service.DefrontClockService;
import com.interview.defront.utils.MyDateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DefrontClockServiceImpl extends ServiceImpl<DefrontClockMapper, DefrontClock> implements DefrontClockService {

    @Autowired
    private DefrontClockMapper defrontClockMapper;

    @Override
    public Boolean isClock(String userId) {
        QueryWrapper<DefrontClock> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId).eq("clock_time_str", MyDateUtil.getCurDateStr());
        Integer count = defrontClockMapper.selectCount(queryWrapper);
        if(count > 0){
            return true;
        }
        return false;
    }
}
