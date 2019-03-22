package com.company.business.goods.moudle.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.company.manerger.sys.common.base.mvc.entity.AbstractEntity;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tomato_promotion_statistics")
public class StatisticsLogEntity extends AbstractEntity<String> {
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;


    @TableField(value = "user_name")
    private String username;

    @TableField(value = "description")
    private String description;
    @TableField(value = "type")
    private Integer type;
    @TableField(value = "visit_count")
    private Integer visitCount;
    @TableField(value = "product_id")
    private String productId;


    @TableField(value = "view_product_time")
    private String view_product_time;
    @TableField(value = "view_product_stay_time")
    private String view_product_stay_time;
    @TableField(value = "operation_time")
    private Date operation_time;
    @TableField(value = "log_update_time")
    private Date log_update_time;


}
