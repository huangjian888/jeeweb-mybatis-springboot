package com.company.business.goods.moudle.entity;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@TableName("tomato_promotion_order")
public class OrderEntity implements Serializable {
    @TableId(value = "order_sn")
    private String order_sn;
    //
    @TableField(value = "user_name")
    private String user_name;
    @TableField(value = "goods_id")
    private Long goods_id;
    @TableField(value = "goods_name")
    private String goods_name;
    @TableField(value = "goods_thumbnail_url")
    private String goods_thumbnail_url;
    @TableField(value = "goods_quantity")
    private Long goods_quantity;
    @TableField(value = "goods_price")
    private BigDecimal goods_price;
    @TableField(value = "order_amount")
    private BigDecimal order_amount;
    @TableField(value = "p_id")
    private String p_id;
    @TableField(value = "promotion_rate")
    private BigDecimal promotion_rate;
    @TableField(value = "promotion_amount")
    private BigDecimal promotion_amount;
    @TableField(value = "order_status")
    private Integer order_status;
    @TableField(value = "order_status_desc")
    private String order_status_desc;
    @TableField(value = "order_create_date")
    private Long order_create_date;
    @TableField(value = "order_payment_time")
    private Long order_payment_time;
    @TableField(value = "order_group_success_time")
    private Long order_group_success_time;
    @TableField(value = "order_verify_time")
    private Long order_verify_time;
    @TableField(value = "order_modify_at")
    private Long order_modify_at;

    @TableField(value = "first_order")
    private Integer first_order;



}
