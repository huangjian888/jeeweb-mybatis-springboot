package com.company.business.goods.moudle.entity;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.company.manerger.sys.common.base.mvc.entity.AbstractEntity;
import lombok.Data;

@TableName("tomato_promotion_category_sub")
@Data
public class CateGorySubEntity extends AbstractEntity<String> {

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @TableField("icon")
    private String icon;

    @TableField("opt_name")
    private String opt_name;
    /**
     * 拼多多返回
     */
    @TableField("opt_id")
    private Integer opt_id;
    /**
     * 拼多多返回
     */
    @TableField("parent_opt_id")
    private Integer parent_opt_id;
    /**
     * 拼多多返回
     */
    @TableField("level")
    private Integer level;
    /**
     * 拼多多返回
     */
    @TableField("order_id")
    private Integer order;


}
