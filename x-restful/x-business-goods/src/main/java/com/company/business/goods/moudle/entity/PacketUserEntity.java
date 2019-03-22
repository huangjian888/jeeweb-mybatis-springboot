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
 * 用户红包
 */
@Data
@TableName("tomato_promotion_packet_user")
public class PacketUserEntity extends AbstractEntity<String> {


    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;


    @TableField(value = "packet_amounts")
    private BigDecimal packet_amounts;
    @TableField(value = "user_name")
    private String user_name;
    @TableField(value = "packet_times")
    private Integer packet_times;
    @TableField(value = "packet_recent_date")
    private Date packet_recent_date;
    @TableField(value = "packet_first_date")
    private Date packet_first_date;


}
