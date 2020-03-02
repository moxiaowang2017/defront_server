package com.interview.defront.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@TableName(value = "defront_clock")
public class DefrontClock {

    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    private String id;
    @TableField(value = "user_id")
    private String userId;
    //打卡时间 字符串类型
    @TableField(value = "clock_time_str")
    private String clockTimeStr;
    //连续打卡天数
    @TableField(value = "continue_day")
    private int continueDay;
}
