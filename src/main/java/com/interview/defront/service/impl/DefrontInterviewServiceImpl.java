package com.interview.defront.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.interview.defront.domain.DefrontCommonQuestion;
import com.interview.defront.domain.DefrontCompany;
import com.interview.defront.domain.DefrontInterview;
import com.interview.defront.mapper.DefrontInterviewMapper;
import com.interview.defront.service.DefrontInterviewService;
import com.interview.defront.utils.MyDateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;


@Service
public class DefrontInterviewServiceImpl extends ServiceImpl<DefrontInterviewMapper, DefrontInterview> implements DefrontInterviewService {

    @Autowired
    private DefrontInterviewMapper defrontInterviewMapper;

    @Override
    public int addInterviewRecord(String userId, DefrontCompany defrontCompany) {
        DefrontInterview defrontInterview = new DefrontInterview();
        defrontInterview.setUserId(userId);
        defrontInterview.setCompany(defrontCompany.getName());
        defrontInterview.setCompanyId(defrontCompany.getId());
        defrontInterview.setInterviewTime(new Date());
        defrontInterview.setInterviewDateStr(MyDateUtil.getCurDateStr());
        return defrontInterviewMapper.insert(defrontInterview);
    }

    @Override
    public IPage<DefrontInterview> getInterviewRecords(String userId,Integer pageNo,Integer pageSize) {
        Page<DefrontInterview> page = new Page<DefrontInterview>(pageNo, pageSize);
        QueryWrapper<DefrontInterview> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId).orderByDesc("interview_time");
        return defrontInterviewMapper.selectPage(page,queryWrapper);
    }

    @Override
    public int updateRecordReview(String id) {
        DefrontInterview defrontInterview = defrontInterviewMapper.selectById(id);
        defrontInterview.setReview(true);
        return defrontInterviewMapper.updateById(defrontInterview);
    }

    public int getUnreviewCount(String userId){
        QueryWrapper<DefrontInterview> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId)
                    .eq("is_review",false);
        return defrontInterviewMapper.selectCount(queryWrapper);
    }
}
