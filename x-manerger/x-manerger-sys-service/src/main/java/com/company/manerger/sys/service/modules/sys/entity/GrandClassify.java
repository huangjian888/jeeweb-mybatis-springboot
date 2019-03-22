package com.company.manerger.sys.service.modules.sys.entity;

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
 * @title: 商品列表实体
 * @description: 商品列表实体
 * @date: 2018-11-29 15:45:52
 */

@TableName("sys_grand_classify")
@SuppressWarnings("serial")
public class GrandClassify extends AbstractEntity<String> {

    /**字段主键*/
    @TableId(value = "id", type = IdType.UUID)
	private String id;
    /**商品id*/
    @TableField(value = "grand_id")
	private String grandId;
    /**商品名字*/
    @TableField(value = "grand_name")
	private String grandName;
    /**icon*/
    @TableField(value = "icon")
	private String icon;
    /**展示图1*/
    @TableField(value = "show_img1")
	private String showImg1;
    /**展示图2*/
    @TableField(value = "show_img2")
	private String showImg2;
    /**展示图3*/
    @TableField(value = "show_img3")
	private String showImg3;
    /**展示图4*/
    @TableField(value = "show_img4")
	private String showImg4;
    /**展示图5*/
    @TableField(value = "show_img5")
	private String showImg5;
    /**详情图*/
    @TableField(value = "details_img")
	private String detailsImg;
    /**原价*/
    @TableField(value = "original")
	private String original;
    /**销售价*/
    @TableField(value = "present")
	private String present;
    /**正品保障*/
    @TableField(value = "is_quality")
	private String isQuality;
    /**全场包邮*/
    @TableField(value = "is_free")
	private String isFree;
    /**七天退换*/
    @TableField(value = "is_return")
	private String isReturn;
    /**先行赔付*/
    @TableField(value = "is_pay")
	private String isPay;
    /**创建时间*/
	@TableField(value = "create_date", fill = FieldFill.INSERT)
	private Date createDate;
    /**更新时间*/
	@TableField(value = "update_date", fill = FieldFill.UPDATE)
	private Date updateDate;
    /**删除标记（0：正常；1：删除）*/
	@TableField(value = "del_flag", fill = FieldFill.INSERT)
	private String delFlag;
	/**获取品牌表名字  exist 不是数据库字段*/
	@TableField(value = "name",exist= false)
    private String name;

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
	 * 获取  grandId
	 *@return String  商品id
	 */
	public String getGrandId(){
		return this.grandId;
	}

	/**
	 * 设置  grandId
	 *@param grandId  商品id
	 */
	public void setGrandId(String grandId){
		this.grandId = grandId;
	}
	/**
	 * 获取  grandName
	 *@return String  商品名字
	 */
	public String getGrandName(){
		return this.grandName;
	}

	/**
	 * 设置  grandName
	 *@param grandName  商品名字
	 */
	public void setGrandName(String grandName){
		this.grandName = grandName;
	}
	/**
	 * 获取  icon
	 *@return String  icon
	 */
	public String getIcon(){
		return this.icon;
	}

	/**
	 * 设置  icon
	 *@param icon  icon
	 */
	public void setIcon(String icon){
		this.icon = icon;
	}
	/**
	 * 获取  showImg1
	 *@return String  展示图1
	 */
	public String getShowImg1(){
		return this.showImg1;
	}

	/**
	 * 设置  showImg1
	 *@param showImg1  展示图1
	 */
	public void setShowImg1(String showImg1){
		this.showImg1 = showImg1;
	}
	/**
	 * 获取  showImg2
	 *@return String  展示图2
	 */
	public String getShowImg2(){
		return this.showImg2;
	}

	/**
	 * 设置  showImg2
	 *@param showImg2  展示图2
	 */
	public void setShowImg2(String showImg2){
		this.showImg2 = showImg2;
	}
	/**
	 * 获取  showImg3
	 *@return String  展示图3
	 */
	public String getShowImg3(){
		return this.showImg3;
	}

	/**
	 * 设置  showImg3
	 *@param showImg3  展示图3
	 */
	public void setShowImg3(String showImg3){
		this.showImg3 = showImg3;
	}
	/**
	 * 获取  showImg4
	 *@return String  展示图4
	 */
	public String getShowImg4(){
		return this.showImg4;
	}

	/**
	 * 设置  showImg4
	 *@param showImg4  展示图4
	 */
	public void setShowImg4(String showImg4){
		this.showImg4 = showImg4;
	}
	/**
	 * 获取  showImg5
	 *@return String  展示图5
	 */
	public String getShowImg5(){
		return this.showImg5;
	}

	/**
	 * 设置  showImg5
	 *@param showImg5  展示图5
	 */
	public void setShowImg5(String showImg5){
		this.showImg5 = showImg5;
	}
	/**
	 * 获取  detailsImg
	 *@return String  详情图
	 */
	public String getDetailsImg(){
		return this.detailsImg;
	}

	/**
	 * 设置  detailsImg
	 *@param detailsImg  详情图
	 */
	public void setDetailsImg(String detailsImg){
		this.detailsImg = detailsImg;
	}
	/**
	 * 获取  original
	 *@return String  原价
	 */
	public String getOriginal(){
		return this.original;
	}

	/**
	 * 设置  original
	 *@param original  原价
	 */
	public void setOriginal(String original){
		this.original = original;
	}
	/**
	 * 获取  present
	 *@return String  销售价
	 */
	public String getPresent(){
		return this.present;
	}

	/**
	 * 设置  present
	 *@param present  销售价
	 */
	public void setPresent(String present){
		this.present = present;
	}
	/**
	 * 获取  isQuality
	 *@return Boolean  正品保障
	 */
	public String getIsQuality(){
		return this.isQuality;
	}

	/**
	 * 设置  isQuality
	 *@param isQuality  正品保障
	 */
	public void setIsQuality(String isQuality){
		this.isQuality = isQuality;
	}
	/**
	 * 获取  isFree
	 *@return Boolean  全场包邮
	 */
	public String getIsFree(){
		return this.isFree;
	}

	/**
	 * 设置  isFree
	 *@param isFree  全场包邮
	 */
	public void setIsFree(String isFree){
		this.isFree = isFree;
	}
	/**
	 * 获取  isReturn
	 *@return Boolean  七天退换
	 */
	public String getIsReturn(){
		return this.isReturn;
	}

	/**
	 * 设置  isReturn
	 *@param isReturn  七天退换
	 */
	public void setIsReturn(String isReturn){
		this.isReturn = isReturn;
	}
	/**
	 * 获取  isPay
	 *@return Boolean  先行赔付
	 */
	public String getIsPay(){
		return this.isPay;
	}

	/**
	 * 设置  isPay
	 *@param isPay  先行赔付
	 */
	public void setIsPay(String isPay){
		this.isPay = isPay;
	}
	/**
	 * 获取  createDate
	 *@return Date  创建时间
	 */
	public Date getCreateDate(){
		return this.createDate;
	}

	/**
	 * 设置  createDate
	 *@param createDate  创建时间
	 */
	public void setCreateDate(Date createDate){
		this.createDate = createDate;
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
	 * 获取  delFlag
	 *@return String  删除标记（0：正常；1：删除）
	 */
	public String getDelFlag(){
		return this.delFlag;
	}

	/**
	 * 设置  delFlag
	 *@param delFlag  删除标记（0：正常；1：删除）
	 */
	public void setDelFlag(String delFlag){
		this.delFlag = delFlag;
	}

	/**
	 * 获取  name
	 *@return String  品牌名字
	 */
	public String getName() { return name; }
	/**
	 * 设置  name
	 *@param name  品牌名字
	 */
	public void setName(String name) { this.name = name; }

}