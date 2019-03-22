package com.company.shop.sys.service.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.company.manerger.sys.common.base.mvc.entity.AbstractEntity;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tomato_user_invite")
public class InviteAwardEntity extends AbstractEntity<String> {


    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * openId
     */
    @TableField(value = "user_name")
    private String userName;
    /**
     * 奖励
     */
    @TableField(value = "award")
    private Integer award;
    /**
     * 是否领取状态
     */
    @TableField(value = "status")
    private Integer status;
    /**
     * 当前任务描述
     */
    @TableField(value = "description")
    private String description;
    /**
     * 领取时间
     */
    @TableField(value = "get_date")
    private Date getDate;
    /**
     * 插入数据表时间
     */
    @TableField(value = "insert_date")
    private Date insertDate;

}
