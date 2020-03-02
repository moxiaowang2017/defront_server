package com.interview.defront.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.interview.defront.domain.DefrontCompany;
import com.interview.defront.domain.DefrontMarkQuestion;


public interface CompanyService extends IService<DefrontCompany> {

    /**
     * 根据company模糊查询
     * @param company
     * @return
     */
    IPage<DefrontCompany> queryByParamLike(Page<DefrontCompany> page, String company);

    /**
     * 根据company查询
     * @param company
     * @return
     */
    IPage<DefrontCompany> queryByParamEq(String company);


    /**
     * 保存公司名，并返回当前Id
     * @param company
     * @return
     */
    String insertCompany(String company);
}
