package com.company.shop.sys.service.common.vo;


import lombok.Data;

/***
 * 用于返回前端支付参数
 */
@Data
public class WxPayVo extends BaseVo {

    private String app_id;
    private String mch_id;
    private String nonce_str;
    private String sign;
    private String prepay_id;
    private String signType;
    private String timeStamp;
    private int errorCode;
    private String sys_order;
    private int payType;//0:金币，1：金钱 2:金币+金钱

}
