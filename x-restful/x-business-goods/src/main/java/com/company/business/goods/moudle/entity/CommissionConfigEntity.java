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
@TableName("tomato_promotion_commission_config")
public class CommissionConfigEntity extends AbstractEntity<String> {

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @TableField(value = "commission_money")
    private BigDecimal commission_money;

    @TableField(value = "count_times")
    private int count_times;
    @TableField(value = "tips")
    private String tips;

    @TableField(value = "status")
    private Integer status;


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

}