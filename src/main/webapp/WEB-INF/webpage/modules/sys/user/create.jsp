<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><spring:message code="sys.user.createuser" /></title>
     <meta name="decorator" content="form"/>
	 
</head>

<body class="white-bg"  formid="userForm">
     <form:form id="userForm" modelAttribute="data" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<table  class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
		       <tr>
		         <td  class="width-15 active text-right">	<label><font color="red">*</font>用户名:</label></td>
		         <td  class="width-35" >
		             <form:input path="username" class="form-control" ajaxurl="${adminPath}/sys/user/validate"  validErrorMsg="用户名重复"  htmlEscape="false"  datatype="*"  nullmsg="请输入用户名！"/>
		             <label class="Validform_checktip"></label>
		         </td>
		          <td  class="width-15 active text-right">	
		              <label><font color="red">*</font>姓名:</label>
		         </td>
		         <td class="width-35" >
		             <form:input path="realname" class="form-control " datatype="*" nullmsg="请输入姓名！" validErrorMsg="用户名重复" htmlEscape="false" />
		             <label class="Validform_checktip"></label>
		         </td>
		      </tr>
		      <tr>
		         <td  class="width-15 active text-right">	
		              <label><font color="red">*</font>邮箱:</label>
		         </td>
		         <td class="width-35" >
		             <form:input path="email" class="form-control" ajaxurl="${adminPath}/sys/user/validate"   datatype="e" nullmsg="请输入邮箱！"  htmlEscape="false" />
		             <label class="Validform_checktip"></label>
		         </td>
		         <td  class="width-15 active text-right">	
		           	 <label><font color="red">*</font>联系电话:</label>
		         </td>
		         <td  class="width-35" >
		             <form:input path="phone" class="form-control" ajaxurl="${adminPath}/sys/user/validate"  htmlEscape="false"  datatype="m"  nullmsg="请输入用户名！"/>
		             <label class="Validform_checktip"></label>
		         </td>
		      </tr>
		      <tr>
		         <td  class="width-15 active text-right">	
		              <label><font color="red">*</font>密码:</label>
		         </td>
		         <td class="width-35" >
		             <input type="password" value="" name="password"  class="form-control" datatype="*6-16" nullmsg="请设置密码！" errormsg="密码范围在6~16位之间！" />
		             <label class="Validform_checktip"></label>
		         </td>
		         <td  class="width-15 active text-right">	<label><font color="red">*</font>确认密码:</label></td>
		         <td  class="width-35" >
		             <input type="password" value="" name="userpassword2" class="form-control" datatype="*" recheck="password" nullmsg="请再输入一次密码！" errormsg="您两次输入的账号密码不一致！" />
		             <label class="Validform_checktip"></label>
		         </td>
		      </tr>
		      <tr>
		         <td class="active"><label class="pull-right"><font color="red">*</font>用户角色:</label></td>
		         <td>
		         	<form:checkboxes path="roleIdList" nested="false" items="${allRoles}" itemLabel="name" itemValue="id" htmlEscape="false" cssClass="i-checks required"/>
		          
		         </td>
		      </tr>
		      <tr>
				<td class="width-15 active"><label class="pull-right">组织机构:</label></td>
				<td colspan="3">
				   <form:treeselect title="请选择组织机构" path="organizationIds"  nested="false"  dataUrl="${adminPath}/sys/organization/treeData" labelName="parentname" labelValue="${organizationNames}" multiselect="true" />	   
				</td>
		      </tr>
		     
		   </tbody>
		   </table>   
	</form:form>
	
</body>
</html>