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
 * 用户第一次领取红包的随机金额
 */
@Data
@TableName("tomato_promotion_packet_counts_config")
public class RandomPacketEntity extends AbstractEntity<String> {

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 随机金额
     */
    @TableField(value = "random_amounts")
    private BigDecimal random_amounts;

    @TableField(value = "status")
    private Integer status;

    /**
     * 排序
     */
    @TableField(value = "order_num")
    private Integer order_num;


    @TableField(value = "create_by")
    private String create_by;

    @TableField(value = "create_date")
    private Date create_date;

    @TableField(value = "update_by")
    private String update_by;

    @TableField(value = "update_date")
    private Date update_date;


}
