package com.company.business.goods.moudle.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.company.manerger.sys.common.base.mvc.entity.AbstractEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 自买佣金比例配置
 */
@Data
@TableName("tomato_promotion_packet_sale_config")
public class PacketSaleEntity extends AbstractEntity<String> {

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;


    @TableField(value = "rate")
    private Integer rate;

    @TableField(value = "order_num")
    private Integer order_num;


    @TableField(value = "upper_limit_amounts")
    private BigDecimal upper_limit_amounts = new BigDecimal("0.00");

    @TableField(value = "lower_limit_amounts")
    private BigDecimal lower_limit_amounts;
    @TableField(value = "status")
    private Integer status;

    @TableField(value = "create_by")
    private String create_by;
    @TableField(value = "update_by")
    private String update_by;
    @TableField(value = "create_date")
    private Date create_date;

    @TableField(value = "update_date")
    private Date update_date;

}
