package com.interview.defront.domain.Enum;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

@Getter
public enum  CategoryEum {

    JS(1, "js"),  CSS(2, "css"),  HTML(3, "html"),  ES6(4, "es6"),  VUE(5, "vue"),  NODEJS(6, "nodejs");

    CategoryEum(int code, String descp) {
        this.code = code;
        this.descp = descp;
    }

    @EnumValue//标记数据库存的值是code
    private final int code;
    private final String descp;
}
