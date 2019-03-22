package com.company.shop.sys.service.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.company.manerger.sys.common.base.mvc.entity.AbstractEntity;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tomato_sign_config")
public class SignConfigEntity extends AbstractEntity<String> {

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;
    /**
     * 服务端配置的奖励步数
     */
    @TableField("step")
    private Integer step;
    /**
     * 服务端配置的连续签到天数奖励
     */
    @TableField("count_day")
    private Integer countDay;

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

    @TableField(value = "create_by")
    private String create_by;
    @TableField(value = "update_by")
    private String update_by;

    @TableField(value = "create_date")
    private Date create_date;
    @TableField(value = "update_date")
    private Date update_date;
}
