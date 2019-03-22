package com.company.shop.sys.service.modules.sys.entity;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.company.manerger.sys.common.base.mvc.entity.AbstractEntity;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tomato_user_sign")
public class SignEntity extends AbstractEntity<String> {

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @TableField("user_name")
    private String userName;
    /**
     * 用户连续签到次数
     */
    @TableField("sign_count")
    private Integer signCount;


    /**
     * 签到时间
     */
    @TableField("sign_date")
    private Date signTime;


    /**
     * 设置是否提醒签到 1是
     */
    @TableField("auto_alert")
    private Integer autoAlert;

    /**
     * 是否是第一次签到1：是，默认
     */
    @TableField("first_time")
    private Integer firstTime;


}
