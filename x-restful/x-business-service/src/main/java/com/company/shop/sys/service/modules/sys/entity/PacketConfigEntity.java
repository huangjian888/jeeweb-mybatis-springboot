package com.company.shop.sys.service.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.company.manerger.sys.common.base.mvc.entity.AbstractEntity;
import lombok.Data;

import java.util.Date;


@Data
@TableName("tomato_packet_config")
public class PacketConfigEntity extends AbstractEntity<String> {
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 用户可领红包次数
     */
    @TableField(value = "packet_count")
    private Integer packetCount;
    /**
     * 每次红包的奖励步数
     */
    @TableField(value = "award")
    private Integer award;
    /**
     * 红包奖励--名称
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

    @TableField(value = "create_by")
    private String create_by;
    @TableField(value = "update_by")
    private String update_by;

    @TableField(value = "create_date")
    private Date create_date;
    @TableField(value = "update_date")
    private Date update_date;

}
