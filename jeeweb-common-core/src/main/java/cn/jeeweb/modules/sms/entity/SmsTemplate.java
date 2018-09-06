package cn.jeeweb.modules.sms.entity;

import cn.jeeweb.core.common.entity.AbstractEntity;
import cn.jeeweb.modules.sys.entity.User;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

/**
 * @Title: 短信模版
 * @Description: 短信模版
 * @author jeeweb
 * @date 2017-06-08 10:50:52
 * @version V1.0
 *
 */
@TableName("sms_template")
@SuppressWarnings("serial")
public class SmsTemplate extends AbstractEntity<String> {

	/** 字段主键 */
	@TableId(value = "id", type = IdType.UUID)
	private String id;
	/** 模版名称 */
	private String name;
	/** 模版编码 */
	private String code;
	/** 业务类型 */
	private String businessType;
	/** 模版ID */
	private String templateId;
	/** 模版内容 */
	private String templateContent;
	/** 创建者 */
	@TableField(value = "create_by", el = "createBy.id", fill = FieldFill.INSERT)
	private User createBy;
	/** 创建时间 */
	@TableField(value = "create_date", fill = FieldFill.INSERT)
	private Date createDate;
	/** 更新者 */
	@TableField(value = "update_by", el = "updateBy.id", fill = FieldFill.UPDATE)
	private User updateBy;
	/** 更新时间 */
	@TableField(value = "update_date", fill = FieldFill.UPDATE)
	private Date updateDate;
	/** 删除标记（0：正常；1：删除） */
	@TableField(value = "del_flag", fill = FieldFill.INSERT)
	private String delFlag;
	/** 备注信息 */
	private String remarks;

	/**
	 * 获取 id
	 * 
	 * @return: String 字段主键
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * 设置 id
	 * 
	 * @param: id
	 *             字段主键
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 获取 name
	 * 
	 * @return: String 模版名称
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 设置 name
	 * 
	 * @param: name
	 *             模版名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取 code
	 * 
	 * @return: String 模版编码
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * 设置 code
	 * 
	 * @param: code
	 *             模版编码
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 获取 businessType
	 * 
	 * @return: String 业务类型
	 */
	public String getBusinessType() {
		return this.businessType;
	}

	/**
	 * 设置 businessType
	 * 
	 * @param: businessType
	 *             业务类型
	 */
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	/**
	 * 获取 templateId
	 * 
	 * @return: String 模版ID
	 */
	public String getTemplateId() {
		return this.templateId;
	}

	/**
	 * 设置 templateId
	 * 
	 * @param: templateId
	 *             模版ID
	 */
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	/**
	 * 获取 templateContent
	 * 
	 * @return: String 模版内容
	 */
	public String getTemplateContent() {
		return this.templateContent;
	}

	/**
	 * 设置 templateContent
	 * 
	 * @param: templateContent
	 *             模版内容
	 */
	public void setTemplateContent(String templateContent) {
		this.templateContent = templateContent;
	}

	/**
	 * 获取 createDate
	 * 
	 * @return: Date 创建时间
	 */
	public Date getCreateDate() {
		return this.createDate;
	}

	/**
	 * 设置 createDate
	 * 
	 * @param: createDate
	 *             创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 获取 updateDate
	 * 
	 * @return: Date 更新时间
	 */
	public Date getUpdateDate() {
		return this.updateDate;
	}

	/**
	 * 设置 updateDate
	 * 
	 * @param: updateDate
	 *             更新时间
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public User getCreateBy() {
		return createBy;
	}

	public void setCreateBy(User createBy) {
		this.createBy = createBy;
	}

	public User getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(User updateBy) {
		this.updateBy = updateBy;
	}

	/**
	 * 获取 delFlag
	 * 
	 * @return: String 删除标记（0：正常；1：删除）
	 */
	public String getDelFlag() {
		return this.delFlag;
	}

	/**
	 * 设置 delFlag
	 * 
	 * @param: delFlag
	 *             删除标记（0：正常；1：删除）
	 */
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	/**
	 * 获取 remarks
	 * 
	 * @return: String 备注信息
	 */
	public String getRemarks() {
		return this.remarks;
	}

	/**
	 * 设置 remarks
	 * 
	 * @param: remarks
	 *             备注信息
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
