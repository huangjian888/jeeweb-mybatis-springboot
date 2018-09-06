package cn.jeeweb.modules.sys.service.impl;

import cn.jeeweb.core.common.service.impl.CommonServiceImpl;
import cn.jeeweb.modules.sys.entity.UserLastOnline;
import cn.jeeweb.modules.sys.mapper.UserLastOnlineMapper;
import cn.jeeweb.modules.sys.service.IUserLastOnlineService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;

/**   
 * @Title: 最后在线情况
 * @Description: 最后在线情况
 * @author jeeweb
 * @date 2017-05-15 08:18:21
 * @version V1.0   
 *
 */
@Transactional
@Service(interfaceClass = IUserLastOnlineService.class)
public class UserLastOnlineServiceImpl extends CommonServiceImpl<UserLastOnlineMapper,UserLastOnline> implements IUserLastOnlineService {

}
