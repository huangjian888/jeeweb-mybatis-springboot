package com.company.shop.sys.service.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.company.manerger.sys.common.base.mvc.entity.AbstractEntity;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tomato_user_procedure")
public class ProcedureUserEntity extends AbstractEntity<String> {
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 用户名
     */
    @TableField(value = "username")
    private String username;
    /**
     * 用户已完成次数
     */
    @TableField(value = "packet_count")
    private Integer packetCount;

    /**
     * 用户任务完成时间
     */
    @TableField(value = "complete_date")
    private Date completeDate;
}
