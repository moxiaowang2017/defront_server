package com.interview.defront.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@TableName(value = "defront_question_company")
public class DefrontQuestionCompany {

    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    private String id;
    //问题
    private String question;
    //问题Id
    @TableField("question_id")
    private String questionId;
    //问题Id
    @TableField("company_id")
    private String companyId;
    //问题类型
    private String type;
}
