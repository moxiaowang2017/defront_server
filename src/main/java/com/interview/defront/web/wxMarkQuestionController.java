package com.interview.defront.web;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.interview.defront.annotation.LoginUser;
import com.interview.defront.domain.DefrontMarkQuestion;
import com.interview.defront.domain.DefrontPersonalQuestion;
import com.interview.defront.domain.DefrontQuestion;
import com.interview.defront.service.MarkQuestionService;
import com.interview.defront.service.PersonalQuestionService;
import com.interview.defront.service.QuestionService;
import com.interview.defront.utils.PageUtil;
import com.interview.defront.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 标注问题
 */
@RestController
@RequestMapping("/wx/markQuestion")
@Validated
public class wxMarkQuestionController {

    @Autowired
    private MarkQuestionService markQuestionService;

    @Autowired
    private QuestionService questionService;

    /**
     * 个人标注问题查询
     *
     * @return
     */
    @PostMapping("search")
    public Object searchPersonalQuestion(@LoginUser String userId,@RequestBody Map<String,Object> params) {
        if(userId == null){
            return ResponseUtil.unlogin();
        }
        String question = "";
        if(params.get("question")!=null){
            question = String.valueOf(params.get("question"));
        }

        Integer pageNo = PageUtil.getPageNo((Integer)params.get("pageNo"));
        Integer pageSize = PageUtil.getPageSize((Integer)params.get("pageSize"));
        Page<DefrontMarkQuestion> page = new Page<DefrontMarkQuestion>(pageNo, pageSize);
        return markQuestionService.queryByParam(page,userId,question);
    }


    /**
     * 添加个人标注问题
     * @param question
     * @param request
     * @return
     */
    @PostMapping("insert")
    public Object insertQuestion(@RequestBody DefrontMarkQuestion question, HttpServletRequest request) {
        try {
            markQuestionService.saveOrUpdate(question);
            return ResponseUtil.ok();
        }catch (Exception e){
            return ResponseUtil.fail(500,e.getMessage());
        }

    }

    /**
     * 删除个人标注问题
     * @param userId 用户ID
     * @param questionId 问题ID
     * @return
     */
    @GetMapping("delete/{questionId}")
    public Object delete(@LoginUser String userId,@PathVariable("questionId") String questionId) {
        try {
            markQuestionService.deleteByQuestionId(userId,questionId);
            return ResponseUtil.ok();
        }catch (Exception e){
            return ResponseUtil.fail(500,e.getMessage());
        }

    }

    /**
     * 根据问题Id 添加个人标注问题
     * @param questionId
     * @return
     */
    @GetMapping("insertByQuestionId/{questionId}")
    public Object insertByQuestionId(@LoginUser String userId,@PathVariable("questionId") String questionId) {
        try {
            DefrontQuestion defrontQuestion = questionService.getById(questionId);
            DefrontMarkQuestion markQuestion = new DefrontMarkQuestion();
            markQuestion.setQuestionId(questionId);
            markQuestion.setKeywords(defrontQuestion.getKeywords());
            markQuestion.setAnswer(defrontQuestion.getAnswer());
            markQuestion.setUserId(userId);
            markQuestion.setQuestion(defrontQuestion.getQuestion());
            markQuestionService.saveOrUpdate(markQuestion);
            return ResponseUtil.ok();
        }catch (Exception e){
            return ResponseUtil.fail(500,e.getMessage());
        }

    }

    /**
     * 获取当前标注的问题数
     * @param userId
     * @return
     */
    @GetMapping("getMarkQuestionCount")
    public Object getMarkQuestionCount(@LoginUser String userId) {
        try {
            int questionCount = markQuestionService.getMarkQuestionCount(userId);
            return ResponseUtil.ok(questionCount);
        }catch (Exception e){
            return ResponseUtil.fail(500,e.getMessage());
        }

    }

}
