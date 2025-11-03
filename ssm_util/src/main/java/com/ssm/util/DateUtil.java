package com.ssm.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author j
 * @Date 2019/9/7 19:04
 * @Version 1.0
 */
public class DateUtil {
    public static SimpleDateFormat ymdHms = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssm");
    public static SimpleDateFormat ymdHm = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    public static SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 格式化日期
     * @param date
     * @param format
     * @return
     */
    public static String date2Str(Date date, String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static String date2Str(Date date, DateFormat format){
        return format.format(date);
    }
}
