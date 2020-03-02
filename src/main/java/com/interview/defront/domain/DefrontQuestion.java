package com.interview.defront.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@TableName(value = "defront_question")
public class DefrontQuestion {

    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    private String id;

    // 问题类型
    private Byte type;

    // 问题
    private String question;

    // 答案
    private String answer;

    // 关键字
    private String keywords;

    // 点击量
    private Integer clicks;


}
