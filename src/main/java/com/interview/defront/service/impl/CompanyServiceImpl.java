package com.interview.defront.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.interview.defront.domain.DefrontCompany;
import com.interview.defront.mapper.DefrontCompanyMapper;
import com.interview.defront.service.CompanyService;
import jodd.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CompanyServiceImpl extends ServiceImpl<DefrontCompanyMapper, DefrontCompany> implements CompanyService {


    @Autowired
    private DefrontCompanyMapper defrontCompanyMapper;

    @Transactional
    public IPage<DefrontCompany> queryByParamLike(Page<DefrontCompany> page, String company){
        IPage<DefrontCompany> companyIPage = defrontCompanyMapper.queryByParam(page,company);
        if(companyIPage.getTotal() <= 0){
            return queryAll(page);
        }
        return defrontCompanyMapper.queryByParam(page,company);
    }


    @Override
    public IPage<DefrontCompany> queryByParamEq(String company) {
        Page<DefrontCompany> page = new Page<>(1, 5);
        QueryWrapper<DefrontCompany> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",company);
        return defrontCompanyMapper.selectPage(page,queryWrapper);
    }

    private IPage<DefrontCompany> queryAll(Page<DefrontCompany> page){
        QueryWrapper<DefrontCompany> queryWrapper = new QueryWrapper<>();
        return defrontCompanyMapper.selectPage(page,queryWrapper);
    }

    private List<DefrontCompany> queryByCompany(String company){
        QueryWrapper<DefrontCompany> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",company);
        return defrontCompanyMapper.selectList(queryWrapper);
    }

    /**
     * 保存公司名，并返回当前Id
     * @param company
     * @return
     */
    public String insertCompany(String company){
        if(StringUtil.isNotBlank(company)){
            List<DefrontCompany> defrontCompanies = queryByCompany(company);
            if(defrontCompanies!=null && defrontCompanies.size()>0){
                return defrontCompanies.get(0).getId();
            }else{
                DefrontCompany defrontCompany = new DefrontCompany();
                defrontCompany.setName(company);
                defrontCompanyMapper.insert(defrontCompany);
                return defrontCompany.getId();
            }
        }
        return null;
    }
}
