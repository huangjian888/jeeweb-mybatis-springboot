<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
    <title>计划任务</title>
    <meta name="decorator" content="form"/> 
    
</head>

<body class="white-bg"  formid="schedulejobForm">
    <form:form id="schedulejobForm" modelAttribute="data" action="${adminPath}/task/schedulejob/saveScheduleJob" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<form:hidden path="jobStatus" defaultValue="0"/>
		<table  class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
		       <tr>
		         <td  class="width-15 active text-right">	
		              <label><font color="red">*</font>任务名称:</label>
		         </td>
		         <td class="width-35" >
		             <form:input path="jobName" class="form-control " datatype="*" nullmsg="请输入任务名称！" htmlEscape="false" />
		             <label class="Validform_checktip"></label>
		         </td>
		         <td  class="width-15 active text-right">	
		          	<label><font color="red">*</font>任务分组:</label>
		         </td>
		         <td  class="width-35" >
		             <form:input path="jobGroup" class="form-control"  htmlEscape="false"  datatype="*"  nullmsg="请输入任务分组！"/>
		             <label class="Validform_checktip"></label>
		         </td>
		      </tr>
		      <tr>
		         <td  class="width-15 active text-right">	
		              <label><font color="red">*</font>类路径:</label>
		         </td>
		         <td class="width-35" >
		             <form:input path="beanClass" class="form-control "   nullmsg="请输入类路径！" htmlEscape="false" />
		             <label class="Validform_checktip"></label>
		         </td>
		         <td  class="width-15 active text-right">	
		          	<label><font color="red">*</font>方法名:</label>
		         </td>
		         <td  class="width-35" >
		             <form:input path="methodName" class="form-control"  htmlEscape="false"     nullmsg="请输入方法名！"/>
		             <label class="Validform_checktip"></label>
		         </td>
		      </tr>
		       <tr>
		         <td  class="width-15 active text-right">	
		          	<label><font color="red">*</font>SpringBean:</label>
		         </td>
		         <td  class="width-35" >
		             <form:input path="springBean" class="form-control"  htmlEscape="false"   nullmsg="请输入角色编码！"/>
		             <label class="Validform_checktip"></label>
		         </td>
		         <td  class="width-15 active text-right">	
		              <label><font color="red">*</font>cron表达式:</label>
		         </td>
		         <td class="width-35" >
		             <form:input path="cronExpression" class="form-control " datatype="*" nullmsg="请输入角色名称！" htmlEscape="false" />
		             <label class="Validform_checktip"></label>
		         </td>
		      </tr>
		      <tr>
				<td class="active">
				   <label class="pull-right"><font color="red">*</font>是否同步:</label>
				</td>
				<td colpsan="3">
				     <form:radiobuttons path="isConcurrent"   dict="sf" defaultValue="1"  htmlEscape="false" cssClass="i-checks required" />
				</td>
			  </tr>
			  <tr>
		         <td  class="width-15 active text-right">	
		              <label>描述:</label>
		         </td>
		         <td class="width-35" colspan="3" >
		              <form:textarea path="description" htmlEscape="false" rows="3" maxlength="200" class="form-control "/>
		         </td>
		      </tr>
		   </tbody>
		</table>   
	</form:form>
</body>
</html>