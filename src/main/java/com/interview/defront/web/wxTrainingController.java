package com.interview.defront.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.interview.defront.annotation.LoginUser;
import com.interview.defront.domain.*;
import com.interview.defront.service.*;
import com.interview.defront.utils.MyDateUtil;
import com.interview.defront.utils.PageUtil;
import com.interview.defront.utils.ResponseUtil;
import jodd.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 公司
 */
@RestController
@RequestMapping("/wx/training")
@Validated
public class wxTrainingController {

    @Autowired
    private QuestionDoService questionDoService;

    @Autowired
    private TrainingQuestionService trainingQuestionService;

    @Autowired
    private TrainingOptionService trainingOptionService;

    /**
     * 做题数统计
     *
     * @param userId 用户Id，{ code: xxx, userInfo: xxx }
     */
    @PostMapping("statistics")
    public Object statistics(@LoginUser String userId) {
        if(StringUtil.isBlank(userId)){
            return ResponseUtil.unlogin();
        }
        Map<String,Object> statMap = new HashMap<String, Object>();
        statMap.put("totalNum",questionDoService.getTotalNum(userId));
        statMap.put("categoryNum",questionDoService.getCategoryNum(userId));
        statMap.put("categoryAcc",questionDoService.getCategoryAcc(userId));
        statMap.put("continueDay",questionDoService.getContinueDay(userId));
        statMap.put("trainingCategory",trainingQuestionService.getCategoryNum());
        return ResponseUtil.ok(statMap);
    }

    /**
     * 根据问题分类获取练习题
     *
     * @param params 用户Id，
     */
    @PostMapping("searchTraining")
    public Object searchTraining(@LoginUser String userId,@RequestBody Map<String,Object> params) {
        if(StringUtil.isBlank(userId)){
            return ResponseUtil.unlogin();
        }
        if(params.get("category") == null){
            return ResponseUtil.badArgument();
        }
        Integer category = Integer.parseInt(String.valueOf(params.get("category")));
        Integer pageNo = PageUtil.getPageNo((Integer)params.get("pageNo"));
        Integer pageSize = PageUtil.getPageSize((Integer)params.get("pageSize"));
        IPage<DefrontTrainingQuestion> iPage = trainingQuestionService.queryByCategory(userId,category, pageNo, pageSize);
        return ResponseUtil.ok(iPage);
    }

    /**
     * 根据问题分类获取练习题
     *
     * @param id 问题ID，
     */
    @GetMapping("searchById/{id}")
    public Object searchById(@PathVariable("id") String id) {
        try {
            DefrontTrainingQuestion trainingQuestion = trainingQuestionService.getById(id);
            return ResponseUtil.ok(trainingQuestion);
        }catch (Exception e){
            System.out.println("searchById:" + e);
            return ResponseUtil.serious();
        }

    }


    /**
     * 根据问题Id获取选项
     *
     * @param questionId 问题Id，
     */
    @GetMapping("searchOption/{questionId}")
    public Object searchOption(@PathVariable("questionId") String questionId) {
        List<DefrontTrainingQuestionOption> questionOptions = trainingOptionService.queryByQuestionId(questionId);
        return ResponseUtil.ok(questionOptions);
    }

    /**
     * 添加个人的练习库
     * @param userId 用户Id
     * @param defrontDoQuestion 个人练习库
     */
    @PostMapping("insertDoQuestion")
    public Object insertDoQuestion(@LoginUser String userId, @RequestBody DefrontDoQuestion defrontDoQuestion) {
        if(StringUtil.isBlank(userId)){
            return ResponseUtil.unlogin();
        }
        if(questionDoService.ifExist(userId,defrontDoQuestion.getQuestionId())){
            return ResponseUtil.fail(200,"已存在");
        }
        defrontDoQuestion.setUserId(userId);
        defrontDoQuestion.setDoTime(LocalDateTime.now());
        defrontDoQuestion.setStrDate(MyDateUtil.getCurDateStr());
        questionDoService.saveOrUpdate(defrontDoQuestion);
        return ResponseUtil.ok();
    }

    /**
     * 查询个人练习库
     * @param userId 用户Id
     * @param type 类型  all:是全部, error: 错题
     */
    @PostMapping("queryDoQuestion/{type}")
    public Object queryDoQuestion(@LoginUser String userId, @PathVariable("type") String type,@RequestBody Map<String,Object> params) {
        Integer pageNo = PageUtil.getPageNo((Integer)params.get("pageNo"));
        Integer pageSize = PageUtil.getPageSize((Integer)params.get("pageSize"));
        IPage<DefrontDoQuestion> questionIPage = questionDoService.queryDoQuestion(userId, type, pageNo, pageSize);
        return ResponseUtil.ok(questionIPage);
    }


}
