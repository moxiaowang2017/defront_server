package com.interview.defront.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.interview.defront.domain.Enum.CategoryEum;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@TableName(value = "defront_question_option")
public class DefrontTrainingQuestionOption {

    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    private String id;

    // 问题Id
    @TableField("question_id")
    private String questionId;

    // 问题选项
    @TableField("option_val")
    private String optionVal;

    // 是否是问题的答案
    @TableField("is_answer")
    private Boolean isAnswer;

    // 权重
    private int weight;

}
