package com.interview.defront.web;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.interview.defront.annotation.LoginUser;
import com.interview.defront.domain.*;
import com.interview.defront.dto.CompanyDiscussDto;
import com.interview.defront.dto.CompanyQuestionDto;
import com.interview.defront.dto.UserInfo;
import com.interview.defront.dto.WxLoginInfo;
import com.interview.defront.service.*;
import com.interview.defront.utils.IpUtil;
import com.interview.defront.utils.PageUtil;
import com.interview.defront.utils.ResponseUtil;
import jodd.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 公司
 */
@RestController
@RequestMapping("/wx/company")
@Validated
public class wxCompanyController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private CompanyDiscussService companyDiscussService;

    @Autowired
    private DefrontUserService defrontUserService;

    @Autowired
    private QuestionCompanyService questionCompanyService;

    @Autowired
    private DefrontInterviewService defrontInterviewService;


    /**
     * 根据公司名称模糊查询
     *
     * @param params 请求内容，{ code: xxx, userInfo: xxx }
     * @return 登录结果
     */
    @PostMapping("searchLike")
    public Object searchLike(@RequestBody Map<String,Object> params) {
        String company = String.valueOf(params.get("company"));
        Integer pageNo = PageUtil.getPageNo((Integer)params.get("pageNo"));
        Integer pageSize = PageUtil.getPageSize((Integer)params.get("pageSize"));
        Page<DefrontCompany> page = new Page<DefrontCompany>(pageNo, pageSize);
        return companyService.queryByParamLike(page,company);
    }

    /**
     * 根据公司名称模糊查询
     *
     * @param params 请求内容，{ code: xxx, userInfo: xxx }
     * @return 登录结果
     */
    @PostMapping("search")
    public Object search(@RequestBody Map<String,Object> params) {
        String company = String.valueOf(params.get("company"));
        return companyService.queryByParamEq(company);
    }


    /**
     * 根据公司名称模糊查询
     *
     * @param params 请求内容，{ code: xxx, userInfo: xxx }
     * @return 登录结果
     */
    @PostMapping("searchDiscuss/{companyId}")
    public Object searchDiscuss(@PathVariable("companyId") String companyId, @RequestBody Map<String,Object> params) {
        Integer pageNo = PageUtil.getPageNo((Integer)params.get("pageNo"));
        Integer pageSize = PageUtil.getPageSize((Integer)params.get("pageSize"));
        Page<DefrontCompanyDiscuss> page = new Page<DefrontCompanyDiscuss>(pageNo, pageSize);
        return companyDiscussService.queryByParam(page,companyId);
    }

    /**
     * 公司评价
     * @param discussDto
     * @return 保存结果
     */
    @PostMapping("insertDiscuss")
    public Object insertDiscuss(@LoginUser String userId,@RequestBody CompanyDiscussDto discussDto) {
        if(userId == null){
            return ResponseUtil.unlogin();
        }
        try {
            Map<String, Object> objectMap = companyDiscussService.insertDiscuss(userId, discussDto);
            return ResponseUtil.ok(objectMap);
        }catch (Exception e){
            System.out.println("错误："+e);
            return ResponseUtil.fail();
        }

    }

    /**
     * 获取关联的题目
     * @param companyId
     * @return 保存结果
     */
    @PostMapping("searchConcatQuestion/{companyId}")
    public Object searchConcatQuestion(@LoginUser String userId,@PathVariable("companyId") String companyId,@RequestBody Map<String,Object> params) {
        if(companyId == null){
            return ResponseUtil.badArgument();
        }
        Integer isMark = 0;
        if(params.get("isMark") != null){
            isMark = (Integer)params.get("isMark");
        }

        if(isMark == 0){
            Integer pageNo = PageUtil.getPageNo((Integer)params.get("pageNo"));
            Integer pageSize = PageUtil.getPageSize((Integer)params.get("pageSize"));
            IPage<DefrontQuestionCompany> page = questionCompanyService.searchByCompanyId(userId,companyId,pageNo,pageSize);
            return ResponseUtil.ok(page);
        }
        if(isMark == 1){
            Integer pageNo = PageUtil.getPageNo((Integer)params.get("pageNo"));
            Integer pageSize = PageUtil.getPageSize((Integer)params.get("pageSize"));
            IPage<DefrontQuestionCompany> page = questionCompanyService.searchIsMarkByCompanyId(userId,companyId,pageNo,pageSize);
            return ResponseUtil.ok(page);
        }
        return ResponseUtil.fail();
    }

    /**
     * 批量添加关联的题目
     * @return 保存结果
     */
    @PostMapping("insertConcatQuestion")
    public Object insertConcatQuestion(@LoginUser String userId,@RequestBody CompanyQuestionDto companyQuestionDto) {
        if(userId == null){
            return ResponseUtil.unlogin();
        }
        try {
            questionCompanyService.insertConcatQuestion(userId,companyQuestionDto.getDefrontQuestionCompanys(),companyQuestionDto.getCompany());
            return ResponseUtil.ok();
        }catch (Exception e){
            return ResponseUtil.fail(500,e.getMessage());
        }

    }

    /**
     * 获取面试记录
     * @return 保存结果
     */
    @PostMapping("getInterviewRecords")
    public Object getInterviewRecords(@LoginUser String userId,@RequestBody Map<String,Object> params) {
        if(userId == null){
            return ResponseUtil.unlogin();
        }
        try {
            Integer pageNo = PageUtil.getPageNo((Integer)params.get("pageNo"));
            Integer pageSize = PageUtil.getPageSize((Integer)params.get("pageSize"));
            IPage<DefrontInterview> records = defrontInterviewService.getInterviewRecords(userId, pageNo, pageSize);
            return ResponseUtil.ok(records);
        }catch (Exception e){
            return ResponseUtil.fail(500,e.getMessage());
        }

    }

    /**
     * 获取未评价的面试记录数量
     * @return 保存结果
     */
    @GetMapping("getUnreviewCount")
    public Object getUnreviewCount(@LoginUser String userId) {
        if(userId == null){
            return ResponseUtil.unlogin();
        }
        try {
            int unreviewCount = defrontInterviewService.getUnreviewCount(userId);
            return ResponseUtil.ok(unreviewCount);
        }catch (Exception e){
            return ResponseUtil.fail(500,e.getMessage());
        }

    }
}
