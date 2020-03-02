package com.interview.defront.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@TableName(value = "defront_personal_question")
public class DefrontPersonalQuestion {

    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    private String id;

    //用户Id
    @TableField("user_id")
    private String userId;

    // 常见问题表中的Id
    @TableField("common_id")
    private String commonId;

    // 问题
    private String question;

    // 我的答案
    @TableField("my_answer")
    private String myAnswer;

    // 是否开放
    @TableField("is_open")
    private byte isOpen;

    //关键字
    private String keywords;

    // 权重
    private int weight;


}
