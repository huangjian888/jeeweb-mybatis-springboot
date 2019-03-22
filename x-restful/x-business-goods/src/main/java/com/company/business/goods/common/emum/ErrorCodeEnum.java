package com.company.business.goods.common.emum;

public enum ErrorCodeEnum {
    AUTH500(500, "服务器内部错误"),
    AUTH400(404, "404 not found"),
    AUTH401(401, "401 not authorization"),
    AUTH403(403, "403 not has permission for rest"),
    AUTH600(600, "config params error"),

    COUPON2000(2000, "请求参数异常"),
    COUPON2001(2001, "couponId已存在"),
    COUPON2002(2002, "还没有优惠券哦"),
    COUPON2003(2003, "收藏夹是空的哦"),
    COUPON2004(2004, "函数名为空"),
    COUPON2005(2005, "推荐配置为空或是概率不显示推荐"),
    COUPON2006(2006, "退出失败"),
    COUPON2007(2007, "formId为空"),
    COUPON2008(2008, "formId保存失败"),
    COUPON2009(2009, "取消收藏失败"),
    COUPON2010(2010, "上传用户信息失败，请检查网络"),
    COUPON2011(2011, "上传日志失败"),
    COUPON2012(2012, "类别配置为空"),
    COUPON2013(2013, "更新商品配置失败"),
    COUPON2014(2014, "未配置二维码或当日所有二维码已超显示次数"),
    COUPON2015(2015, "上传二维码失败，请检查请求参数或已有同url图片"),
    COUPON2016(2016, "markId已存在"),
    COUPON2017(2017, "删除二维码失败"),
    COUPON2018(2018, "生成二维码失败，请检查网络"),
    COUPON2019(2019, "markId为空或内部更新失败"),
    COUPON2020(2020, "请按提示金额提现"),
    COUPON2021(2021, "更新请求失败"),
    COUPON2022(2022, "一天只能提现一次哦"),
    COUPON2023(2023, "提现金额需要大于0且小于500"),
    COUPON2024(2024, "粉丝列表为空"),
    COUPON2025(2025, "错误操作，财产不足"),
    COUPON2026(2026, "您没有那么多金额用于提现哦"),
    COUPON2027(2027, "提现金额为null或数据格式错误"),
    COUPON2028(2028, "请先配置佣金比例"),
    COUPON2029(2029, "未配置提示信息"),
    COUPON2030(2030, "上传随机红包失败"),
    COUPON2031(2031, "用户红包为空"),
    COUPON2032(2032, "用户信息为空"),
    COUPON2033(2033, "新用户注册获得红包不可用"),
    COUPON2034(2034, "金额有误"),
    COUPON2035(2035, "红包领取失败"),
    COUPON2036(2036, "无邀请好友"),
    COUPON2037(2037, "没有足够的金额"),
    COUPON2038(2038, "提现金额不足"),
    COUPON2039(2039, "提现错误"),
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

    AUTH1007(1007, "当前还没有记录");


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
