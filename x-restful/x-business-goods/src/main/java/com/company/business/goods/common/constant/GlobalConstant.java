package com.company.business.goods.common.constant;

public class GlobalConstant {
    /**
     * 缓存命名空间
     */
    public static final String CACHE_NAMESPACE = "shop_sys_service:";

    /**
     * 获取远程ip相关
     */
    public static final String UNKNOWN = "unknown";

    public static final String X_FORWARDED_FOR = "X-Forwarded-For";
    public static final String X_REAL_IP = "X-Real-IP";
    public static final String PROXY_CLIENT_IP = "Proxy-Client-IP";
    public static final String WL_PROXY_CLIENT_IP = "WL-Proxy-Client-IP";
    public static final String HTTP_CLIENT_IP = "HTTP_CLIENT_IP";
    public static final String HTTP_X_FORWARDED_FOR = "HTTP_X_FORWARDED_FOR";


    public static final String LOCALHOST_IP = "127.0.0.1";
    public static final String LOCALHOST_IP_16 = "0:0:0:0:0:0:0:1";
    public static final int MAX_IP_LENGTH = 15;
    public static String POST = "POST";
    public static String UTF8 = "utf-8";
    public static String RESPONSE = "response";

    //符号标示
    public static final class Symbol {
        private Symbol() {
        }

        /**
         * The constant COMMA.
         */
        public static final String COMMA = ",";
        public static final String SPOT = ".";
        /**
         * The constant UNDER_LINE.
         */
        public final static String UNDER_LINE = "_";
        /**
         * The constant PER_CENT.
         */
        public final static String PER_CENT = "%";
        /**
         * The constant AT.
         */
        public final static String AT = "@";
        /**
         * The constant PIPE.
         */
        public final static String PIPE = "||";
        public final static String SHORT_LINE = "-";
        public final static String SPACE = " ";
        public static final String SLASH = "/";
        public static final String MH = ":";

    }
}
