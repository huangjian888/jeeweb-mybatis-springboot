package cn.jeeweb.modules.sys.service.impl;

import cn.jeeweb.core.common.service.impl.CommonServiceImpl;
import cn.jeeweb.modules.sys.entity.UserOrganization;
import cn.jeeweb.modules.sys.mapper.UserOrganizationMapper;
import cn.jeeweb.modules.sys.service.IUserOrganizationService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service(interfaceClass = IUserOrganizationService.class)
public class UserOrganizationServiceImpl extends CommonServiceImpl<UserOrganizationMapper, UserOrganization>
		implements IUserOrganizationService {

}
