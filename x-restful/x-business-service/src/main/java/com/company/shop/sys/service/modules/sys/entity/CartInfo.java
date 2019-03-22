package com.company.shop.sys.service.modules.sys.entity;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.company.manerger.sys.common.base.mvc.entity.AbstractEntity;
import lombok.Data;

@TableName("store_cart_info")
@Data
public class CartInfo extends AbstractEntity<String> {

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;
    /**
     * 用户名--openid
     */
    @TableField(value = "username")
    private String username;

    /**
     * 用户id，备用
     */
    @TableField(value = "user_id")
    private String userId;

    /**
     * 商品id
     */
    @TableField(value = "product_id")
    private String productId;

    /**
     * 选择的商品数量
     */
    @TableField(value = "quantity")
    private Integer quantity;

    /***
     * 是否选择
     */
    @TableField(value = "checked")
    private Integer checked;


}
