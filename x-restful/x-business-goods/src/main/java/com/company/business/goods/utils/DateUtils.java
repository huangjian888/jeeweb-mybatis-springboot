package com.company.business.goods.utils;

import com.company.business.goods.common.constant.TomatoConstant;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtils {
    /**
     * 获取当前时间用于生成平台订单
     *
     * @return
     */

    /**
     * 前后相差一天==必须等于1
     *
     * @return
     */


    /**
     * 两天相差的天数--需要将yyyy-MM-dd HH:mm:ss转为yyyy-MM-dd,
     *
     * @param targetDate 原时间
     * @param nowDate    现在的时间
     * @return
     */
    public static int isNotOneDay(Date targetDate, Date nowDate) {
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
            e.printStackTrace();
        }
        Log.i("day is:" + day);
        return day;
    }

    public static boolean isPushTag(int day) {


        if (day == TomatoConstant.Message.NUMBER_2 || day == TomatoConstant.Message.NUMBER_4 || day == TomatoConstant.Message.NUMBER_6 || day == TomatoConstant.Message.NUMBER_7) {
            return true;
        }
        return false;
    }

    /**
     * 得到10为时间戳
     *
     * @param date
     * @return
     */
    public static String getSecondTimestampTwo(Date date) {
        if (null == date) {
            return "";
        }
        String timestamp = String.valueOf(date.getTime() / 1000);
        return timestamp;
    }

    public static long getTenTimesstamp(Date date) {

        return date.getTime() / 1000;
    }

    /****
     *根据传入的length长度生成随机数
     * @param length
     * @return
     */
    public static String getuRLEncoder(String value) {

        try {
            return URLEncoder.encode(value, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static boolean isChinese(String str) {
        String regEx = "[\u4e00-\u9fa5]";
        Pattern pat = Pattern.compile(regEx);
        Matcher matcher = pat.matcher(str);
        boolean flg = false;
        if (matcher.find()) {
            flg = true;
        }

        return flg;
    }


}
