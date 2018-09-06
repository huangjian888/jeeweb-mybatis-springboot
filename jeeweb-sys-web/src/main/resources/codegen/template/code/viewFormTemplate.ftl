<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
    <title>${functionName}</title>
    <meta name="decorator" content="form"/>
    <html:css name="bootstrap-fileinput" />
    <html:css name="simditor" />
</head>

<body class="white-bg"  formid="${entityName?uncap_first}Form">
    <form:form id="${entityName?uncap_first}Form" modelAttribute="data" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<table  class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
	    <#assign index=0 />
		<#list columns as column>
			<#if column.isForm?? && column.isForm>
			<#assign index=index+1 />
			<#if index%2==1> 
				<tr>
			</#if>
					<td  class="width-15 active text-right">	
		              <label><#if column.nullable??&&!column.nullable><font color="red">*</font></#if><#if column.remarks??&&column.remarks!="">${column.remarks}<#else>${column.javaField}</#if>:</label>
		            </td>
					<td class="width-35">
			<#if column.formType == "input">
						<form:input path="${column.javaField}" htmlEscape="false" class="form-control"  <#if column.regexValid??&&column.regexValid!="">datatype="${column.regexValid}"<#else><#if column.validType??&&column.validType!="">datatype="${column.validType}<#if column.validType=="s"||column.validType=="n"><#if column.minSize??>${column.minSize}<#if column.maxSize??>-${column.maxSize}<#else>-${column.columnSize}</#if></#if></#if>"</#if></#if>  <#if column.nullmsg??&&column.nullmsg!="">nullmsg="${column.nullmsg}"</#if>  />
			<#elseif column.formType == "textarea">
						<form:textarea path="${column.javaField}" rows="4" htmlEscape="false" class="form-control"  <#if column.regexValid??&&column.regexValid!="">datatype="${column.regexValid}"<#else><#if column.validType??&&column.validType!="">datatype="${column.validType}<#if column.validType=="s"||column.validType=="n"><#if column.minSize??>${column.minSize}<#if column.maxSize??>-${column.maxSize}<#else>-${column.columnSize}</#if></#if></#if>"</#if></#if>  <#if column.nullmsg??&&column.nullmsg!="">nullmsg="${column.nullmsg}"</#if>  />
			<#elseif column.formType == "radiobox">
						<form:radiobuttons path="${column.javaField}" htmlEscape="false" class="form-control"  <#if column.dictGroup??&&column.dictGroup!="">dict="${column.dictGroup}"</#if>  <#if column.regexValid??&&column.regexValid!="">datatype="${column.regexValid}"<#else><#if column.validType??&&column.validType!="">datatype="${column.validType}<#if column.validType=="s"||column.validType=="n"><#if column.minSize??>${column.minSize}<#if column.maxSize??>-${column.maxSize}<#else>-${column.columnSize}</#if></#if></#if>"</#if></#if>  <#if column.nullmsg??&&column.nullmsg!="">nullmsg="${column.nullmsg}"</#if>  cssClass="i-checks required"/>
			<#elseif column.formType == "select">
						<form:select path="${column.javaField}" htmlEscape="false" class="form-control"  <#if column.dictGroup??&&column.dictGroup!="">dict="${column.dictGroup}"</#if>  <#if column.regexValid??&&column.regexValid!="">datatype="${column.regexValid}"<#else><#if column.validType??&&column.validType!="">datatype="${column.validType}<#if column.validType=="s"||column.validType=="n"><#if column.minSize??>${column.minSize}<#if column.maxSize??>-${column.maxSize}<#else>-${column.columnSize}</#if></#if></#if>"</#if></#if>  <#if column.nullmsg??&&column.nullmsg!="">nullmsg="${column.nullmsg}"</#if>  />
			<#elseif column.formType == "checkbox">
						<form:checkboxes path="${column.javaField}" htmlEscape="false" class="form-control"  <#if column.dictGroup??&&column.dictGroup!="">dict="${column.dictGroup}"</#if>  <#if column.regexValid??&&column.regexValid!="">datatype="${column.regexValid}"<#else><#if column.validType??&&column.validType!="">datatype="${column.validType}<#if column.validType=="s"||column.validType=="n"><#if column.minSize??>${column.minSize}<#if column.maxSize??>-${column.maxSize}<#else>-${column.columnSize}</#if></#if></#if>"</#if></#if>  <#if column.nullmsg??&&column.nullmsg!="">nullmsg="${column.nullmsg}"</#if>  />
			<#elseif column.formType == "dateselect">
						<form:input path="${column.javaField}" htmlEscape="false" class="form-control layer-date" placeholder="YYYY-MM-DD hh:mm:ss" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})"   <#if column.regexValid??&&column.regexValid!="">datatype="${column.regexValid}"<#else><#if column.validType??&&column.validType!="">datatype="${column.validType}<#if column.validType=="s"||column.validType=="n"><#if column.minSize??>${column.minSize}<#if column.maxSize??>-${column.maxSize}<#else>-${column.columnSize}</#if></#if></#if>"</#if></#if>  <#if column.nullmsg??&&column.nullmsg!="">nullmsg="${column.nullmsg}"</#if>  />
			<#elseif column.formType == "editor">
						<form:editor path="${column.javaField}" htmlEscape="false" class="form-control"  <#if column.regexValid??&&column.regexValid!="">datatype="${column.regexValid}"<#else><#if column.validType??&&column.validType!="">datatype="${column.validType}<#if column.validType=="s"||column.validType=="n"><#if column.minSize??>${column.minSize}<#if column.maxSize??>-${column.maxSize}<#else>-${column.columnSize}</#if></#if></#if>"</#if></#if>  <#if column.nullmsg??&&column.nullmsg!="">nullmsg="${column.nullmsg}"</#if>  />
			<#elseif column.formType == "fileinput">
						<form:fileinput path="${column.javaField}" htmlEscape="false" class="form-control"  <#if column.regexValid??&&column.regexValid!="">datatype="${column.regexValid}"<#else><#if column.validType??&&column.validType!="">datatype="${column.validType}<#if column.validType=="s"||column.validType=="n"><#if column.minSize??>${column.minSize}<#if column.maxSize??>-${column.maxSize}<#else>-${column.columnSize}</#if></#if></#if>"</#if></#if>  <#if column.nullmsg??&&column.nullmsg!="">nullmsg="${column.nullmsg}"</#if>  />
			<#elseif column.formType == "avatarinput">
						<form:fileinput showType="avatar" fileInputWidth="100px"  fileInputHeight="100px"  path="${column.javaField}" htmlEscape="false" class="form-control"  <#if column.regexValid??&&column.regexValid!="">datatype="${column.regexValid}"<#else><#if column.validType??&&column.validType!="">datatype="${column.validType}<#if column.validType=="s"||column.validType=="n"><#if column.minSize??>${column.minSize}<#if column.maxSize??>-${column.maxSize}<#else>-${column.columnSize}</#if></#if></#if>"</#if></#if>  <#if column.nullmsg??&&column.nullmsg!="">nullmsg="${column.nullmsg}"</#if>  />
			</#if>
						<label class="Validform_checktip"></label>
					</td>
			<#if index%2==0> 
				</tr>
			</#if>
			</#if>
		</#list>
		<#if index%2==1 > 
					<td class="width-15 active text-right"></td>
		   			<td class="width-35" ></td>
		  		</tr>
		</#if>
		      
		   </tbody>
		</table>   
	</form:form>
<html:js name="bootstrap-fileinput" />
<html:js name="simditor" />
</body>
</html>