package com.company.manerger.sys.service.modules.sys.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.company.manerger.sys.common.mybatis.entity.TreeEntity;

@TableName("sys_menu")
@SuppressWarnings("serial")
public class Menu extends TreeEntity<Menu> {
	/** 图标 */
	@TableField(value = "menu_icon")
	private String menuIcon;
	/** 资源类型 */
	@TableField(value = "type")
	private String type;
	/** 点击后前往的地址 */
	@TableField(value = "url")
	private String url;
	/** 权限字符串 */
	@TableField(value = "permission")
	private String permission;
	/** 是否有效 */
	@TableField(value = "enabled")
	private Short enabled;
	/** 排序 */
	@TableField(value = "sort")
	private Integer sort;
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
	/** 备注 */
	@TableField(value = "remarks")
	private String remarks;

	public String getMenuIcon() {
		return menuIcon;
	}

	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public Short getEnabled() {
		return enabled;
	}

	public void setEnabled(Short enabled) {
		this.enabled = enabled;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
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
