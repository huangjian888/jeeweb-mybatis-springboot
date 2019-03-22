package com.company.business.goods.moudle.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.company.manerger.sys.common.base.mvc.entity.AbstractEntity;
import lombok.Data;

import java.util.Date;

/***
 * 人工推荐主题配置
 */
@Data
@TableName("tomato_promotion_subject_config")
public class SubjectEntity extends AbstractEntity<String> {
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @TableField(value = "subject_name")
    private String subject_name;

    /**
     * 权重配置0-100
     */
    @TableField(value = "subject_weight")
    private Integer subject_weight;
    @TableField(value = "subject_start_date")
    private Date subject_start_date;
    @TableField(value = "subject_end_date")
    private Date subject_end_date;
    @TableField(value = "subject_product_id")
    private String subject_product_id;
    @TableField(value = "subject_channel_id")
    private String subject_channel_id;

}
