package com.company.manerger.sys.service.modules.sys.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.company.manerger.sys.common.base.mvc.entity.AbstractEntity;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import java.util.Date;

/**
 *
 * @version V1.0
 * @package com.company.manerger.sys.service.modules.sys.entity
 * @title: 商品规格实体
 * @description: 显示商品规格实体
 * @date: 2018-12-03 14:41:15
 */

@TableName("sys_grand_spec")
@SuppressWarnings("serial")
public class GrandSpec extends AbstractEntity<String> {

    /**字段主键*/
    @TableId(value = "id", type = IdType.UUID)
	private String id;
    /**商品id*/
    @TableField(value = "grand_classify_id")
	private String grandClassifyId;
    /**尺寸*/
    @TableField(value = "size")
	private String size;
    /**颜色*/
    @TableField(value = "colour")
	private String colour;
    /**库存*/
    @TableField(value = "stock")
	private String stock;
    /**更新时间*/
    @TableField(value = "update_date", fill = FieldFill.UPDATE)
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    protected Date updateDate; // 更新日期
	/**
	 * 获取  id
	 *@return String  字段主键
	 */
	public String getId(){
		return this.id;
	}

	/**
	 * 设置  id
	 *@param id  字段主键
	 */
	public void setId(String id){
		this.id = id;
	}

	/**
	 * 获取  size
	 *@return String  尺寸
	 */
	public String getSize(){
		return this.size;
	}

	/**
	 * 设置  size
	 *@param size  尺寸
	 */
	public void setSize(String size){
		this.size = size;
	}
	/**
	 * 获取  colour
	 *@return String  颜色
	 */
	public String getColour(){
		return this.colour;
	}

	/**
	 * 设置  colour
	 *@param colour  颜色
	 */
	public void setColour(String colour){
		this.colour = colour;
	}
	/**
	 * 获取  stock
	 *@return String  库存
	 */
	public String getStock(){
		return this.stock;
	}

	/**
	 * 设置  stock
	 *@param stock  库存
	 */
	public void setStock(String stock){
		this.stock = stock;
	}
    /**
     * 获取  updateDate
     *@return Date  更新时间
     */
    public Date getUpdateDate(){
        return this.updateDate;
    }

    /**
     * 设置  updateDate
     *@param updateDate  更新时间
     */
    public void setUpdateDate(Date updateDate){
        this.updateDate = updateDate;
    }

	/**
	 * 获取商品ID
	 *
	 */
	public String getGrandClassifyId() { return this.grandClassifyId; }

	/**
	 * 设置商品ID
	 *
	 */
	public void setGrandClassifyId(String grandClassifyId) {
		this.grandClassifyId = grandClassifyId;
	}
}