package cn.jeeweb.modules.oa.service.impl;

import cn.jeeweb.core.common.service.ICommonService;
import cn.jeeweb.core.common.service.impl.CommonServiceImpl;
import cn.jeeweb.modules.oa.entity.OaNotification;
import cn.jeeweb.modules.oa.mapper.OaNotificationMapper;
import cn.jeeweb.modules.oa.service.IOaNotificationService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;

/**   
 * @Title: 通知公告
 * @Description: 通知公告
 * @author jeeweb
 * @date 2017-06-10 17:15:17
 * @version V1.0   
 *
 */
@Transactional
@Service(interfaceClass = IOaNotificationService.class)
//public class OaNotificationServiceImpl  extends CommonServiceImpl<OaNotificationMapper,OaNotification> implements ICommonService<OaNotification> {
public class OaNotificationServiceImpl  extends CommonServiceImpl<OaNotificationMapper,OaNotification> implements IOaNotificationService {

}
