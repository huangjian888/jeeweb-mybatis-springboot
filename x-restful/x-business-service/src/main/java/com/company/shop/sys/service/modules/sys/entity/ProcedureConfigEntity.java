package com.company.shop.sys.service.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.company.manerger.sys.common.base.mvc.entity.AbstractEntity;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tomato_procedure_config")
public class ProcedureConfigEntity extends AbstractEntity<String> {
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 当前设置的步数
     */
    @TableField(value = "award")
    private Integer award;
    /**
     * 当前是否可用
     */
    @TableField(value = "description")
    private String description;

    @TableField(value = "status")
    private Integer status;
    /**
     * 类别
     */
    @TableField(value = "category")
    private Integer category;

    /**
     * 用户可领红包次数
     */
    @TableField(value = "packet_count")
    private Integer packetCount;


    @TableField(value = "create_by")
    private String create_by;

    @TableField(value = "update_by")
    private String update_by;

    @TableField(value = "update_date")
    private Date update_date;

    @TableField(value = "create_date")
    private Date create_date;
}
