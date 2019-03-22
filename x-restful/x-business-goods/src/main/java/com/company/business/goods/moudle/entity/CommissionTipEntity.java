package com.company.business.goods.moudle.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.company.manerger.sys.common.base.mvc.entity.AbstractEntity;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tomato_promotion_commission_tip_config")
public class CommissionTipEntity extends AbstractEntity<String> {
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;


    /**
     * 每日提现次数
     */
    @TableField(value = "day_count_times")
    private Integer day_count_times;
    /**
     * 单日最多提现金额
     */
    @TableField(value = "commission_money_max")
    private Integer commission_money_max;

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
