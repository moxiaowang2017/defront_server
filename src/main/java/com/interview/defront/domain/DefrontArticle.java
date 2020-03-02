package com.interview.defront.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@TableName(value = "defront_article")
public class DefrontArticle {

    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    private String id;
    // 文章类型
    private String category;
    // 标题
    private String title;
    //简介
    private String label;
    //链接
    private String url;
    // 发布年份
    @TableField(value = "publish_year")
    private String publishYear;
    // 发布日期
    @TableField(value = "publish_date")
    private String publishDate;
    @TableField(value = "detail_id")
    private String detailId;
}
