package com.company.shop.sys.service.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    /**
     * 获取当前时间用于生成平台订单
     *
     * @return
     */
    public static String getNowDataInt() {

        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    }

    public static String getNowDataStr() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }


    /**
     * 前后相差一天==必须等于1
     *
     * @return
     */


    /**
     * 两天相差的天数--需要将yyyy-MM-dd HH:mm:ss转为yyyy-MM-dd
     *
     * @param targetDate 原时间
     * @param nowDate    现在的时间
     * @return
     */
    public static int daysBetween(Date targetDate, Date nowDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int day = 0;
        try {
            targetDate = sdf.parse(sdf.format(targetDate));
            nowDate = sdf.parse(sdf.format(nowDate));


            Calendar calTar = Calendar.getInstance();
            Calendar calNow = Calendar.getInstance();

            calTar.setTime(targetDate);
            long timeTar = calTar.getTimeInMillis();

            calNow.setTime(nowDate);
            long timeNow = calNow.getTimeInMillis();

            long between_days = (timeNow - timeTar) / (1000 * 3600 * 24);
            day = Integer.parseInt(String.valueOf(between_days));
        } catch (Exception e) {

        }

        return day;
    }
}
