package cn.jeeweb.modules.codegen.service.impl;

import cn.jeeweb.core.common.service.impl.CommonServiceImpl;
import cn.jeeweb.modules.codegen.entity.Scheme;
import cn.jeeweb.modules.codegen.mapper.SchemeMapper;
import cn.jeeweb.modules.codegen.service.ISchemeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**   
 * @Title: 生成方案
 * @Description: 代码生成方案
 * @author jeeweb
 * @date 2017-05-29 21:17:42
 * @version V1.0   
 *
 */
@Transactional
@Service("schemeService")
public class SchemeServiceImpl  extends CommonServiceImpl<SchemeMapper,Scheme> implements  ISchemeService {

}
