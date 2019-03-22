package com.company.shop.sys.service.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 获取wx相关配置信息
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "wx.properties")
public class WxConfigProperties {

    private String appid;
    private String appsecret;
    private String granttype;
    private String merchantid;

    private String signid;//签到模板id
    private String inviteid;//邀请好友成功消息模板
    private String ordersuc;//下单成功
    private String ordersend;//订单已发货
    /****
     * 微信统一下单接口
     */
    private String wx_pay_url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    private String wx_authorization_url = "https://api.weixin.qq.com/sns/jscode2session";
    //fixme 下单接口将要传入回调地址
    private String wx_notify_url = "http;//localhost:8082/pay/notify";
    private String tradType = "JSAPI";//小程序固定传入此值
    //fixme 红包发放代金券地址
    private String voucher_url = "https://api.mch.weixin.qq.com/mmpaymkttransfers/send_coupon";//需要双向证书

    //fixme 获取微信token
    private String wx_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential";
    //fixme 发送模板消息地址
    private String wx_tamplate_url = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=";


}
