package com.company.shop.sys.service.modules.sys.entity;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.company.manerger.sys.common.base.mvc.entity.AbstractEntity;
import lombok.Data;

@TableName("tomato_product_category")
@Data
public class ProductCateGoryEntity extends AbstractEntity<String> {

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;
    @TableField("image_url")
    private String imageUrl;
    @TableField("description")
    private String description;
    @TableField("pid") //类别id
    private int pid;


    @TableField("status1") //状态
    private int status;

    @TableField("category_code") //商品分类id
    private String categoryCode;
    @TableField("sub_name") //类别副标题
    private String subName;


}
