package com.company.shop.sys.service.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.company.manerger.sys.common.base.mvc.entity.AbstractEntity;
import lombok.Data;


/**
 * 活动配置列表
 */
@TableName("tomato_activity_banner")
@Data
public class ActivityEntity extends AbstractEntity<String> {

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;
    @TableField(value = "image_url")
    private String imageUrl;
    @TableField(value = "name")
    private String description;
    @TableField(value = "sub_name")
    private String subName;
    @TableField(value = "belong")
    private String belong;

}
