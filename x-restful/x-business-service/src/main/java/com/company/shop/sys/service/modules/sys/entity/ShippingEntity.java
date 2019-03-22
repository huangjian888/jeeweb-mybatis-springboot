package com.company.shop.sys.service.modules.sys.entity;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.company.manerger.sys.common.base.mvc.entity.AbstractEntity;
import lombok.Data;

@Data
@TableName(value = "tomato_user_address")
public class ShippingEntity extends AbstractEntity<String> {

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 微信openId
     */
    @TableField(value = "user_name")
    private String username;


    /***
     * 收货人名字
     */
    @TableField(value = "real_name")
    private String realName;

    /****
     * 电话号码
     */
    @TableField(value = "receiver_phone_no")
    private String phone;

    /**
     * 省
     */
    @TableField(value = "province_name")
    private String province;

    /**
     * 市
     */
    @TableField(value = "city_name")
    private String city;

    /**
     * 地区
     */
    @TableField(value = "district_name")
    private String zone;

    /**
     * 街道
     */
    @TableField(value = "street_name")
    private String street;
    /**
     * 详细地址
     */
    @TableField(value = "detail_address")
    private String detailAddress;
    /**
     * 邮政编码
     */
    @TableField(value = "receiver_zip_code")
    private String code;
    /**
     * 默认收货地址标记位
     */
    @TableField(value = "default_address")
    private Integer defaultAddress;

}
