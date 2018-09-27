package cn.jeeweb.sso.config;

/**
 * Created by hexin on 2018/9/17.
 */
public class SsoProperties {
    private String ssoBaseServiceUrl; //sso服务器地址

    public String getSsoBaseServiceUrl() {
        return ssoBaseServiceUrl;
    }

    public void setSsoBaseServiceUrl(String ssoBaseServiceUrl) {
        this.ssoBaseServiceUrl = ssoBaseServiceUrl;
    }
}
