package com.interview.defront.web;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.interview.defront.annotation.LoginUser;
import com.interview.defront.domain.DefrontQuestion;
import com.interview.defront.service.QuestionDoService;
import com.interview.defront.service.QuestionService;
import com.interview.defront.utils.PageUtil;
import com.interview.defront.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 验证
 */
@RestController
@RequestMapping("/wx/question")
@Validated
public class wxQuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionDoService questionDoService;

    /**
     * 问题查询
     *
     * @return
     */
    @PostMapping("search/{type}")
    public Object searchQuestion(@PathVariable("type") Integer type, @RequestBody Map<String,Object> params) {
        if(type == null){
            return ResponseUtil.badArgument();
        }
        String question = "";
        if(params.get("question")!=null){
            question = String.valueOf(params.get("question"));
        }

        Integer pageNo = PageUtil.getPageNo((Integer)params.get("pageNo"));
        Integer pageSize = PageUtil.getPageSize((Integer)params.get("pageSize"));

        Page<DefrontQuestion> page = new Page<DefrontQuestion>(pageNo, pageSize);
        return questionService.queryByParam(page,type,question);
    }

    /**
     * 问题查询(未标注)
     *
     * @return
     */
    @PostMapping("searchNoMark/{type}")
    public Object searchNoMark(@LoginUser String userId, @PathVariable("type") Integer type, @RequestBody Map<String,Object> params) {
        if(userId == null){
            return ResponseUtil.unlogin();
        }
        if(type == null){
            return ResponseUtil.badArgument();
        }
        String question = "";
        if(params.get("question")!=null){
            question = String.valueOf(params.get("question"));
        }

        Integer pageNo = PageUtil.getPageNo((Integer)params.get("pageNo"));
        Integer pageSize = PageUtil.getPageSize((Integer)params.get("pageSize"));

        Page<DefrontQuestion> page = new Page<DefrontQuestion>(pageNo, pageSize);
        return questionService.queryByParamNoMark(page,type,question,userId);
    }


    /**
     *  问题点击
     *
     * @return
     */
    @GetMapping("questionClick/{questionId}")
    public Object questionClick(@PathVariable("questionId") String questionId) {
        try {
            DefrontQuestion question = questionService.getById(questionId);
            question.setClicks(question.getClicks() + 1);
            questionService.saveOrUpdate(question);
            return ResponseUtil.ok();
        }catch (Exception e){
            return ResponseUtil.fail(500,e.getMessage());
        }

    }

    /**
     * 添加问题
     * @param question
     * @param request
     * @return
     */
    @PostMapping("insert")
    public Object insertQuestion(@RequestBody DefrontQuestion question, HttpServletRequest request) {
        if(question.getClicks() == null){
            question.setClicks(0);
        }
        try {
            questionService.saveOrUpdate(question);
            return ResponseUtil.ok();
        }catch (Exception e){
            return ResponseUtil.fail(500,e.getMessage());
        }

    }

    /**
     * 获取个人练习题统计
     * @param userId 用户ID
     * @return
     */
    @PostMapping("getDoQuestionChart")
    public Object getDoQuestionChart(@LoginUser String userId) {
        if(userId == null){
            ResponseUtil.unlogin();
        }
        try {
            List<Map<String,Integer>> questionChart = questionDoService.getDoQuestionChart(userId);
            return ResponseUtil.ok(questionChart);
        }catch (Exception e){
            return ResponseUtil.fail(500,e.getMessage());
        }

    }


}
