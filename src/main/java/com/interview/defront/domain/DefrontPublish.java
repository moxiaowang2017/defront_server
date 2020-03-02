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
@TableName(value = "defront_publish")
public class DefrontPublish {

    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    private String id;
    @TableField(value = "user_id")
    private String userId;
    //头像链接
    private String avatar;
    //昵称
    @TableField(value = "nick_name")
    private String nickName;
    //发布内容
    private String content;
    //发布内容Html格式
    private String html;
    //发布时间
    @TableField(value = "publish_time")
    private LocalDateTime publishTime;
    //发布时间（字符串格式）
    @TableField(value = "publish_time_str")
    private String publishTimeStr;
    //点赞数
    private int clicks;
    //评论数
    @TableField(value = "review_num")
    private int reviewNum;
    //是否匿名
    private boolean anonymous;
    // 打卡类型 1.打卡 2.面试经验
    private String category;
}
