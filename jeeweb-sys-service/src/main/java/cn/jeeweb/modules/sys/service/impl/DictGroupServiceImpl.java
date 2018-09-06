package cn.jeeweb.modules.sys.service.impl;

import cn.jeeweb.core.common.service.impl.CommonServiceImpl;
import cn.jeeweb.modules.sys.entity.DictGroup;
import cn.jeeweb.modules.sys.mapper.DictGroupMapper;
import cn.jeeweb.modules.sys.service.IDictGroupService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(interfaceClass = IDictGroupService.class)
public class DictGroupServiceImpl extends CommonServiceImpl<DictGroupMapper,DictGroup> implements IDictGroupService {
}
