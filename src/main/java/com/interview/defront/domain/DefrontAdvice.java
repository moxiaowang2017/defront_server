package com.interview.defront.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@TableName(value = "defront_advice")
public class DefrontAdvice {

    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    private String id;
    // 用户Id
    @TableField(value = "user_id")
    private String userId;
    // 建议
    private String advice;
    // 建议时间
    @TableField(value = "advice_time")
    private LocalDateTime adviceTime;
}
