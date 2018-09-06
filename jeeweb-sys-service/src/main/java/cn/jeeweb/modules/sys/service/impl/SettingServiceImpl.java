package cn.jeeweb.modules.sys.service.impl;


import cn.jeeweb.modules.sys.service.ISettingService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(interfaceClass = ISettingService.class)
public class SettingServiceImpl implements ISettingService {
	
}
