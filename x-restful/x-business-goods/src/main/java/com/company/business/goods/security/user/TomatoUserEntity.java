package com.company.business.goods.security.user;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.company.manerger.sys.common.base.mvc.entity.AbstractEntity;
import lombok.Data;

import java.util.Date;

@TableName("tomato_promotion_user")
@Data
public class TomatoUserEntity extends AbstractEntity<String> {

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
     * 密码
     */
    @TableField(value = "password")
    private String password;



    /**
     * 新用户，默认1
     */
    @TableField(value = "new_user")
    private Integer rookie;
    /**
     * 注册时间
     */
    @TableField(value = "register_date")
    private Date registerDate;
    /**
     * 最近登录时间
     */
    @TableField(value = "lately_login_date")
    private Date latelyLogin;

    /**
     * 用户退出小程序时的时间
     */
    @TableField(value = "exit_time")
    private Date exitTime;
    /**
     * 性别
     */
    @TableField(value = "gender")
    private String gender;
    /**
     * 地址
     */
    @TableField(value = "address")
    private String address;

    /**
     * 当前用户的邀请者
     */
    @TableField(value = "invite_user")
    private String inviteUser;
}
