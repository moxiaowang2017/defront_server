package com.interview.defront.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.interview.defront.domain.DefrontClicks;
import com.interview.defront.mapper.DefrontClicksMapper;
import com.interview.defront.service.DefrontClicksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DefrontClicksServiceImpl extends ServiceImpl<DefrontClicksMapper, DefrontClicks> implements DefrontClicksService {

    @Autowired
    DefrontClicksMapper defrontClicksMapper;

    @Override
    public int insertClicks(String userId, String concatId) {
        if(hasClicks(userId,concatId) > 0){
            DefrontClicks defrontClicks = new DefrontClicks();
            defrontClicks.setUserId(userId);
            defrontClicks.setConcatId(concatId);
            return defrontClicksMapper.insert(defrontClicks);

        }
        return 0;
    }

    /**
     * 是否已点赞
     * @param userId
     * @param concatId
     * @return
     */
    private int hasClicks(String userId,String concatId){
        QueryWrapper<DefrontClicks> wrapper = Wrappers.query();
        wrapper.eq("user_id",userId)
                .eq("concat_id",concatId);
        return defrontClicksMapper.selectCount(wrapper);
    }
}
