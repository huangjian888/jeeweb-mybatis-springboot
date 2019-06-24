package com.company.manerger.sys.common.mp3.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

public interface BaseTreeMapper<T> extends BaseMapper<T> {
	/**
	 * 
	 * @title: selectByPrimaryKey
	 * @description: 查找主键
	 * @param id
	 * @return
	 * @return: Menu
	 */
	T selectByTreeId(Serializable id);

	/**
	 * 
	 * @title: selectTreeList
	 * @description: 查找列表
	 * @param wrapper
	 * @return
	 * @return: List<T>
	 */
	List<T> selectTreeList(@Param("ew") QueryWrapper<T> wrapper);

	/**
	 * 
	 * @title: updateSunTreeParentId
	 * @description: 更新ParentIds
	 * @param newParentIds
	 * @param oldParentIds
	 * @return: void
	 */
	void updateSunTreeParentIds(@Param("newParentIds") String newParentIds, @Param("oldParentIds") String oldParentIds);

	/**
	 * 
	 * @title: selectTreeList
	 * @description: 查找列表
	 * @param parentIds
	 * @return
	 * @return: List<T>
	 */
	void deleteSunTree(String parentIds);

}