package cn.jeeweb.modules.codegen.service;

import cn.jeeweb.core.common.service.ICommonService;
import cn.jeeweb.modules.codegen.entity.Column;

import java.util.List;

public interface IColumnService extends ICommonService<Column> {
	List<Column> selectListByTableId(String tableId);
}
