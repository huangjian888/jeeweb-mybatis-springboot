package cn.jeeweb.modules.sys.service.impl;

import cn.jeeweb.core.common.service.impl.CommonServiceImpl;
import cn.jeeweb.modules.sys.entity.DataSource;
import cn.jeeweb.modules.sys.mapper.DataSourceMapper;
import cn.jeeweb.modules.sys.service.IDataSourceService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;

/**   
 * @Title: 数据源
 * @Description: 数据源
 * @author jeeweb
 * @date 2017-05-10 12:01:57
 * @version V1.0   
 *
 */
@Transactional
@Service(interfaceClass = IDataSourceService.class)
public class DataSourceServiceImpl extends CommonServiceImpl<DataSourceMapper,DataSource> implements IDataSourceService {

}
