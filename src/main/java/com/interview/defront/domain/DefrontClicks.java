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
@TableName(value = "defront_clicks")
public class DefrontClicks {

    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    private String id;
    // 用户Id
    @TableField(value = "user_id")
    private String userId;
    //发布Id
    @TableField(value = "concat_id")
    private String concatId;
}
