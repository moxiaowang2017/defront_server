package com.interview.defront.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@TableName(value = "`defront_mark_question`")
public class DefrontMarkQuestion {

    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    private String id;

    //用户Id
    @TableField("user_id")
    private String userId;

    //问题Id question_company 中的question_id
    @TableField("question_id")
    private String questionId;

    // 问题
    private String question;

    // 我的答案
    private String answer;

    // 关键字
    private String keywords;

    // 权重
    private int weight;


}
