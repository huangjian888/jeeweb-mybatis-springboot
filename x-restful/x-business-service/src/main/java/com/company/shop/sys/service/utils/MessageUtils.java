package com.company.shop.sys.service.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.company.manerger.sys.common.utils.DateUtils;

import java.util.Date;
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

    //
    static String tomato_sign_name = "番茄运动兑换";

    static String tomato_sign_remark = "不要忘记步数兑换，每日24小时清零，快去兑换！！";

    static String tomato_invite_name = "获得邀请奖励";

    static String tomato_invite_remark = "你已成功邀请1名新用户，点击查看奖励.";

    /**
     * 签到消息、用户当日未购买消息模板只需要名称、备注（策划需求）
     *
     * @param
     * @return
     */
    public static JSONObject getSignMessageTemplate() {

        Map<String, String> innerMap1 = new HashMap<>();
        Map<String, String> innerMap2 = new HashMap<>();
        Map<String, String> innerMap3 = new HashMap<>();
        Map<String, String> innerMap4 = new HashMap<>();

        innerMap1.put("value", tomato_invite_name);
        innerMap2.put("value", DateUtils.getDate());
        innerMap3.put("value", "");
        innerMap4.put("value", tomato_sign_remark);

        Map map = new HashMap();

        map.put("keyword1", innerMap1);
        map.put("keyword2", innerMap2);
        map.put("keyword3", innerMap3);
        map.put("keyword4", innerMap4);
        return JSONObject.parseObject(JSON.toJSONString(map));

    }


    /**
     * 邀请好友成功
     *
     * @param
     * @return
     */
    public static JSONObject getInviteMessageTemplate() {

        Map<String, String> innerMap1 = new HashMap<>();
        Map<String, String> innerMap2 = new HashMap<>();
        Map<String, String> innerMap3 = new HashMap<>();

        innerMap1.put("value", tomato_sign_name);
        innerMap2.put("value", tomato_invite_remark);
        innerMap3.put("value", DateUtils.getDate());

        Map map = new HashMap();

        map.put("keyword1", innerMap1);
        map.put("keyword2", innerMap2);
        map.put("keyword3", innerMap3);
        return JSONObject.parseObject(JSON.toJSONString(map));

    }

    /**
     * 用户下单成功消息
     *
     * @param dateMap
     * @return
     */
    public static JSONObject getOrderSucMessageTemplate(Map<String, Object> dateMap) {

        String product_name = (String) dateMap.get("product_name");


        Map<String, String> innerMap1 = new HashMap<>();
        Map<String, String> innerMap2 = new HashMap<>();


        innerMap1.put("value", product_name);
        innerMap2.put("value", DateUtils.getDateTime());

        Map map = new HashMap();

        map.put("keyword1", innerMap1);
        map.put("keyword2", innerMap2);


        return JSONObject.parseObject(JSON.toJSONString(map));

    }

    /**
     * 商家发货通知
     *
     * @param dateMap
     * @return
     */
    public static JSONObject getOrderSendMessageTemplate(Map<String, Object> dateMap) {

        String product_name = (String) dateMap.get("product_name");
        Date send_date = (Date) dateMap.get("send_time");


        Map<String, String> innerMap1 = new HashMap<>();
        Map<String, String> innerMap2 = new HashMap<>();


        innerMap1.put("value", product_name);
        innerMap2.put("value", DateUtils.formatDateTime(send_date));

        Map map = new HashMap();

        map.put("keyword1", innerMap1);
        map.put("keyword2", innerMap2);

        return JSONObject.parseObject(JSON.toJSONString(map));

    }
}
