package com.interview.defront.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.interview.defront.domain.DefrontCompany;
import com.interview.defront.domain.DefrontCompanyDiscuss;
import com.interview.defront.domain.DefrontUser;
import com.interview.defront.dto.CompanyDiscussDto;
import com.interview.defront.mapper.DefrontCompanyDiscussMapper;
import com.interview.defront.mapper.DefrontCompanyMapper;
import com.interview.defront.mapper.DefrontUserMapper;
import com.interview.defront.service.CompanyDiscussService;
import com.interview.defront.service.DefrontInterviewService;
import jodd.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service
public class CompanyDiscussServiceImpl extends ServiceImpl<DefrontCompanyDiscussMapper, DefrontCompanyDiscuss> implements CompanyDiscussService {


    @Autowired
    private DefrontCompanyDiscussMapper defrontCompanyDiscussMapper;

    @Autowired
    private DefrontCompanyMapper defrontCompanyMapper;

    @Autowired
    private DefrontUserMapper defrontUserMapper;

    @Autowired
    private DefrontInterviewService defrontInterviewService;

    /**
     * 根据公司Id查询
     * @param page
     * @param companyId
     * @return
     */
    public IPage<DefrontCompanyDiscuss> queryByParam(Page<DefrontCompanyDiscuss> page, String companyId){
        return defrontCompanyDiscussMapper.queryByParam(page,companyId);
    }

    @Override
    public Map<String,Object> insertDiscuss(String userId, CompanyDiscussDto discussDto) {
        Map<String,Object> returnMap = new HashMap<String,Object>();
        DefrontCompanyDiscuss discuss = discussDto.getDefrontCompanyDiscuss();
        String company = discussDto.getCompany();
        returnMap.put("companyId",discuss.getCompanyId());
        if(StringUtil.isBlank(discuss.getCompanyId()) && company!=null){
            DefrontCompany companyBean = new DefrontCompany();
            companyBean.setName(String.valueOf(discussDto.getCompany()));
            if(defrontCompanyMapper.insert(companyBean) == 1){
                discuss.setCompanyId(companyBean.getId());
                returnMap.put("companyId",companyBean.getId());
            }
        }
        DefrontUser user = defrontUserMapper.selectById(userId);
        discuss.setDiscussTime(new Date());
        discuss.setUserId(user.getId());
        discuss.setNickName(user.getNickname());
        discuss.setAvatar(user.getAvatar());
        defrontCompanyDiscussMapper.insert(discuss);
        if(discussDto.getRecordId()!=null){
            defrontInterviewService.updateRecordReview(discussDto.getRecordId());
        }
        returnMap.put("discuss",discuss);
        return returnMap;
    }

}
