package com.company.shop.sys.service.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.company.manerger.sys.common.base.mvc.entity.AbstractEntity;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tomato_user_log")
public class LogEntity extends AbstractEntity<String> {

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @TableField("user_name")
    private String userName;


    /**
     * 签到时间
     */
    @TableField(value = "sign_date")
    private Date signTime;
    /**
     * 获得奖励
     */
    @TableField(value = "award")
    private Integer award;

    /**
     * 类别
     */
    @TableField(value = "category")
    private Integer category;
    /**
     * 类别名称
     */
    @TableField(value = "category_name")
    private String categoryName;

}
