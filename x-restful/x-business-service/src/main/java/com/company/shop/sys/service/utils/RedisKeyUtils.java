package com.company.shop.sys.service.utils;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;

/***
 * 用于设置redis_key
 */
public class RedisKeyUtils {
    private static String BASE_PREFIX = "company:business:sport:";//当前的业务服务基准前缀
    //token缓存key
    private static String ACCESS_TOKEN_PREFIX = "token:accessToken:";
    private static String WX_ACCESS_TOKEN = "token:wx:";


    private static String REDIS_SIGN_KEY = "sign:";


    private static String INVITE_KEY = "invite:";


    private static String TOMATO_BUS_STEP_CONFIG = "step:config";
    private static String TOMATO_BUS_PACKET_CONFIG = "packet:config";

    private static String TOMATO_BUS_PROCEDURE_CONFIG = "procedure:config";
    private static String TOMATO_BUS_INVITE_CONFIG = "invite:config";
    private static String TOMATO_BUS_SIGN_CONFIG = "sign:config";
    private static String FORM_ID_KEY = "form:";//formId集合

    private static String STEP_ID="step:";

    /**
     * token前缀key
     *
     * @param token
     * @return
     */
    public static String getAccessTokenKey(String token) {
        Preconditions.checkArgument(StringUtils.isNotEmpty(token), "非法请求token参数不存在");

        return new StringBuilder(BASE_PREFIX).append(ACCESS_TOKEN_PREFIX).append(token).toString();

    }

    public static String getWxAccessTokenKey(String openId) {
        Preconditions.checkArgument(StringUtils.isNotEmpty(openId), "非法请求token参数不存在");
        return new StringBuilder(BASE_PREFIX).append(WX_ACCESS_TOKEN).append(openId).toString();
    }

    /**
     * 签到
     *
     * @param openId
     * @return
     */
    public static String getSignKey(String openId) {

        return new StringBuilder(BASE_PREFIX).append(REDIS_SIGN_KEY).append(openId).toString();
    }

    /**
     * 当前openId的邀请好友奖励表
     *
     * @param inviteOpenId
     * @return
     */
    public static String getInviteKey(String inviteOpenId) {

        return new StringBuilder(BASE_PREFIX).append(INVITE_KEY).append(inviteOpenId).toString();

    }

    /**
     * 步数列表配置缓存
     *
     * @return
     */
    public static String getStepConfigKey() {
        return new StringBuilder(BASE_PREFIX).append(TOMATO_BUS_STEP_CONFIG).toString();
    }

    /**
     * 红包配置缓存
     *
     * @return
     */
    public static String getPacketConfigKey() {

        return new StringBuilder(BASE_PREFIX).append(TOMATO_BUS_PACKET_CONFIG).toString();
    }

    /**
     * 添加到小程序奖励配置
     *
     * @return
     */
    public static String getProcedureConfigKey() {

        return new StringBuilder(BASE_PREFIX).append(TOMATO_BUS_PROCEDURE_CONFIG).toString();
    }

    /**
     * 邀请好友数量配置
     *
     * @return
     */
    public static String getInviteConfigKey() {

        return new StringBuilder(BASE_PREFIX).append(TOMATO_BUS_INVITE_CONFIG).toString();
    }

    /**
     * 邀请签到配置
     *
     * @return
     */
    public static String getSignConfigKey() {
        return new StringBuilder(BASE_PREFIX).append(TOMATO_BUS_SIGN_CONFIG).toString();
    }

    /**
     * 用户的formId集合
     *
     * @param username
     * @return
     */
    public static String getFormIdKey(String username) {

        return new StringBuilder(BASE_PREFIX).append(FORM_ID_KEY).append(username).toString();
    }

    /**
     * 对应id下的步数设置
     *
     * @param id
     * @return
     */
    public static String getStepKey(String id) {

        return new StringBuilder(BASE_PREFIX).append(STEP_ID).append(id).toString();
    }
}
