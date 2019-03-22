package com.company.business.goods.moudle.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.company.manerger.sys.common.base.mvc.entity.AbstractEntity;
import lombok.Data;

@Data
@TableName("tomato_promotion_hardware")
public class HardwareEntity extends AbstractEntity<String> {

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;


    @TableField(value = "user_name")
    private String username;

    @TableField(value = "brand")
    private String brand;
    @TableField(value = "model")
    private String model;
    @TableField(value = "version")
    private String version;
    @TableField(value = "system")
    private String system;
    @TableField(value = "platform")
    private String platform;

    @TableField(value = "phone_info")
    private String phoneInfo;

}
