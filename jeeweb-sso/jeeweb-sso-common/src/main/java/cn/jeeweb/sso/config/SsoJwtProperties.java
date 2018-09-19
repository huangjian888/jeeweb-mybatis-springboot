package cn.jeeweb.sso.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hexin on 2018/9/14.
 */
@Configuration
@ConfigurationProperties(prefix = "jwt")
public class SsoJwtProperties {
    private String header = "Authorization";
    private String secret = "jeeWebSecret";
    private Long expiration = 1800000L;
    private String authpath = "auth";

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Long getExpiration() {
        return expiration;
    }

    public void setExpiration(Long expiration) {
        this.expiration = expiration;
    }

    public String getAuthpath() {
        return authpath;
    }

    public void setAuthpath(String authpath) {
        this.authpath = authpath;
    }
}
