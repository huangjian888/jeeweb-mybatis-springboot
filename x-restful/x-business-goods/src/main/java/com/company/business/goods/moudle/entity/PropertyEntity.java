package com.company.business.goods.moudle.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.company.manerger.sys.common.base.mvc.entity.AbstractEntity;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("tomato_promotion_user_property")
public class PropertyEntity extends AbstractEntity<String> {
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 可提现金额
     */
    @TableField(value = "commission_money_able")
    private BigDecimal commission_money_able;
    /**
     *待返现金额
     */
    @TableField(value = "commission_money_back")
    private BigDecimal commission_money_back;
    @TableField(value = "user_name")
    private String user_name;

}



