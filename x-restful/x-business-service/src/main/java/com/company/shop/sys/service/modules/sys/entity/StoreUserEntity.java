package com.company.shop.sys.service.modules.sys.entity;

import com.company.manerger.sys.common.base.mvc.entity.AbstractEntity;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @version V1.0
 * @package com.company.shop.sys.service.modules.sys.entity
 * @title: 用户表实体
 * @description: 用户表实体
 * @author: huangjian
 * @date: 2018-11-23 15:48:46
 */

@TableName("tomato_user")
@Data
@SuppressWarnings("serial")
public class StoreUserEntity extends AbstractEntity<String> {

    /**
     * 字段主键
     */
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;
    /**
     * 删除标记（0：正常；1：删除）
     */
    @TableField(value = "del_flag")
    private String delFlag;
    /**
     * 备注信息
     */
    @TableField(value = "remarks")
    private String remarks;
    /**
     * 昵称
     */
    @TableField(value = "nick_name")
    private String nickName;
    /**
     * 头像
     */
    @TableField(value = "avatar")
    private String avatar;
    /**
     * 用户名--openid
     */
    @TableField(value = "username")
    private String username;
    /**
     * 邀请者的openId
     */
    @TableField(value = "invite_user")
    private String inviteUser;

    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 用户的状态
     */
    /**
     * 金币
     */
    @TableField(value = "gold")
    private BigDecimal gold;

    /**
     * 今日金币
     */
    @TableField(value = "gold_today")
    private BigDecimal goldToday;
    /**
     * 今日金币
     */
    @TableField(value = "gold_history")
    private BigDecimal goldHistory;

    /**
     * 步数
     */
    @TableField(value = "step")
    private Integer step;

    /**
     * 新用户，默认1
     */
    @TableField(value = "new_user")
    private Integer newuser;
    /**
     * 今日是否有用金币兑换步数，1-有
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 注册时间
     */
    @TableField(value = "register_date")
    private Date registerDate;
    /**
     * 最近登录时间
     */
    @TableField(value = "lately_login")
    private Date latelyLogin;


}