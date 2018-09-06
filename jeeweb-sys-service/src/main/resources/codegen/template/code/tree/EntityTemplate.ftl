package ${packageName}<#if moduleName?exists><#if moduleName!=''>.${moduleName}</#if></#if>.entity;

import cn.jeeweb.core.common.entity.TreeEntity;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
<#list importTypes as importType>
import ${importType};
</#list>


/**   
 * @Title: ${functionName}
 * @Description: ${functionDesc}
 * @author ${functionAuthor}
 * @date ${time}
 * @version V1.0   
 *
 */
@TableName("${tableName}")
@SuppressWarnings("serial")
public class ${entityName?cap_first} extends TreeEntity<${entityName?cap_first}> {
	
	<#list attributeInfos as attributeInfo>
    <#if attributeInfo.name!='id'&&attributeInfo.name!='name'&& attributeInfo.name!='parentId'&& attributeInfo.name!='parentIds'>
    /**${attributeInfo.remarks}*/
	@TableField(value = "${attributeInfo.dbName}"<#if !attributeInfo.isBaseType>,el="${attributeInfo.name}.id"</#if><#if attributeInfo.name??&&(attributeInfo.name='createBy'||attributeInfo.name='createDate')>,fill = FieldFill.INSERT</#if><#if attributeInfo.name??&&(attributeInfo.name='updateBy'||attributeInfo.name='updateDate')>,fill = FieldFill.UPDATE</#if>)
	private <#if attributeInfo.type=='this'>${entityName?cap_first}<#else>${attributeInfo.type}</#if> ${attributeInfo.name};
	</#if>
	</#list>
	
	<#list attributeInfos as attributeInfo>
	 <#if attributeInfo.name!='id'&&attributeInfo.name!='name'&& attributeInfo.name!='parentId'&& attributeInfo.name!='parentIds'>
	/**
	 * 获取  ${attributeInfo.name}
	 *@return: ${attributeInfo.type}  ${attributeInfo.remarks}
	 */
	public <#if attributeInfo.type=='this'>${entityName?cap_first}<#else>${attributeInfo.type}</#if> get${attributeInfo.name?cap_first}(){
		return this.${attributeInfo.name};
	}

	/**
	 * 设置  ${attributeInfo.name}
	 *@param: ${attributeInfo.name}  ${attributeInfo.remarks}
	 */
	public void set${attributeInfo.name?cap_first}(<#if attributeInfo.type=='this'>${entityName?cap_first}<#else>${attributeInfo.type}</#if> ${attributeInfo.name}){
		this.${attributeInfo.name} = ${attributeInfo.name};
	}
	</#if>
	</#list>

}