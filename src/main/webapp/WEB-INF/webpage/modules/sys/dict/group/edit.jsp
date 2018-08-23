<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="sys.dict.group.edittitle" /></title>
    <meta name="decorator" content="form"/> 
    
</head>

<body class="white-bg"  formid="groupForm">
    <form:form id="groupForm" modelAttribute="data" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<table  class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
		       <tr>
		         <td  class="width-15 active text-right">	
		              <label><font color="red">*</font>分组名称:</label>
		         </td>
		         <td class="width-35" >
		             <form:input path="name" class="form-control" datatype="*" nullmsg="请输入分组名称！" htmlEscape="false" />
		             <label class="Validform_checktip"></label>
		         </td>
		         <td  class="width-15 active text-right">	<label><font color="red">*</font>分组编码:</label></td>
		         <td  class="width-35" >
		             <form:input path="code" class="form-control"  htmlEscape="false"  datatype="/^[a-zA-Z]+$/" errormsg="分组编码必须为英文！"  nullmsg="请输入分组编码！"/>
		             <label class="Validform_checktip"></label>
		         </td>
		      </tr>
		      <tr>
		         <td  class="width-15 active"><label class="pull-right">备注:</label></td>
		         <td class="width-35" colspan="3" ><form:textarea path="remarks" htmlEscape="false" rows="3" maxlength="200" class="form-control "/></td>
		      </tr>
		   </tbody>
		</table>   
	</form:form>
</body>
</html>