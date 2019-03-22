package com.company.generator.manager.service;

import com.company.generator.manager.entity.Column;
import com.company.manerger.sys.common.mybatis.service.ICommonService;

import java.util.List;

public interface IColumnService extends ICommonService<Column> {
	/**
	 * 通过表ID获得所有的列
	 * @param tableId
	 * @return
	 */
	List<Column> selectListByTableId(String tableId);

}
