package com.interview.defront.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@TableName(value = "defront_company")
public class DefrontCompany {

    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    private String id;
    //公司名称
    private String name;
}
