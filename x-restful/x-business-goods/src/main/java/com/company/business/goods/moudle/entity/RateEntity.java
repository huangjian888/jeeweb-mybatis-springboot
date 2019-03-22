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
@TableName("tomato_promotion_rate_config")
public class RateEntity extends AbstractEntity<String> {
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;


    //百分之5
    @TableField(value = "normal_buy_rate")
    private BigDecimal normal_buy_rate;
    //百分之10
    @TableField(value = "first_buy_rate")
    private BigDecimal first_buy_rate;
    //百分之15
    @TableField(value = "invite_first_buy_rate")
    private BigDecimal invite_first_buy_rate;
    //百分之5
    @TableField(value = "invite_user_return_rate")
    private BigDecimal invite_user_return_rate;

    //邀请20人首次购买奖励佣金百分之15
    @TableField(value = "invite_user_promote")
    private Integer invite_user_promote;
    //邀请10人自买返现百分之5
    @TableField(value = "invite_user_return")
    private Integer invite_user_return;

    @TableField(value = "create_by")
    private String create_by;

    @TableField(value = "create_id")
    private String create_id;

    @TableField(value = "create_date")
    private Date create_date;

    @TableField(value = "update_by")
    private String update_by;

    @TableField(value = "update_id")
    private String update_id;


    @TableField(value = "update_date")
    private Date update_date;
    @TableField(value = "remarks")
    private String remarks;
    @TableField(value = "status")
    private Integer status;

}
