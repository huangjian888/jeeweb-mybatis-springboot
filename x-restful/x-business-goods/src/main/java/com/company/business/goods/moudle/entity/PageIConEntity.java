package com.company.business.goods.moudle.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.company.manerger.sys.common.base.mvc.entity.AbstractEntity;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tomato_promotion_icon_config")
public class PageIConEntity extends AbstractEntity<String> {

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;


    /**
     * 二维码图片
     */
    @TableField(value = "icon_mark")
    private String iconMark;
    /**
     * 状态
     */
    @TableField(value = "page_info")
    private String pageInfo;

    @TableField(value = "status")
    private Integer status;

    @TableField(value = "remark")
    private String remark;

    @TableField(value = "create_by")
    private String createBy;
    @TableField(value = "create_id")
    private String createId;
    @TableField(value = "create_date")
    private Date createDate;

    @TableField(value = "update_date")
    private Date updateDate;
    @TableField(value = "update_by")
    private String updateBy;
    @TableField(value = "update_id")
    private String updateId;
}
