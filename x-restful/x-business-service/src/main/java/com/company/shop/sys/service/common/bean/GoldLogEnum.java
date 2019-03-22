package com.company.shop.sys.service.common.bean;

/**
 * 金币变化类型
 */
public class GoldLogEnum {

    public enum GoldStatusEnum {
        INCREASES(1, "获得"),

        DECREASE(2, "消耗"),

        EVENT_STEP(3, "步数兑换金币"),
        EVENT_GOLD(4, "金币兑换商品");

        private String value;
        private int code;

        GoldStatusEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }

}
