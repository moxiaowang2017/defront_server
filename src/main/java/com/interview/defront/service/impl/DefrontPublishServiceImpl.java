package com.interview.defront.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.interview.defront.domain.DefrontClock;
import com.interview.defront.domain.DefrontPublish;
import com.interview.defront.domain.DefrontUser;
import com.interview.defront.mapper.DefrontClockMapper;
import com.interview.defront.mapper.DefrontPublishMapper;
import com.interview.defront.mapper.DefrontUserMapper;
import com.interview.defront.service.DefrontPublishService;
import com.interview.defront.utils.MyDateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class DefrontPublishServiceImpl extends ServiceImpl<DefrontPublishMapper, DefrontPublish> implements DefrontPublishService {

    @Autowired
    private DefrontPublishMapper defrontPublishMapper;

    @Autowired
    private DefrontClockMapper defrontClockMapper;

    @Autowired
    private DefrontUserMapper defrontUserMapper;

    @Override
    public IPage<DefrontPublish> searchByUserId(String userId, Integer pageNo, Integer pageSize) {
        Page<DefrontPublish> page = new Page<DefrontPublish>(pageNo, pageSize);
        QueryWrapper<DefrontPublish> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId).orderByDesc("publish_time");
        return defrontPublishMapper.selectPage(page,queryWrapper);
    }

    // 获取当前连续打卡天数
    private int getClockContinueDay(String userId){
        QueryWrapper<DefrontClock> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId).eq("clock_time_str",MyDateUtil.getLastDateStr());
        List<DefrontClock> defrontClocks = defrontClockMapper.selectList(queryWrapper);
        if(defrontClocks == null || defrontClocks.size()<=0){
            return 1;
        }else{
            return defrontClocks.get(0).getContinueDay();
        }
    }
    /**
     * 打卡
     * @param userId
     * @param defrontPublish
     * @return
     */
    @Override
    public int clockPublish(String userId, DefrontPublish defrontPublish) throws Exception{
        DefrontUser defrontUser = defrontUserMapper.selectById(userId);
        defrontPublish.setUserId(userId);
        defrontPublish.setAvatar(defrontUser.getAvatar());
        defrontPublish.setNickName(defrontUser.getNickname());
        defrontPublish.setPublishTime(LocalDateTime.now());
        defrontPublish.setPublishTimeStr(MyDateUtil.getCurTimeStr());
        defrontPublish.setClicks(0);
        defrontPublish.setReviewNum(0);
        defrontPublishMapper.insert(defrontPublish);
        DefrontClock defrontClock = new DefrontClock();
        defrontClock.setClockTimeStr(MyDateUtil.getCurDateStr());
        defrontClock.setContinueDay(getClockContinueDay(userId));
        defrontClock.setUserId(userId);
        defrontClockMapper.insert(defrontClock);
        return 1;
    }


    /**
     * 发布内容
     * @param userId
     * @param defrontPublish
     * @return
     * @throws Exception
     */
    @Override
    public int publish(String userId, DefrontPublish defrontPublish) throws Exception {
        DefrontUser defrontUser = defrontUserMapper.selectById(userId);
        defrontPublish.setUserId(userId);
        defrontPublish.setAvatar(defrontUser.getAvatar());
        defrontPublish.setNickName(defrontUser.getNickname());
        defrontPublish.setPublishTime(LocalDateTime.now());
        defrontPublish.setPublishTimeStr(MyDateUtil.getCurTimeStr());
        defrontPublish.setClicks(0);
        defrontPublish.setReviewNum(0);
        defrontPublishMapper.insert(defrontPublish);
        return 1;
    }

    @Override
    public int updateClicks(String id) {
        DefrontPublish defrontPublish = defrontPublishMapper.selectById(id);
        defrontPublish.setClicks(defrontPublish.getClicks() + 1);
        return defrontPublishMapper.updateById(defrontPublish);
    }


}
