package com.company.shop.sys.service.utils;

import java.util.Date;
import java.util.Random;

/***
 * 随机密码生成工具
 */
public class PasswordUtils {
    public final static String[] word = {
            "a", "b", "c", "d", "e", "f",
            "g", "h", "j", "k", "m", "n",
            "p", "q", "r", "s", "t", "u",
            "v", "w", "x", "y", "z",
            "A", "B", "C", "D", "E", "F",
            "G", "H", "J", "K", "M", "N",
            "P", "Q", "R", "S", "T", "U",
            "V", "W", "X", "Y", "Z",
    };

    public static String[] num = {
            "2", "3", "4", "5", "6", "7", "8", "9"
    };

    /**
     * lqn
     * 随机生成密码
     *
     * @return
     */
    public static String randomPassword() {
        StringBuffer stringBuffer = new StringBuffer();
        //以当前时间生成random
        Random random = new Random(new Date().getTime());
        boolean flag = false;
        //设置默认密码的长度为1+12位
        int length = random.nextInt(1) + 12;
        for (int i = 0; i < length; i++) {
            if (flag) {
                stringBuffer.append(num[random.nextInt(num.length)]);
            } else {
                stringBuffer.append(word[random.nextInt(word.length)]);
            }
            flag = !flag;
        }
        return stringBuffer.toString();
    }

    /**
     * 生成随机盐
     *
     * @return
     */
    public static int randomSalt() {
        return (int) ((Math.random() * 9 + 1) * 100000);
    }

}
