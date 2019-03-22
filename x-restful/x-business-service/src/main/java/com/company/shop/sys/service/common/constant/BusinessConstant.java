package com.company.shop.sys.service.common.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BusinessConstant {

    /**
     * 服务端与微信授权内部异常
     */
    public interface Authorization {
        /**
         * 微信获取步数
         */
        int WX_STEP_0 = 0;
        /**
         * 获取微信用户信息
         */
        int WX_USER_INFO_1 = 1;
        String ERROR_WX_AUTHTICATION_EXCEPTION_MESSAGE = "获取微信授权异常";
    }

    public interface Common {
        String RESPONSE = "response";
        int EXPIRE_TIME_REDIS = 7200;//2h
        String company_ADMIN = "company_admin";
    }

    public interface Redis {
        int EXPIRE_TIME_REDIS_1800 = 1800;//缓存半小时
        int EXPIRE_TIME_REDIS_3600 = 3600;//缓存一小时
        int EXPIRE_TIME_REDIS_7_day = 7 * 24 * 3600;//缓存7天

    }

    public interface Message {
        int NUMBER_0 = 0;
        int NUMBER_1 = 1;
        int NUMBER_2 = 2;
        int NUMBER_3 = 3;
        int NUMBER_4 = 4;
    }

    /**
     * 商品信息
     */
    public interface Product {
        /**
         * 根据类别获取商品
         */
        int TYPE_CATEGORY_ONE = 1;
        /**
         * 根据name查询搜索商品
         */
        int TYPE_NAME_TWO = 2;

    }

    /***
     * 购物车
     */
    public interface Cart {

        /**
         * 即购物车选中状态
         */
        int CHECKED = 1;

        /**
         * 购物车中未选中状态
         */
        int UN_CHECKED = 0;

    }

    /**
     * 物流地址
     */
    public interface Shipping {
        /**
         * 默认收货地址
         */
        int DEFAULT = 1;

        int NOT_DEFAULT = 0;
        //限制物流地址6个
        int LIMIT_ADDRESS = 6;
    }

    /**
     * 签到
     */
    public interface Sign {
        String TYPE_0 = "0";//签到

        int IS_FIRST = 1;
        int DAY_7 = 7;
    }


    /**
     * 首页
     */
    public interface Home {
        int ZERO = 0;
        int ONE = 1;
        int NUMBER_14 = 14;//已发货超过14则默认收货
        int CATEGORY_1 = 1;
        int CATEGORY_2 = 2;
        int CATEGORY_3 = 3;
        int CATEGORY_4 = 4;

    }

    /**
     * 订单
     */
    public interface Order {
        int ORDER_0_PAYED = 0;//已付款--待发货
        int ORDER_1_SENDED = 1;//已发货--已发货
        int ORDER_2_SUCCESSED = 2;//交易成功--已签收
        int ORDER_3_CANCEL = 3;//已取消--取消订单
        int ORDER_4_NOT_PAY = 4;//未付款


        int ORDER_60_CLOSE = 60;//交易关闭


        int PAY_ONLINE = 1;//在线支付


        String ID_NAME = "company";
        String KEY_NAME = "dylan";
        /**
         * 生成id
         */
        int STEP = 7;
        int LENGTH = 6;
    }
}
