package com.company.manerger.sys.common.sms.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @description: SMS配置
 */
@ConfigurationProperties(prefix = "sms")
public class SmsConfigProperties {

    //使用的上传存储空间,aliyun:阿里云
    String smsType="aliyun";
    //签名
    String signName="";
    //是否开启
    private Boolean open=Boolean.FALSE;

    private AliyunConfigProperties aliyun;

    private HuyiConfigProperties huyi;

    private TencentConfigProperties tencent;

    public String getSmsType() {
        return smsType;
    }

    public void setSmsType(String smsType) {
        this.smsType = smsType;
    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public AliyunConfigProperties getAliyun() {
        return aliyun;
    }

    public void setAliyun(AliyunConfigProperties aliyun) {
        this.aliyun = aliyun;
    }

    public HuyiConfigProperties getHuyi() {
        return huyi;
    }

    public void setHuyi(HuyiConfigProperties huyi) {
        this.huyi = huyi;
    }

    public TencentConfigProperties getTencent() {
        return tencent;
    }

    public void setTencent(TencentConfigProperties tencent) {
        this.tencent = tencent;
    }
}
