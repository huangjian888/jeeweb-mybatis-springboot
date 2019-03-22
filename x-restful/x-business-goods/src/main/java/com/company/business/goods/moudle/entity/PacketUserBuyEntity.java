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
@TableName("tomato_promotion_packet_user_buy_table")
public class PacketUserBuyEntity extends AbstractEntity<String> {


    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;


    @TableField(value = "buy_amounts")
    private BigDecimal buy_amounts;

    @TableField(value = "user_name")
    private String user_name;

    @TableField(value = "buy_times")
    private Integer buy_times;

    @TableField(value = "first_date")
    private Date first_date;
    @TableField(value = "recent_date")
    private Date recent_date;

}
