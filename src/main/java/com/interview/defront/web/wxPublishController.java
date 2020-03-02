package com.interview.defront.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.interview.defront.annotation.LoginUser;
import com.interview.defront.domain.DefrontAdvice;
import com.interview.defront.domain.DefrontArticle;
import com.interview.defront.domain.DefrontArticleDetail;
import com.interview.defront.domain.DefrontPublish;
import com.interview.defront.service.*;
import com.interview.defront.utils.PageUtil;
import com.interview.defront.utils.ResponseUtil;
import jodd.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


/**
 * 发布内容
 */
@RestController
@RequestMapping("/wx/publish")
@Validated
public class wxPublishController {

    @Autowired
    private DefrontPublishService defrontPublishService;

    @Autowired
    private DefrontClockService defrontClockService;

    @Autowired
    private DefrontArticleService defrontArticleService;

    @Autowired
    private DefrontAdviceService defrontAdviceService;

    @Autowired
    private DefrontArticleDetailService defrontArticleDetailService;

    @Autowired
    private DefrontInterviewService defrontInterviewService;

    @Autowired
    private QuestionDoService questionDoService;

    @Autowired
    private DefrontClicksService defrontClicksService;

    /**
     * 发布内容
     * @param userId 用户Id
     * @param defrontPublish 发布内容
     */
    @PostMapping("insert")
    public Object insert(@LoginUser String userId, @RequestBody DefrontPublish defrontPublish) {
        if(StringUtil.isBlank(userId)){
            return ResponseUtil.unlogin();
        }
        try {
            if(defrontPublish.getCategory().equals("打卡")){
                defrontPublishService.clockPublish(userId,defrontPublish);
            }else{
                defrontPublishService.publish(userId,defrontPublish);
            }
            return ResponseUtil.ok();
        }catch (Exception e){
            System.out.println("错误："+e);
            return ResponseUtil.serious();
        }

    }

    /**
     * 根据用户ID获取发布的内容
     * @param userId
     * @param params
     * @return
     */
    @PostMapping("searchByUserId")
    public Object searchByUserId(@LoginUser String userId,@RequestBody Map<String,Object> params) {
        if(StringUtil.isBlank(userId)){
            return ResponseUtil.unlogin();
        }
        try {
            Integer pageNo = PageUtil.getPageNo((Integer)params.get("pageNo"));
            Integer pageSize = PageUtil.getPageSize((Integer)params.get("pageSize"));
            IPage<DefrontPublish> publishIPage = defrontPublishService.searchByUserId(userId, pageNo, pageSize);
            return ResponseUtil.ok(publishIPage);
        }catch (Exception e){
            return ResponseUtil.serious();
        }
    }

    /**
     * 获取发布内容
     * @param params
     * @return
     */
    @PostMapping("search")
    public Object search(@RequestBody Map<String,Object> params) {
        try {
            Integer pageNo = PageUtil.getPageNo((Integer)params.get("pageNo"));
            Integer pageSize = PageUtil.getPageSize((Integer)params.get("pageSize"));
            Page<DefrontPublish> page = new Page<DefrontPublish>(pageNo, pageSize);
            QueryWrapper<DefrontPublish> queryWrapper = new QueryWrapper<>();
            queryWrapper.orderByDesc("publish_time");
            Page<DefrontPublish> publishPage = defrontPublishService.page(page, queryWrapper);
            return ResponseUtil.ok(publishPage);
        }catch (Exception e){
            return ResponseUtil.serious();
        }
    }

    /**
     * 我的页面数据获取
     * @param userId 用户Id
     * @return
     */
    @GetMapping("getMyCount")
    public Object isClock(@LoginUser String userId) {
        if(StringUtil.isBlank(userId)){
            return ResponseUtil.unlogin();
        }
        try {
            Map<String,Object> dataMap = new HashMap<String,Object>();
            // 是否已经打卡
            Boolean clock = defrontClockService.isClock(userId);
            // 获取面试记录未评论数量
            int unreviewCount = defrontInterviewService.getUnreviewCount(userId);
            int totalNum = questionDoService.getTotalNum(userId);
            int errorNum = questionDoService.getErrorNum(userId);
            dataMap.put("clock",clock);
            dataMap.put("unreviewCount",unreviewCount);
            dataMap.put("totalNum",totalNum);
            dataMap.put("errorNum",errorNum);
            return ResponseUtil.ok(dataMap);
        }catch (Exception e){
            return ResponseUtil.serious();
        }
    }

    /**
     * 查看文章
     * @return
     */
    @PostMapping("searchArticle")
    public Object searchArticle(@RequestBody Map<String,Object> params) {
        try {
            Integer pageNo = PageUtil.getPageNo((Integer)params.get("pageNo"));
            Integer pageSize = PageUtil.getPageSize((Integer)params.get("pageSize"));
            Page<DefrontArticle> page = new Page<DefrontArticle>(pageNo, pageSize);
            Page<DefrontArticle> defrontArticlePage = defrontArticleService.page(page);
            return ResponseUtil.ok(defrontArticlePage);
        }catch (Exception e){
            return ResponseUtil.serious();
        }
    }

    /**
     * 查看文章
     * @return
     */
    @PostMapping("insertAdvice")
    public Object insertAdvice(@LoginUser String userId,@RequestBody DefrontAdvice defrontAdvice) {
        if(StringUtil.isBlank(userId)){
            return ResponseUtil.unlogin();
        }
        try {
            defrontAdvice.setAdviceTime(LocalDateTime.now());
            defrontAdvice.setUserId(userId);
            defrontAdviceService.saveOrUpdate(defrontAdvice);
            return ResponseUtil.ok();
        }catch (Exception e){
            return ResponseUtil.serious();
        }
    }


    /**
     * 添加文章
     * @return
     */
    @PostMapping("insertArticleDetail")
    public Object insertArticleDetail(@RequestBody DefrontArticleDetail defrontArticleDetail) {
        try {
            defrontArticleDetailService.saveOrUpdate(defrontArticleDetail);
            return ResponseUtil.ok();
        }catch (Exception e){
            return ResponseUtil.serious();
        }
    }

    /**
     * 查询文章
     * @return
     */
    @GetMapping("searchArticleDetail/{detailId}")
    public Object searchArticleDetail(@PathVariable("detailId") String detailId) {
        try {
            DefrontArticleDetail detail = defrontArticleDetailService.getById(detailId);
            return ResponseUtil.ok(detail);
        }catch (Exception e){
            return ResponseUtil.serious();
        }
    }


    /**
     * 发布内容点赞
     * @return
     */
    @GetMapping("insertClicks/{concatId}")
    public Object insertClicks(@LoginUser String userId,@PathVariable("concatId") String concatId) {
        try {
            defrontClicksService.insertClicks(userId,concatId);
            defrontPublishService.updateClicks(concatId);
            return ResponseUtil.ok();
        }catch (Exception e){
            return ResponseUtil.serious();
        }
    }
}
