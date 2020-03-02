package com.interview.defront.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@TableName(value = "defront_article_detail")
public class DefrontArticleDetail {

    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    private String id;
    // 文章
    private String article;
}
