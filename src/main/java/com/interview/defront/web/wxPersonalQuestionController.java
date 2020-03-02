package com.interview.defront.web;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.interview.defront.annotation.LoginUser;
import com.interview.defront.domain.DefrontPersonalQuestion;
import com.interview.defront.domain.DefrontQuestion;
import com.interview.defront.service.PersonalQuestionService;
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
@RequestMapping("/wx/personalQuestion")
@Validated
public class wxPersonalQuestionController {

    @Autowired
    private PersonalQuestionService personalQuestionService;

    /**
     * 个人常见问题查询
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
        Page<DefrontPersonalQuestion> page = new Page<DefrontPersonalQuestion>(pageNo, pageSize);
        return personalQuestionService.queryByParam(page,userId,question);
    }


    /**
     * 添加个人常见问题
     * @param question
     * @return
     */
    @PostMapping("insert")
    public Object insertQuestion(@LoginUser String userId,@RequestBody DefrontPersonalQuestion question) {
        try {
            question.setUserId(userId);
            personalQuestionService.saveOrUpdate(question);
            return ResponseUtil.ok();
        }catch (Exception e){
            return ResponseUtil.fail(500,e.getMessage());
        }

    }

    /**
     * 根据问题Id和用户Id获取个人常见问题
     * @param userId 用户ID
     * @param questionId 问题ID
     * @return
     */
    @GetMapping("searchByQuestionId/{questionId}")
    public Object searchByQuestionId(@LoginUser String userId,@PathVariable("questionId") String questionId) {
        try {
            List<DefrontPersonalQuestion> questionList = personalQuestionService.searchByQuestionId(userId, questionId);
            return ResponseUtil.ok(questionList);
        }catch (Exception e){
            return ResponseUtil.fail(500,e.getMessage());
        }

    }

}
