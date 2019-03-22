package com.company.shop.sys.service.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.company.manerger.sys.common.base.mvc.entity.AbstractEntity;
import lombok.Data;

@Data
@TableName("tomato_task_configuration")
public class TaskEntity extends AbstractEntity<String> {

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;
    /**
     * 服务端配置的奖励步数
     */
    @TableField("award")
    private Integer award;
    /**
     * 任务名称
     */
    @TableField("task_name")
    private Integer taskName;

    /**
     * 是否可用
     */
    @TableField("status")
    private Integer status;
    /**
     * 任务的每日限制次数
     */
    @TableField("limit_count")
    private Integer limitCount;
    /**
     * 任务类别--服务后台设置
     */
    @TableField("category")
    private Integer category;

}
