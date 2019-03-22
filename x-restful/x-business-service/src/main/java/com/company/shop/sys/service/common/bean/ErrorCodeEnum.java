package com.company.shop.sys.service.common.bean;

public enum ErrorCodeEnum {
    AUTH500(500, "服务器内部错误"),
    AUTH400(404, "404 not found"),
    AUTH401(401, "401 not authorization"),
    AUTH403(403, "403 not has permission for rest"),
    /**
     * 一般内部逻辑错误（处理数据库以及其他逻辑）
     */
    AUTH1001(1001, "内部业务处理异常"),

    /****
     * 获取header中token异常
     */
    AUTH1002(1002, "非法请求,请先登录"),

    AUTH1003(1003, "网络请求异常"),
    AUTH1004(1004, "请先登录"),
    AUTH1005(1005, "页面已过期，请重新登录"),
    AUTH1006(1006, "获取用户信息失败"),
    AUTH1007(1007, "当前还没有记录"),
    AUTH1008(1008, "配置失败"),
    AUTH1009(1009, "需求的请求参数为空"),

    TASK1050(1050, "签到奖励查找错误"),
    TASK1051(1051, "一天只能签到一次哦"),
    TASK1052(1052, "设置自动提醒签到失败,请先签到"),
    TASK1053(1053, "获取今日未完成任务失败"),
    TASK1054(1054, "当前任务还未配置或任务完成失败"),
    TASK1055(1055, "未配置"),
    TASK1056(1056, "不满足金币兑换条件"),
    TASK1057(1057, "未知id"),
    TASK1058(1058, "未有邀请奖励"),
    TASK1059(1059, "领取奖励失败，请检查id"),
    TASK1060(1060, "获取用户签到信息失败"),
    TASK1061(1061, "服务不可用,今日已兑换"),

    ORDER2020(2020, "订单删除失败,已取消和已完成订单才可删除"),
    ORDER2021(2021, "订单取消失败"),
    ORDER2022(2022, "获取订单详情失败"),
    ORDER2023(2023, "还没有订单哦"),
    ORDER2024(2024, "未查询到订单信息"),
    ORDER2025(2025, "确认收货异常"),
    ORDER2026(2026, "订单还未支付"),
    ORDER2027(2027, "请填写物流信息"),
    ORDER2028(2028, "商品购买数量不能为0"),
    ORDER2029(2029, "库存数量不足"),
    ORDER2030(2030, "商品已下架"),
    ORDER2031(2031, "生成订单失败"),
    ORDER2032(2032, "金币不足"),
    ORDER2033(2033, "一天只能购买一次哦，今日已经购买"),

    PAY2001(2001, "微信下单内部异常"),
    PAY2002(2002, "微信下单失败"),
    PAY2003(2003, "请选择收货地址信息"),

    SHIPPING2004(2004, "添加收货地址失败"),
    SHIPPING2005(2005, "修改收货地址失败"),
    SHIPPING2006(2006, "删除收货地址失败"),
    SHIPPING2007(2007, "设置默认收货地址失败"),
    SHIPPING2008(2008, "还没有添加物流地址哦"),
    SHIPPING2009(2009, "物流地址太多了哦"),
    SHIPPING2010(2010, "未有默认收货地址"),


    PRODUCT3001(3001, "请求参数有误或为null"),
    PRODUCT3002(3002, "产品已下架或者删除"),
    PRODUCT3003(3003, "商品名不能为空"),
    PRODUCT3004(3004, "抱歉，未能搜索到商品"),
    PRODUCT3005(3005, "商品分类未配置或出错"),
    PRODUCT3006(3006, "未能成功获取到商品"),
    PRODUCT3007(3007, "当前暂无销售记录"),
    PRODUCT3008(3008, "商品信息为空"),


    CART4001(4001, "购物车是空的呢"),
    CART4002(4002, "商品添加到购物车失败"),
    CART4003(4003, "商品删除失败"),
    CART4004(4004, "商品状态更新失败"),
    CART4005(4005, "数量不能为0"),

    COMMON9001(9001, "formId保存失败"),
    COMMON9002(9002, "数据为空"),
    COMMON90099(9002, "微信返回为null");





    private int code;
    private String msg;

    public String msg() {
        return msg;
    }

    public int code() {
        return code;
    }

    ErrorCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 用于基类继承使用
     *
     * @param code
     * @return
     */
    public static ErrorCodeEnum getEnum(int code) {
        for (ErrorCodeEnum ele : ErrorCodeEnum.values()) {
            if (ele.code() == code) {
                return ele;
            }
        }
        return null;
    }
}
