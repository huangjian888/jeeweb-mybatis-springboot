package com.company.manerger.sys.common.sms.client;

import com.company.manerger.sys.common.sms.config.SmsConfigProperties;
import com.company.manerger.sys.common.sms.data.SmsResult;
import java.util.Map;

/**
 * @description: 发送短信接口
 */
public interface ISmsClient {

    /**
     * 客户端初始化
     * @param smsConfigProperties
     */
    void init(SmsConfigProperties smsConfigProperties);

    /**
     *
     *
     * @param phone
     *            手机号码
     * @param template
     *            模版
     * @return
     */
    SmsResult send(String phone, String template);

    /**
     *
     *
     * @param phone
     *            手机号码
     * @param template
     *            模版
     * @param datas
     *            数据
     * @return
     */
     SmsResult send(String phone, String template, Map<String,Object> datas);
}
