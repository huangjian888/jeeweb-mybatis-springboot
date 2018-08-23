package cn.jeeweb.modules.sys.service.impl;

import cn.jeeweb.core.common.service.impl.CommonServiceImpl;
import cn.jeeweb.modules.sys.entity.RoleMenu;
import cn.jeeweb.modules.sys.mapper.RoleMenuMapper;
import cn.jeeweb.modules.sys.service.IRoleMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("roleMenuService")
public class RoleMenuServiceImpl extends CommonServiceImpl<RoleMenuMapper,RoleMenu> implements IRoleMenuService {

}
