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
@TableName("tomato_award_config")
public class AwardConfigEntity extends AbstractEntity<String> {
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 当前设置的步数
     */
    @TableField(value = "award_limit")
    private int award;
    /**
     * 当前是否可用
     */
    @TableField(value = "status")
    private Integer status;
    @TableField(value = "sort_order")
    private Integer sort_order;
    /**
     * 当前是否可用
     */
    @TableField(value = "gold")
    private BigDecimal gold;
    @TableField(value = "create_by")
    private String create_by;
    @TableField(value = "update_by")
    private String update_by;
    @TableField(value = "remarks")
    private String remarks;

    @TableField(value = "create_date")
    private Date create_date;
    @TableField(value = "update_date")
    private Date update_date;
}
