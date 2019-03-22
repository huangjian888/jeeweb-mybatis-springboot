package com.company.manerger.sys.common.sms.config;


import com.company.manerger.sys.common.utils.PropertiesUtil;

/**
 * @description: 腾讯云配置
 */
public class TencentConfigProperties {
    public static final String DEFAULT_CONFIG_FILE = "tencent.sms.properties";

    // 短信应用SDK AppID
    private  Integer appId= 0;
    // 短信应用SDK AppKey
    private  String appKey="";

    public static SmsConfigProperties buildConfigProperties() {
        return buildConfigProperties(DEFAULT_CONFIG_FILE);
    }

    public static SmsConfigProperties buildConfigProperties(String propertiesName) {
        PropertiesUtil p = new PropertiesUtil(propertiesName);
        SmsConfigProperties smsConfigProperties = new SmsConfigProperties();
        smsConfigProperties.setOpen(p.getBoolean("sms.isopen"));
        smsConfigProperties.setSignName(p.getString("sms.sign-name"));
        TencentConfigProperties tencentConfig = new TencentConfigProperties();
        tencentConfig.setAppId(p.getInt("sms.tencent.app-id"));
        tencentConfig.setAppKey(p.getString("sms.tencent.app-key"));
        smsConfigProperties.setTencent(tencentConfig);
        return smsConfigProperties;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }
}
