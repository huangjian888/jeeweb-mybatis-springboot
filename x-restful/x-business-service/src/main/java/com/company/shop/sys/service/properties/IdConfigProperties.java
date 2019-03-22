package com.company.shop.sys.service.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 生成id配置
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "id.properties")
public class IdConfigProperties {
    private long dataCenterId;
    private long machineId;
}
