<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="sys.organization.edittitle" /></title>
    <meta name="decorator" content="form"/> 
    
</head>

<body class="white-bg"  formid="organizationForm">
     <form:form id="organizationForm" modelAttribute="data"  method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<table  class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
		       <tr>
		          <td class="width-15 active"><label class="pull-right">上级机构:</label></td>
		         <td class="width-35">
		            <form:treeselect title="请选择上级机构" path="parentId" dataUrl="${adminPath}/sys/organization/treeData" labelName="parentname" labelValue="${data.parent.name}" />	   
				  </td>
		          <td  class="width-15 active text-right">	
		              <label><font color="red">*</font>机构名称:</label>
		         </td>
		         <td class="width-35" >
		             <form:input path="name" class="form-control " datatype="*" nullmsg="请输入部门名称！" htmlEscape="false" />
		             <label class="Validform_checktip"></label>
		         </td>
		      </tr>
		       
		       <tr>
		         <td  class="width-15 active text-right">	
		              <label>备注:</label>
		         </td>
		         <td class="width-35" colspan="3" >
		              <form:textarea path="remarks" htmlEscape="false" rows="3" maxlength="200" class="form-control "/>
		         </td>
		      </tr>
		  
		   </tbody>
		   </table>   
	</form:form>
	 
</body>
</html>