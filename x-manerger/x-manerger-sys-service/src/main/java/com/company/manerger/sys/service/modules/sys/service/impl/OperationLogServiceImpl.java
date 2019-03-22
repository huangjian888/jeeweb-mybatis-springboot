package com.company.manerger.sys.service.modules.sys.service.impl;

import com.company.manerger.sys.common.mybatis.service.impl.CommonServiceImpl;
import com.company.manerger.sys.service.modules.sys.entity.OperationLog;
import com.company.manerger.sys.service.modules.sys.mapper.OperationLogMapper;
import com.company.manerger.sys.service.modules.sys.service.IOperationLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
* @description: 操作日志服务实现
*/
@Transactional
@Service("operationlogService")
public class OperationLogServiceImpl  extends CommonServiceImpl<OperationLogMapper,OperationLog> implements  IOperationLogService {

}