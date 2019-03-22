package com.company.manerger.sys.common.oss.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @description: 阿里云配置
 */
@ConfigurationProperties(prefix = "oss")
public class LocalConfig {
    //外部访问域名
    String  domain="";
    //上传路径
    String uploadFilePath="";

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getUploadFilePath() {
        return uploadFilePath;
    }

    public void setUploadFilePath(String uploadFilePath) {
        this.uploadFilePath = uploadFilePath;
    }
}
