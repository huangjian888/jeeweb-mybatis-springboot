package com.company.shop.sys.service.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.company.manerger.sys.common.base.mvc.entity.AbstractEntity;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tomato_share_config")
public class InviteConfigEntity extends AbstractEntity<String> {
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;
    /**
     * 服务端配置的奖励步数
     */
    @TableField("award")
    private Integer award;
    /**
     * 限制次数
     */
    @TableField("packet_count")
    private Integer packetCount;

    @TableField("status")
    private Integer status;

    /**
     * 任务名称
     */
    @TableField("description")
    private String description;
    /**
     * 类别
     */
    @TableField(value = "category")
    private Integer category;


    @TableField("create_by")
    private String create_by;

    @TableField("update_by")
    private String update_by;

    @TableField("create_date")
    private Date create_date;
    @TableField("update_date")
    private Date update_date;

}
