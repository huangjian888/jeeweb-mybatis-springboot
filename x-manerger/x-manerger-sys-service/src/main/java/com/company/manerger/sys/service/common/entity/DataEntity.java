package com.company.manerger.sys.service.common.entity;

import com.company.manerger.sys.common.base.mvc.entity.AbstractEntity;
import com.company.manerger.sys.service.common.constant.DataBaseConstant;
import com.company.manerger.sys.service.modules.sys.entity.User;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import java.util.Date;

/**
 * 数据Entity类
 *
 * 主键类型
 */
public abstract class DataEntity<ID> extends AbstractEntity<ID> {

	private static final long serialVersionUID = 1L;

	@TableField(value = "remarks")
	protected String remarks; // 备注
	@TableField(value = "create_by", el = "createBy.id", fill = FieldFill.INSERT)
	protected User createBy; // 创建者
	@TableField(value = "create_date", fill = FieldFill.INSERT)
	protected Date createDate; // 创建日期
	@TableField(value = "update_by", el = "updateBy.id", fill = FieldFill.UPDATE)
	protected User updateBy; // 更新者
	@TableField(value = "update_date", fill = FieldFill.UPDATE)
	protected Date updateDate; // 更新日期
	@TableField(value = "del_flag", fill = FieldFill.INSERT)
	protected String delFlag = "0"; // 删除标记（0：正常；1：删除 ）

	public DataEntity() {
		super();
		this.delFlag = DataBaseConstant.DEL_FLAG_NORMAL;
	}

	public User getCreateBy() {
		return createBy;
	}

	public void setCreateBy(User createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public User getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(User updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
