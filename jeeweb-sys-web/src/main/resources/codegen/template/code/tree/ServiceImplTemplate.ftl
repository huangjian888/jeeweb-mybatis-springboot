package ${packageName}<#if moduleName?exists><#if moduleName!=''>.${moduleName}</#if></#if>.service.impl;

import cn.jeeweb.core.common.service.impl.TreeCommonServiceImpl;
import ${packageName}<#if moduleName?exists><#if moduleName!=''>.${moduleName}</#if></#if>.mapper.${entityName?cap_first}Mapper;
import ${packageName}<#if moduleName?exists><#if moduleName!=''>.${moduleName}</#if></#if>.entity.${entityName?cap_first};
import ${packageName}<#if moduleName?exists><#if moduleName!=''>.${moduleName}</#if></#if>.service.I${entityName?cap_first}Service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**   
 * @Title: ${functionName}
 * @Description: ${functionDesc}
 * @author ${functionAuthor}
 * @date ${time}
 * @version V1.0   
 *
 */
@Transactional
@Service("${entityName?uncap_first}Service")
public class ${entityName?cap_first}ServiceImpl  extends TreeCommonServiceImpl<${entityName?cap_first}Mapper,${entityName?cap_first},String> implements  I${entityName?cap_first}Service {

}
