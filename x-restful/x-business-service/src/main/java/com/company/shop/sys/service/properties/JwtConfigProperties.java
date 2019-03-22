package com.company.shop.sys.service.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hexin on 2018/11/27.
 */

@Configuration
@ConfigurationProperties(prefix = "company.jwt")
@Data
public class JwtConfigProperties {
    private String header = "Authorization";
    private String tokenHead = "Bearer ";
    private String secret = "shop_sys_service";
    private long expiration = 7200L; //过期时间,单位 秒--配合redis设置为2小时
    private String authpath = "auth";
    private String claim_key_username = "username";
    private String claim_key_createdate = "createdate";


}
