package com.company.business.goods.common.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TomatoConstant {

    /**
     * 服务端与微信授权内部异常
     */
    public interface Authorization {
        int WX_USER_INFO_1 = 1;
        String ERROR_WX_AUTHTICATION_EXCEPTION_MESSAGE = "获取微信授权异常";
    }

    public interface Common {
        String POST = "POST";
        String RESPONSE = "response";
        String UTF8 = "utf-8";
        String TOMATO_USER = "番茄用户";
        String CONTENT_TYPE_TEXT_JSON = "application/json";
        String JSON = "JSON";
        int NUMBER_0 = 0;
        int NUMBER_1 = 1;
        int NUMBER_2 = 2;
        int NUMBER_3 = 3;
        int NUMBER_5 = 5;
        int NUMBER_30 = 30;
        int NUMBER_20 = 20;
        int NUMBER_100 = 100;
        int EXPIRE_TIME_REDIS = 7200;//2h
        int EXPIRE_TIME_REDIS_1800 = 1800;//2h
        int EXPIRE_FORMID_TIME_REDIS = 7 * 24 * 3600;//7天过期时间
        int LOG_TIME_REDIS = 180 * 24 * 3600;//180天过期时间
        int QR_CODE_TIME_REDIS = 12 * 3600;//1天过期时间
        int PAGE_PACKET_HOME_REDIS = 600;//10分钟
        String company_ADMIN = "company_admin";
        double DOUBLE_LIMIT = 19.75;
    }

    public interface Commission {
        int NUMBER_500 = 500;
    }

    public interface Message {
        int NUMBER_2 = 2;
        int NUMBER_4 = 4;
        int NUMBER_6 = 6;
        int NUMBER_7 = 7;
        int NUMBER_8 = 8;
    }

    public interface QrCode {
        int QR_LIMIT_500 = 500;
        String QR_PACKAGE_NAME = "qrcode";
        //https://tomato-photo.raink.com.cn/1548667823236.png
        //正式环境
        String QR_PHOTO_URL = "https://business-photo.raink.com.cn/";
        //测试环境
        //String QR_PHOTO_URL = "https://tomato-photo-test.raink.com.cn/";
        //新测试环境
        //https://zz-phototest.raink.com.cn
    }

    public interface Front {
        String extance_red = "extance_red";//用户首单购买返现开关
        String redpack_flag = "redpack_flag";//新用户注册红包开关
    }

    public interface Order {

        //未支付
        int NOT_PAY = -1;
        //0-已支付
        int HAS_PAY = 0;
        //1，已成团--拼多多支付后就是已成团
        int HAS_GROUP = 1;
        //2.确认收货
        int COMFIRM_PRODUCT = 2;
        //3.审核成功
        int CHECK_SUC = 3;
        //4.审核失败
        int CHECK_FAILED = 4;
        //已经结算
        int HAS_CLEAR = 5;
        //非拼多多商品，无佣金
        int NOT_PDD = 8;

    }
}
