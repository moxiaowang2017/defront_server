package com.interview.defront.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.interview.defront.domain.Enum.CategoryEum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@TableName(value = "defront_do_question")
public class DefrontDoQuestion {

    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    private String id;

    // 问题
    private String question;

    // 问题Id
    @TableField("question_id")
    private String questionId;

    // 用户Id
    @TableField("user_id")
    private String userId;

    // 是否正确
    @TableField("is_true")
    private Boolean isTrue;

    // 练习时间
    @TableField("do_time")
    private LocalDateTime doTime;

    // 日期字符串(YYYY-mm-dd)
    @TableField("str_date")
    private String strDate;

    // 问题分类
    private Integer category;
}
