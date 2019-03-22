package com.company.manerger.sys.common.sms.config;


import com.company.manerger.sys.common.utils.PropertiesUtil;

/**
 * @description: 阿里云配置
 */
public class AliyunConfigProperties {
    public static final String DEFAULT_CONFIG_FILE = "aliyun.sms.properties";

    //阿里云api的密钥access key id
    String accessKeyId="";
    //阿里云api的密钥access key secret
    String accessKeySecret="";

    public static SmsConfigProperties buildConfigProperties() {
        return buildConfigProperties(DEFAULT_CONFIG_FILE);
    }

    public static SmsConfigProperties buildConfigProperties(String propertiesName) {
        PropertiesUtil p = new PropertiesUtil(propertiesName);
        SmsConfigProperties smsConfigProperties = new SmsConfigProperties();
        smsConfigProperties.setOpen(p.getBoolean("sms.open"));
        smsConfigProperties.setSignName(p.getString("sms.sign-name"));
        AliyunConfigProperties aliyunConfig = new AliyunConfigProperties();
        aliyunConfig.setAccessKeyId(p.getString("sms.aliyun.access-key-id"));
        aliyunConfig.setAccessKeySecret(p.getString("sms.aliyun.access-key-secret"));
        smsConfigProperties.setAliyun(aliyunConfig);
        return smsConfigProperties;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

}
