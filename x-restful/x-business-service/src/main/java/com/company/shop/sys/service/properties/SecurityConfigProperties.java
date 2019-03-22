package com.company.shop.sys.service.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hexin on 2018/11/26.
 */
@Configuration
@ConfigurationProperties(prefix = "company.security")
@Data
public class SecurityConfigProperties {
    //凭证匹配器-算法
    private String credentialsHashAlgorithmName = "md5";
    //生成Hash值的迭代次数
    private Integer credentialsHashIterations = 2;


}
