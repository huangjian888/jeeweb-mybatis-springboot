package cn.jeeweb.modules.sys.service.impl;

import cn.jeeweb.core.common.service.impl.CommonServiceImpl;
import cn.jeeweb.modules.sys.entity.RoleMenu;
import cn.jeeweb.modules.sys.mapper.RoleMenuMapper;
import cn.jeeweb.modules.sys.service.IRoleMenuService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(interfaceClass = IRoleMenuService.class)
public class RoleMenuServiceImpl extends CommonServiceImpl<RoleMenuMapper,RoleMenu> implements IRoleMenuService {

}
