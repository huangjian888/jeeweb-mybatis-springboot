package com.company.business.goods.moudle.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.company.manerger.sys.common.base.mvc.entity.AbstractEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("tomato_promotion_user_property_log")
public class PropertyLogEntity extends AbstractEntity<String> {
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 当前订单产生的佣金
     */
    @TableField(value = "commission_money")
    private BigDecimal commission_money;

    @TableField(value = "commission_date")
    private Date commission_date;
    @TableField(value = "user_name")
    private String user_name;
    //1-增加，0-减少
    @TableField(value = "type")
    private Integer type;

    /**
     * 拼多多订单号
     */
    @TableField(value = "order_no")
    private String order_no;


    /**
     * 拼多多订单的当前订单状态
     */
    @TableField(value = "status")
    private Integer status;


}



