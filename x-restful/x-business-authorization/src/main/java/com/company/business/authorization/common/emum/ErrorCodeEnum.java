package com.company.business.authorization.common.emum;

public enum ErrorCodeEnum {
    AUTH500(500, "服务器内部错误"),
    AUTH400(404, "404 not found"),


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
