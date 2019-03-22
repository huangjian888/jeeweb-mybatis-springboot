package com.company.business.goods.utils;

import com.company.business.goods.common.constant.TomatoConstant;
import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;

/***
 * 用于设置redis_key
 */
public class RedisKeyUtils {
    //token缓存key
    private static String ACCESS_TOKEN_PREFIX = "company:business:authorization";

    private static String REDIS_FORM_KEY = "company:business:authorization:formid";

    private static String ACCESS_TOKEN_WX_KEY = "company:business:authorization:wx";

    private static String QRCODE_SHOW_KEY = "company:business:authorization:qr";

    private static String QRCODE_PRODUCT_KEY = "company:business:authorization:qrcode:product";

    private static String LOG_SRARCH_LKEY = "company:business:authorization:log:search";
    private static String LOG_Statistics_LKEY = "company:business:authorization:log:Statistics";

    private static String ORDER_TIMES = "company:business:authorization:order:times";

    private static String RATE_CONFIG = "company:business:authorization:rate:config";
    //提现配置项

    //红包配置项
    private static String PACKET_RULE = "company:business:authorization:packet:rule";
    private static String PACKET_LIMIT = "company:business:authorization:packet:limit";
    private static String PACKET_RANDOM = "company:business:authorization:packet:random";
    private static String PACKET_ORDER = "company:business:authorization:packet:order";
    private static String PACKET_PAGE = "company:business:authorization:packet:page";//前端将设置的新用户注册红包开关

    /**
     * token前缀key
     *
     * @param token
     * @return
     */
    public static String getAccessTokenKey(String token) {
        Preconditions.checkArgument(StringUtils.isNotEmpty(token), "非法请求token参数不存在");
        return ACCESS_TOKEN_PREFIX + ":" + token;
    }

    public static String getOrderKey() {
        return ORDER_TIMES;
    }

    public static String getAccessWxTokenKey(String token) {
        Preconditions.checkArgument(StringUtils.isNotEmpty(token), "非法请求token参数不存在");
        return ACCESS_TOKEN_WX_KEY + ":" + token;
    }

    public static String getSearchLogKey(long time) {
        return LOG_SRARCH_LKEY + ":" + time;

    }

    public static String getStatisticsLogKey(long time) {
        return LOG_Statistics_LKEY + ":" + time;

    }

    public static String getQrcodeProductKey(String productId) {
        return QRCODE_PRODUCT_KEY + ":" + productId;

    }

    /**
     * 获取佣金比例缓存
     *
     * @return
     */
    public static String getRateConfigKey() {

        return RATE_CONFIG;
    }

    /**
     * 保存formId
     *
     * @param openId
     * @return
     */
    public static String getFormIdKey(String openId) {

        return REDIS_FORM_KEY + ":" + openId;
    }

    /**
     * 统一key
     *
     * @param id
     * @return
     */
    public static String getQrCode() {

        return QRCODE_SHOW_KEY;
    }

    /**
     * 红包规则缓存
     *
     * @param id
     * @return
     */
    public static String getPacketRuleKey() {

        return PACKET_RULE;
    }

    /**
     * 获取运营配置的红包限制
     *
     * @return
     */
    public static String getPacketLimitKey() {

        return PACKET_LIMIT;
    }

    /**
     * 获取运营配置的随机红包金额
     *
     * @return
     */
    public static String getPacketRandomKey() {

        return PACKET_RANDOM;
    }

    /**
     * 获取运营配置的下单比例
     *
     * @return
     */
    public static String getPacketOrderKey() {

        return PACKET_ORDER;
    }

    /**
     * 获取前端配置的icon键值,通过
     *
     * @return
     */
    public static String getPacketPageKey() {

        return PACKET_PAGE + ":" + TomatoConstant.Front.redpack_flag;
    }

}
