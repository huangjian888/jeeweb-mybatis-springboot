package com.company.shop.sys.service.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.company.manerger.sys.common.base.mvc.entity.AbstractEntity;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tomato_user_day_buy")
public class BuyLimitEntity extends AbstractEntity<String> {

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * openId
     */
    @TableField(value = "user_name")
    private String userName;

    /**
     * 用户今日购买数量
     */
    @TableField(value = "amount")
    private Integer amount;

    /**
     * 用户当日购买时间
     */
    @TableField(value = "get_date")
    private Date getDate;

}
