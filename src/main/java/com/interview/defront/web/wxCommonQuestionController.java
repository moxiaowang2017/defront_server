package com.interview.defront.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.interview.defront.domain.DefrontCommonQuestion;
import com.interview.defront.service.CommonQuestionService;
import com.interview.defront.utils.PageUtil;
import com.interview.defront.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 验证
 */
@RestController
@RequestMapping("/wx/commonQuestion")
@Validated
public class wxCommonQuestionController {

    @Autowired
    private CommonQuestionService commonQuestionService;

    /**
     * 个人常见问题查询
     *
     * @return
     */
    @PostMapping("search")
    public Object search(@RequestBody Map<String,Object> params) {
        Integer pageNo = PageUtil.getPageNo((Integer)params.get("pageNo"));
        Integer pageSize = PageUtil.getPageSize((Integer)params.get("pageSize"));
        IPage<DefrontCommonQuestion> questionIPage = commonQuestionService.selectPagesByOrder(pageNo,pageSize);
        return ResponseUtil.ok(questionIPage);
    }

    /**
     * 根据Id获取常见问题
     *
     * @return
     */
    @GetMapping("getOne/{id}")
    public Object getOne(@PathVariable("id") String id) {
        DefrontCommonQuestion commonQuestion = commonQuestionService.getById(id);
        return ResponseUtil.ok(commonQuestion);
    }

}
