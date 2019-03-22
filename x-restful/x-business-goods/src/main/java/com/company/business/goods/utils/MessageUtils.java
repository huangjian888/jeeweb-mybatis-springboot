package com.company.business.goods.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.company.manerger.sys.common.utils.DateUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class MessageUtils {
    //fixme 主消息keyword1
    static String[] message = {"惊爆价9.9元,错过了就没有了!", "9.9元起,不抢真的来不及了!", "太便宜了!只要9.9元起!!!", "这波降价太狠了,只要9.9元,不买就亏了!", "惊爆价9.9元,错过了就没有了", "速抢,限量,只要9.9元"};

    //fixme remark消息keyword3
    static String[] remark = {"发现更多拼多多的优惠券,马上点击查看!", "你已经N天没来看看啦,为你找到了几款400元的优惠券商品,点击查看!", "购买拼多多前,先来「番茄优惠」找优惠券,更省钱更实惠!"};

    static String inviteRemark_10 = "%s已注册成为你的粉丝,还差%d人即可获得自买返佣金的特权,加油呀!";
    static String inviteRemark_20 = "%s已注册成为你的粉丝,还差%d人即可获得新用户购买佣金提升,加油呀!";
    static String inviteRemark_other = "%s已注册成为你的粉丝,继续邀请以获得更多奖励哦!";
    static int NUMBER_10 = 10;
    static int NUMBER_20 = 20;
    static String invite_price = "你获取￥%s元的佣金收益";
    static String invite_price_remark = "你的粉丝在番茄省钱购物了商品，你获得了相应的佣金收益";

    static String self_price = "你获取￥%s元的首购返现";
    static String self_price_remark = "你在番茄省钱购物了商品,你获得了首购返现收益";

    //fixme 用户通知召回消息模板
    public static JSONObject getNotifyMessageTemplate() {


        Map<String, String> innerMap1 = new HashMap<>();
        Map<String, String> innerMap2 = new HashMap<>();
        Map<String, String> innerMap3 = new HashMap<>();

        innerMap1.put("value", getMessage(message));
        innerMap2.put("value", DateUtils.getDateTime());
        innerMap3.put("value", getMessage(remark));


        Map map = new HashMap();

        map.put("keyword1", innerMap1);
        map.put("keyword2", innerMap2);
        map.put("keyword3", innerMap3);

        return JSONObject.parseObject(JSON.toJSONString(map));
    }

    private static String getMessage(String[] target) {

        //0-6以内的随机整数

        return target[(int) (Math.random() * target.length)];
    }

    /**
     * 用户自买佣金使用
     *
     * @param dateMap
     * @return
     */
    public static JSONObject getSelfBuyMessageTemplate(Map<String, Object> dateMap) {
        double price = (Double) dateMap.get("price");


        Map<String, String> innerMap1 = new HashMap<>();
        Map<String, String> innerMap2 = new HashMap<>();


        innerMap1.put("value", String.format(self_price, String.valueOf(price)));
        innerMap2.put("value", self_price_remark);

        Map map = new HashMap();

        map.put("keyword1", innerMap1);
        map.put("keyword2", innerMap2);


        return JSONObject.parseObject(JSON.toJSONString(map));

    }

    public static JSONObject getInvitePriceMessageTemplate(Map<String, Object> dateMap) {
        BigDecimal price = (BigDecimal) dateMap.get("price");


        Map<String, String> innerMap1 = new HashMap<>();
        Map<String, String> innerMap2 = new HashMap<>();


        innerMap1.put("value", String.format(invite_price, String.valueOf(price.doubleValue())));
        innerMap2.put("value", invite_price_remark);

        Map map = new HashMap();

        map.put("keyword1", innerMap1);
        map.put("keyword2", innerMap2);


        return JSONObject.parseObject(JSON.toJSONString(map));

    }

    public static JSONObject getInviteMessageTemplate(Map<String, Object> dateMap) {

        String friendName = (String) dateMap.get("nickName");
        int num = (Integer) dateMap.get("num");

        Map<String, String> innerMap1 = new HashMap<>();
        Map<String, String> innerMap2 = new HashMap<>();


        innerMap1.put("value", friendName);
        if (num < NUMBER_10) {
            innerMap2.put("value", String.format(inviteRemark_10, friendName, NUMBER_10 - num));

        } else if (NUMBER_10 < num && num < NUMBER_20) {
            innerMap2.put("value", String.format(inviteRemark_20, friendName, NUMBER_20 - num));
        } else {//邀请了大于20个人
            innerMap2.put("value", String.format(inviteRemark_other, friendName));
        }

        Map map = new HashMap();

        map.put("keyword1", innerMap1);
        map.put("keyword2", innerMap2);


        return JSONObject.parseObject(JSON.toJSONString(map));
    }

}
