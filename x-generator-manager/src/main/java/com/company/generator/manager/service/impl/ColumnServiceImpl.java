package com.company.generator.manager.service.impl;

import com.company.generator.manager.entity.Column;
import com.company.generator.manager.mapper.ColumnMapper;
import com.company.generator.manager.service.IColumnService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.company.manerger.sys.common.mybatis.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional
@Service("columnService")
public class ColumnServiceImpl extends CommonServiceImpl<ColumnMapper, Column> implements IColumnService {

	@Override
	public List<Column> selectListByTableId(String tableId) {
		EntityWrapper<Column> columnWrapper = new EntityWrapper<>();
		columnWrapper.eq("table_id", tableId);
		columnWrapper.orderBy("sort");
		List<Column> oldColumnList = selectList(columnWrapper);
		return oldColumnList;
	}

}
