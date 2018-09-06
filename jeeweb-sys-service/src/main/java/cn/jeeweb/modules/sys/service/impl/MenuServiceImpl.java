package cn.jeeweb.modules.sys.service.impl;

import cn.jeeweb.core.common.service.impl.TreeCommonServiceImpl;
import cn.jeeweb.modules.sys.entity.Menu;
import cn.jeeweb.modules.sys.mapper.MenuMapper;
import cn.jeeweb.modules.sys.service.IMenuService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service(interfaceClass = IMenuService.class)
public class MenuServiceImpl extends TreeCommonServiceImpl<MenuMapper, Menu, String> implements IMenuService {

	@Override
	public List<Menu> findMenuByUserId(String userId) {
		return baseMapper.findMenuByUserId(userId);
	}

	@Override
	public List<Menu> findMenuByUserId_Type(String userId, String type) {
		return baseMapper.findMenuByUserId_Type(userId,type);
	}

	@Override
	public List<Menu> findMenuByRoleId(String roleId) {
		return baseMapper.findMenuByRoleId(roleId);
	}

}
