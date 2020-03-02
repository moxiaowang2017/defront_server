package com.interview.defront.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 分页相关工具类
 */
public class PageUtil {

    // 默认查询第一页
    private static final Integer default_pageNo = 1;

    // 分页默认条数
    private static final Integer default_pageSize = 20;

    public static Integer getPageNo(Integer pageNo) {
        if(pageNo == null || pageNo == 0){
            return default_pageNo;
        }
        return pageNo;
    }


    public static Integer getPageSize(Integer pageSize) {
        if(pageSize == null || pageSize == 0){
            return default_pageSize;
        }
        return pageSize;
    }
}
