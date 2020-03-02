package com.interview.defront.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@TableName(value = "defront_company_discuss")
public class DefrontCompanyDiscuss {

    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    private String id;

    //关联公司Id
    @TableField("company_id")
    private String companyId;

    //评论
    private String discuss;

    // 用户Id
    @TableField("user_id")
    private String userId;

    // 用户昵称
    @TableField("nick_name")
    private String nickName;

    // 用户头像
    private String avatar;

    //评论时间
    private Date discussTime;
}
