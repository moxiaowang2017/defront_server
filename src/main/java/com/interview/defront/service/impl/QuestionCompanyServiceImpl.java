package com.interview.defront.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.interview.defront.domain.DefrontCompany;
import com.interview.defront.domain.DefrontQuestionCompany;
import com.interview.defront.mapper.DefrontQuestionCompanyMapper;
import com.interview.defront.service.CompanyService;
import com.interview.defront.service.DefrontInterviewService;
import com.interview.defront.service.QuestionCompanyService;
import jodd.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class QuestionCompanyServiceImpl extends ServiceImpl<DefrontQuestionCompanyMapper, DefrontQuestionCompany> implements QuestionCompanyService {


    @Autowired
    private  DefrontQuestionCompanyMapper questionMapper;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private DefrontInterviewService defrontInterviewService;

    @Override
    public IPage<DefrontQuestionCompany> searchByCompanyId(String userId,String companyId,Integer pageNo, Integer pageSize) {
        Page<DefrontQuestionCompany> page = new Page<DefrontQuestionCompany>(pageNo, pageSize);
        QueryWrapper<DefrontQuestionCompany> queryWrapper = new QueryWrapper<DefrontQuestionCompany>();
        queryWrapper.eq("company_id",companyId)
                .notInSql("question_id", "select question_id from defront_mark_question where user_id='" + userId + "'");
        IPage<DefrontQuestionCompany> questionIPage = questionMapper.selectPage(page, queryWrapper);
        return questionIPage;
    }

    @Override
    public IPage<DefrontQuestionCompany> searchIsMarkByCompanyId(String userId, String companyId, Integer pageNo, Integer pageSize) {
        Page<DefrontQuestionCompany> page = new Page<DefrontQuestionCompany>(pageNo, pageSize);
        QueryWrapper<DefrontQuestionCompany> queryWrapper = new QueryWrapper<DefrontQuestionCompany>();
        queryWrapper.eq("company_id",companyId)
                .inSql("question_id", "select question_id from defront_mark_question where user_id='" + userId + "'");
        IPage<DefrontQuestionCompany> questionIPage = questionMapper.selectPage(page, queryWrapper);
        return questionIPage;
    }

    /**
     * 当前问题是否已关联
     * @return
     */
    private boolean isConcat(String companyId,String questionId){
        QueryWrapper<DefrontQuestionCompany> queryWrapper = new QueryWrapper<DefrontQuestionCompany>();
        queryWrapper.eq("company_id",companyId)
                .eq("question_id", questionId);
        Integer selectCount = questionMapper.selectCount(queryWrapper);
        if(selectCount>0){
            return true;
        }
        return false;
    }

    /**
     * 添加关联问题
     * @param userId 用户Id
     * @param questionCompany
     * @param company
     */
    public void insertConcatQuestion(String userId,List<DefrontQuestionCompany> questionCompany, String company){
        if(questionCompany!=null && questionCompany.size()>0 && StringUtil.isBlank(questionCompany.get(0).getCompanyId())){
            company = company.trim();
            if(StringUtil.isNotBlank(company)){
                String companyId = companyService.insertCompany(company);
                for(int i = 0;i<questionCompany.size();i++){
                    questionCompany.get(i).setCompanyId(companyId);
                    if(!isConcat(companyId,questionCompany.get(i).getQuestionId())){
                        questionMapper.insert(questionCompany.get(i));
                    }
                }
                DefrontCompany defrontCompany = new DefrontCompany();
                defrontCompany.setName(company);
                defrontCompany.setId(companyId);
                // 添加面试记录
                defrontInterviewService.addInterviewRecord(userId,defrontCompany);
            }
        }
    }
}
