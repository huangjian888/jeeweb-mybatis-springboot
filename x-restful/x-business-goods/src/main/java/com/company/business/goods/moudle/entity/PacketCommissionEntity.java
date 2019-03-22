package com.company.business.goods.moudle.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.company.manerger.sys.common.base.mvc.entity.AbstractEntity;
import lombok.Data;

import java.util.Date;

/**
 * 自买佣金比例配置
 */
@Data
@TableName("tomato_promotion_packet_commission_config")
public class PacketCommissionEntity extends AbstractEntity<String> {

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;


    @TableField(value = "rate")
    private Integer rate;

    @TableField(value = "order_num")
    private Integer order_num;


    @TableField(value = "upper_fans")
    private Integer upper_fans = new Integer(0);

    @TableField(value = "lower_fans")
    private Integer lower_fans;

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
