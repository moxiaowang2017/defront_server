package com.interview.defront.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.interview.defront.domain.Enum.CategoryEum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@TableName(value = "defront_training_question")
public class DefrontTrainingQuestion {

    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    private String id;

    // 问题
    private String question;

    // 问题类型
    private String type;

    // 问题分类
    private Integer category;

    // 问题提示
    private String tip;

    // 答案解析
    private String analysis;

    // 排序
    @TableField("order_index")
    private String orderIndex;

}
