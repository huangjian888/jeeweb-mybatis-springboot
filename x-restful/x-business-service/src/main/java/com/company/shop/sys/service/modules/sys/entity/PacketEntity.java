package com.company.shop.sys.service.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.company.manerger.sys.common.base.mvc.entity.AbstractEntity;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tomato_user_packet")
public class PacketEntity extends AbstractEntity<String> {
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 用户可领红包次数
     */
    @TableField(value = "packet_count")
    private Integer packetCount;
    /**
     * 用户上次领取的红包时间
     */
    @TableField(value = "get_date")
    private Date getDate;
    @TableField(value = "user_name")
    private String username;
}
