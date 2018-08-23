<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><spring:message code="sys.user.modifypwd" /></title>
     <meta name="decorator" content="form"/>
	 
</head>

<body class="white-bg"  formid="userForm">
     <form:form id="userForm" modelAttribute="data"  method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<table  class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
		       <tr>
		         <td  class="width-15 active text-right">	
		              <label>姓名:</label>
		         </td>
		         <td class="width-35" >
		             ${data.realname}
		         </td>
		         <td  class="width-15 active text-right">用户名:</label></td>
		         <td  class="width-35" >
		              ${data.username}
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
		   </tbody>
		   </table>   
	</form:form>
</body>
</html>