package com.company.manerger.sys.service.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.company.manerger.sys.service.common.entity.DataEntity;

import java.lang.String;
import java.lang.Integer;

@TableName("sys_dict")
@SuppressWarnings("serial")
public class Dict extends DataEntity<String> {

	/** 主键 */
	@TableId(value = "id", type = IdType.UUID)
	private String id;
	/** 分组ID */
	@TableField(value = "gid")
	private String gid;
	/** 键值名称 */
	@TableField(value = "label")
	private String label;
	/** 值 */
	@TableField(value = "value")
	private String value;
	/** 描述 */
	@TableField(value = "remarks")
	private String remarks;
	/** 排序 */
	@TableField(value = "sort")
	private Integer sort;
	/** 分组code */
	@TableField(exist = false)
	private String code;

	/**
	 * 获取 gid
	 * 
	 * @return: String 分组ID
	 */
	public String getGid() {
		return this.gid;
	}

	/**
	 * 设置 gid
	 * 
	 * @param: gid
	 *             分组ID
	 */
	public void setGid(String gid) {
		this.gid = gid;
	}

	/**
	 * 获取 id
	 * 
	 * @return: String 主键
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * 设置 id
	 * 
	 * @param: id
	 *             主键
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 获取 name
	 * 
	 * @return: String 键值名称
	 */
	public String getLabel() {
		return this.label;
	}

	/**
	 * 设置 name
	 * 
	 * @param: name
	 *             键值名称
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * 获取 value
	 * 
	 * @return: String 值
	 */
	public String getValue() {
		return this.value;
	}

	/**
	 * 设置 value
	 * 
	 * @param: value
	 *             值
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * 获取 remarks
	 * 
	 * @return: String 描述
	 */
	public String getRemarks() {
		return this.remarks;
	}

	/**
	 * 设置 remarks
	 * 
	 * @param: remarks
	 *             描述
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * 获取 sort
	 * 
	 * @return: Integer 排序
	 */
	public Integer getSort() {
		return this.sort;
	}

	/**
	 * 设置 sort
	 * 
	 * @param: sort
	 *             排序
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
