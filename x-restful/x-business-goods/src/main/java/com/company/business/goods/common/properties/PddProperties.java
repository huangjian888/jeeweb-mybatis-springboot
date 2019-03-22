package com.company.business.goods.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "pdd.config")
@Data
public class PddProperties {

    private String clientSecret;
    private String clientId;

    private String url = "https://gw-api.pinduoduo.com/api/router";


    //fixme 拼多多订单接口start

    private String orderMethod = "pdd.ddk.order.list.increment.get";
    private String productMethod = "pdd.ddk.goods.search";

    private int pageSize = 50;

    private int page;
    private String order_list_get_response = "order_list_get_response";
    private String goods_search_response = "goods_search_response";
    private String order_list = "order_list";
    private String total_count = "total_count";
    //jsonArray中的值

    private String order_sn = "order_sn";
    private String goods_id = "goods_id";
    private String goods_name = "goods_name";
    private String goods_thumbnail_url = "goods_thumbnail_url";
    private String goods_quantity = "goods_quantity";
    private String goods_price = "goods_price";
    private String order_amount = "order_amount";
    private String order_create_time = "order_create_time";
    private String order_verify_time = "order_verify_time";
    private String promotion_rate = "promotion_rate";
    private String promotion_amount = "promotion_amount";
    private String order_status = "order_status";
    private String order_status_desc = "order_status_desc";
    private String order_group_success_time = "order_group_success_time";
    private String order_modify_at = "order_modify_at";
    private String p_id = "p_id";

    //设置的透传字段信息
    private String custom_parameters = "custom_parameters";
    private long scala = 100;

//对应键值

//fixme 拼多多订单接口end
}
