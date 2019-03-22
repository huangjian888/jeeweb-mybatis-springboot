package com.company.shop.sys.service.common.bean;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.company.shop.sys.service.common.dto.LoginAuthDto;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 封装当前用户的操作者以及操作时间
 */
@Data
public class BaseEntity<ID> implements Serializable {

    @TableId(value = "id", type = IdType.UUID)
    private ID id;

    /**
     * 版本号
     */
    private Integer version;
    /**
     * 创建人
     */
    @TableField(value = "create_by")
    private String creator;

    /**
     * 创建人ID
     */
    @TableField(value = "create_id")
    private Long creatorId;

    /**
     * 创建时间
     */
    @TableField(value = "create_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdTime;

    /**
     * 最近操作人
     */
    @TableField(value = "update_by")
    private String lastOperator;

    /**
     * 最后操作人ID
     */
    @TableField(value = "update_id")
    private Long lastOperatorId;

    /**
     * 更新时间
     */
    @TableField(value = "update_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;


    /**
     * 用户id为null即为新用户
     *
     * @return the boolean
     */
    @JsonIgnore
    public boolean isNew() {
        return this.id == null;
    }

    /**
     * 更新当前操作者信息
     *
     * @param user the user
     */
    @JsonIgnore
    public void setUpdateInfo(LoginAuthDto user) {

        if (isNew()) {
            this.creatorId = (this.lastOperatorId = user.getUserId());
            this.creator = user.getUserName();
            this.createdTime = (this.updateTime = new Date());
        }
        this.lastOperatorId = user.getUserId();
        this.lastOperator = user.getUserName() == null ? user.getLoginName() : user.getUserName();
        this.updateTime = new Date();
    }


}
