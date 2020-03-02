package com.interview.defront.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.interview.defront.domain.DefrontCompanyDiscuss;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface DefrontCompanyDiscussMapper extends BaseMapper<DefrontCompanyDiscuss> {

    /**
     * 根据公司Id查询
     * @param page
     * @param companyId
     * @return
     */
    IPage<DefrontCompanyDiscuss> queryByParam(Page<DefrontCompanyDiscuss> page, String companyId);
}
