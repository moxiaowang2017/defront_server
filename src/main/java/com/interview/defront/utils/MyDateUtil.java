package com.interview.defront.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Calendar;
import java.util.Date;

/**
 * 时间相关工具类
 */
public class MyDateUtil {

    private static final Log logger = LogFactory.getLog(MyDateUtil.class);

    /**
     * 获取当前时间格式 YYYY-mm-dd
     * @return
     */
    public static String getCurDateStr() {
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        String month = (now.get(Calendar.MONTH) + 1) + "";
        String day = now.get(Calendar.DATE) + "";
        if(month.length()<2){
            month = "0" + month;
        }
        if(day.length()<2){
            day = "0" + day;
        }

        return year + "-" + month + "-" + day;
    }

    /**
     * 获取前一天格式 YYYY-mm-dd
     * @return
     */
    public static String getLastDateStr() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(calendar.DATE, -1);
        int year = calendar.get(Calendar.YEAR);
        String month = (calendar.get(Calendar.MONTH) + 1) + "";
        String day = calendar.get(Calendar.DATE) + "";
        if(month.length()<2){
            month = "0" + month;
        }
        if(day.length()<2){
            day = "0" + day;
        }
        return year + "-" + month + "-" + day;
    }

    /**
     * 获取当前时间格式 mm-dd h-m
     * @return
     */
    public static String getCurTimeStr() {
        Calendar now = Calendar.getInstance();
        String month = (now.get(Calendar.MONTH) + 1) + "";
        String day = now.get(Calendar.DATE) + "";
        if(month.length()<2){
            month = "0" + month;
        }
        if(day.length()<2){
            day = "0" + day;
        }
        String hour = now.get(Calendar.HOUR_OF_DAY) + "";//控制时
        String min = now.get(Calendar.MINUTE) + "";//控制分
        if(hour.length()<2){
            hour = "0" + hour;
        }
        if(min.length()<2){
            min = "0" + min;
        }
        return month + "-" + day + "  " + hour + ":" + min;
    }
}
