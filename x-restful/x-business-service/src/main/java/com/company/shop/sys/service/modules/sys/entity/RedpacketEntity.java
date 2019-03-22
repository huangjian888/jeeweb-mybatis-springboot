package com.company.shop.sys.service.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.company.manerger.sys.common.base.mvc.entity.AbstractEntity;
import lombok.Data;

@Data
@TableName("tomato_user_packet")
public class RedpacketEntity extends AbstractEntity<String> {

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 设置的领取红包次数
     */
    @TableField(value = "packet_count")
    private String count;

    @TableField(value = "user_id")
    private String userId;

}
