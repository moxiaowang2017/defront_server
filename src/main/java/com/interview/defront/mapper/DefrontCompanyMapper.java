package com.interview.defront.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.interview.defront.domain.DefrontCompany;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface DefrontCompanyMapper extends BaseMapper<DefrontCompany> {

    /**
     * 根据公司名称模糊查询
     * @param page
     * @param company
     * @return
     */
    IPage<DefrontCompany> queryByParam(Page<DefrontCompany> page, String company);
}
