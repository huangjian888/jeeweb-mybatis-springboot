package com.company.shop.sys.service.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.company.manerger.sys.common.base.mvc.entity.AbstractEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("tomato_order_info")
public class OrderEntity extends AbstractEntity<String> {

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 系统生成的订单号
     */
    @TableField(value = "order_id")
    private String orderId;
    /**
     * 用户openid
     */
    @TableField(value = "user_name")
    private String userName;
    /**
     * 物流id
     */
    @TableField(value = "shipping_id")
    private String shippingId;
    /**
     * 商品id
     */
    @TableField(value = "product_id_two")
    private String productId;

    /**
     * 单价
     */
    @TableField(value = "price")
    private BigDecimal price;
    /**
     * 单价
     */
    @TableField(value = "gold")
    private BigDecimal gold;
    /**
     * 总价
     */
    @TableField(value = "total_gold")
    private BigDecimal totalGold;
    /**
     * 总价
     */
    @TableField(value = "total_price")
    private BigDecimal totalPrice;
    /**
     * 商品购买数量
     */
    @TableField(value = "quantity")
    private Integer quantity;

    /**
     * 支付类型--在线支付
     */
    @TableField(value = "payment_type")
    private Integer paymentType;
    /**
     * 邮费
     */
    @TableField(value = "postage")
    private BigDecimal postage;
    /**
     * 当前订单状态
     */
    @TableField(value = "status_two")
    private Integer status;
    /**
     * 支付时间
     */
    @TableField(value = "payment_time")
    private Date paymentTime;
    /**
     * 发货时间
     */
    @TableField(value = "send_time")
    private Date sendTime;
    /**
     * 交易完成时间
     */
    @TableField(value = "end_time")
    private Date endTime;
    /**
     * 订单创建时间
     */
    @TableField(value = "create_date_two")
    private Date createDate;
    /**
     * 订单更新时间
     */
    @TableField(value = "update_date")
    private Date updateDte;
    /**
     * 用户备注
     */
    @TableField(value = "remarks")
    private String remarks;
    /**
     * 对应的微信订单
     */
    @TableField(value = "wx_order_no")
    private String wx_order_no;
    /**
     * 是否快递
     */
    @TableField(value = "shipments")
    private Integer shipments;

    /**
     * 快递单号
     */
    @TableField(value = "express_no")
    private String expressNo;
    /**
     * 快递公司
     */
    @TableField(value = "express_company")
    private String expressCompany;


}
