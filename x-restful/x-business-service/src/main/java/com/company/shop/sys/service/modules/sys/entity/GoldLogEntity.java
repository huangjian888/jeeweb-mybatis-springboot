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
@TableName("tomato_gold_log")
public class GoldLogEntity extends AbstractEntity<String> {

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @TableField("user_name")
    private String userName;

    /**
     * 兑换时间
     */
    @TableField(value = "gold_date")
    private Date goldDate;
    /**
     * 本次使用的步数
     */
    @TableField(value = "step")
    private Integer step;
    /**
     * 兑换获得的金币
     */
    @TableField(value = "gold")
    private BigDecimal gold;
    /**
     * 当前消耗金币的事件名
     */
    @TableField(value = "event")
    private String event;
    /**
     * 金币的变化类型，1-增加2-减少
     */
    @TableField(value = "gold_type")
    private String goldType;
}
