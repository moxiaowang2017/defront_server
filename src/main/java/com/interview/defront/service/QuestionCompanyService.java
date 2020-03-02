package com.interview.defront.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.interview.defront.domain.DefrontQuestionCompany;

import java.util.List;


public interface QuestionCompanyService extends IService<DefrontQuestionCompany> {

    IPage<DefrontQuestionCompany> searchByCompanyId(String userId,String companyId,Integer pageNo,Integer pageSize);

    IPage<DefrontQuestionCompany> searchIsMarkByCompanyId(String userId,String companyId,Integer pageNo,Integer pageSize);

    void insertConcatQuestion(String userId,List<DefrontQuestionCompany> questionCompanyList, String company);
}
