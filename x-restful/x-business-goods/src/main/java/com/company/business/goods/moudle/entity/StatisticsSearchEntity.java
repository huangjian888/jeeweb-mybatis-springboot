package com.company.business.goods.moudle.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.company.manerger.sys.common.base.mvc.entity.AbstractEntity;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tomato_promotion_search_statistics")
public class StatisticsSearchEntity extends AbstractEntity<String> {
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @TableField(value = "user_name")
    private String username;

    @TableField(value = "key_word")
    private String keyWord;
    @TableField(value = "search_update_time")
    private Date search_update_time;
}
