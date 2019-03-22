package com.company.business.goods.moudle.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.company.manerger.sys.common.base.mvc.entity.AbstractEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("tomato_promotion_packet_user_invited_log")
public class PacketInviteLogEntity extends AbstractEntity<String> {
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 被邀请的用户
     */
    @TableField(value = "invite_user")
    private String invite_user;

    @TableField(value = "invited_user")
    private String invited_user;

    @TableField(value = "packet_money")
    private BigDecimal packet_money;

    @TableField(value = "invite_date")
    private Date invite_date;

}
