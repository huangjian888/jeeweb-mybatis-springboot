package com.company.shop.sys.service.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.company.manerger.sys.common.base.mvc.entity.AbstractEntity;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 商城商品描述
 */
@Data
@TableName(value = "tomato_products")
public class ProductEntity extends AbstractEntity<String> {
    /**
     * 字段主键
     */
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    /***
     * 分类id--属于哪个类别下
     */
    @TableField(value = "category_id")

    private String categoryId;

    /***
     * 商品名称
     */
    @TableField(value = "product_name")
    private String productName;


    /***
     * 主图url地址
     */
    @TableField(value = "main_image")
    private String mainImageUrl;


    /**
     * 商品详细描述
     */
    @TableField(value = "detail")
    private String detail;

    /***
     * 商品价格--现价,保留两位有效数字
     */
    @TableField(value = "price")
    private BigDecimal price;

    /***
     * 商品价格--金币
     */
    @TableField(value = "gold")
    private BigDecimal gold;

    /**
     * 状态--在售、下架
     */

    @TableField(value = "status")
    private Integer status;

    /*
    @TableField(value = "sales")
    private Integer sales;*/
    /***
     * 原价
     */
    @TableField(value = "original_price")
    private BigDecimal originalPrice;


    /**
     * 正品保证
     */
    @TableField(value = "genuine_guarantee")
    private Integer guarantee;
    /***
     * 包邮
     */
    @TableField(value = "pinkage")
    private Integer pinkage;
    /***
     * 七天退款
     */
    @TableField(value = "seven_days_return")
    private Integer seven;
    /***
     * 先行赔付
     */
    @TableField(value = "compensation")
    private Integer compensation;


    /***
     * 供货商名称
     */

    @TableField(value = "provider_company")
    private String company;

    /***
     * 供货商id
     */
    @TableField(value = "provider_company_id")
    private String companyId;
    /***
     * 描述
     */
    @TableField(value = "description")
    private String description;
    /***
     * 库存
     */
    @TableField(value = "inventory")
    private Integer inventory;
    /***
     * 邮费
     */
    @TableField(value = "page_price")
    private BigDecimal pinkagePrice;
    /***
     * 需要邀请多少人
     */
    @TableField(value = "invite")
    private Integer invite;

    /***
     * 商品id
     */
    @TableField(value = "product_id")
    private String product_id;

    /**
     * 附加人民币即：金币+人民币
     */
    @TableField(value = "attach")
    private BigDecimal attach;
    /***
     * 描述
     */
    @TableField(value = "descriptions")
    private String descriptions;


    /***
     * 商品详情--轮播图
     */
    @TableField(value = "show_img1")
    private String subImagesUrl;

}
