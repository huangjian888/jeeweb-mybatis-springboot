package com.company.business.goods.moudle.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.company.manerger.sys.common.base.mvc.entity.AbstractEntity;
import lombok.Data;

@Data
@TableName("tomato_promotion_qrcode_config")
public class QrCodeEntity extends AbstractEntity<String> {

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;


    /**
     * 二维码图片
     */
    @TableField(value = "wx_qrcode_img")
    private String qrImg;
    /**
     * 微信账号
     */
    @TableField(value = "wx_account")
    private String wx_account;
    /**
     * 状态
     */
    @TableField(value = "status")
    private Integer status;
    /**
     * 当天显示次数
     */
    @TableField(value = "show_counts")
    private Integer show_counts;

}
