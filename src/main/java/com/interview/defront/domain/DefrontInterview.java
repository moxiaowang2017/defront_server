package com.interview.defront.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;


@Data
@NoArgsConstructor
@TableName(value = "defront_interview_records")
public class DefrontInterview {

    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    private String id;
    // 用户Id
    @TableField(value = "user_id")
    private String userId;
    // 公司ID
    @TableField(value = "company_id")
    private String companyId;
    // 公司名称
    private String company;
    // 是否已评价
    @TableField(value = "is_review")
    private boolean isReview;
    // 面试时间
    @TableField(value = "interview_time")
    private Date interviewTime;
    // 面试时间(字符串类型)
    @TableField(value = "interview_date_str")
    private String interviewDateStr;
}
