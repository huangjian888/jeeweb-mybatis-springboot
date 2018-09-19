package cn.jeeweb.sso;

/**
 * Created by hexin on 2018/9/14.
 */
public class SsoConstants {
    //parameter
    public static final String PARAMETER_REDIRECT = "redirectUrl";
    public static final String PARAMETER_TOKEN = "jeewebToken";
    public static final String PARAMETER_CLIENT_URL = "clientUrl";
    //login user
    public static final String FLAG_SESSION_LOGIN = "sessionLogin";
    public static final String FLAG_LOGIN_USER = "loginUser";

    //url
    public static final String URL_PARSE_TOKEN = "/auth/parseToken";
    public static final String URL_CLEAR_TOKEN = "/auth/clearToken";
}
