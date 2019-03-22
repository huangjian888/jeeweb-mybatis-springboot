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
@TableName("tomato_user_step")
public class StepEntity extends AbstractEntity<String> {
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @TableField("user_name")
    private String userName;

    @TableField("status")
    private Integer status;

    @TableField("symbol")
    private Integer symbol;

    @TableField("gold")
    private BigDecimal gold;

    @TableField("step")
    private Integer step;

    @TableField("exchange_date")
    private Date exchangeDate;

    @TableField("order_no")
    private Integer orderNo;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof StepEntity) {
            StepEntity stepEntity = (StepEntity) obj;
            return stepEntity.getId().equals(this.id);

        }
        return super.equals(obj);

    }


}
