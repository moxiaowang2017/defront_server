package com.interview.defront.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.interview.defront.domain.DefrontCompanyDiscuss;
import com.interview.defront.dto.CompanyDiscussDto;

import java.util.Map;


public interface CompanyDiscussService extends IService<DefrontCompanyDiscuss> {

    /**
     * 根据公司Id查询
     * @param page
     * @param companyId
     * @return
     */
    IPage<DefrontCompanyDiscuss> queryByParam(Page<DefrontCompanyDiscuss> page, String companyId);

    /**
     * 平阿吉公司
     * @param userId 用户Id
     * @param discussDto
     * @return
     */
    Map<String,Object> insertDiscuss(String userId, CompanyDiscussDto discussDto);
}
