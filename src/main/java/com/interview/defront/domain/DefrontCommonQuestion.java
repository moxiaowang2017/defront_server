package com.interview.defront.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 常见问题
 */
@Data
@NoArgsConstructor
@TableName(value = "defront_common_question")
public class DefrontCommonQuestion {

    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    private String id;

    // 问题
    private String question;

    // 答案模版
    @TableField("question_model")
    private String questionModel;

    // 推荐量
    private int recommendation;

}
