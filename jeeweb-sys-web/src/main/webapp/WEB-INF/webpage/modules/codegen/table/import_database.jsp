<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="codegen.table.import" /></title>
    <meta name="decorator" content="form"/> 
    
</head>

<body class="white-bg"  formid="importForm">
    <form:form id="importForm" modelAttribute="data" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
		       <tr>
		         <td  class="width-15 active text-right">	
		              <label><font color="red">*</font>表名:</label>
		         </td>
		         <td class="width-35">
		                <form:select path="tableName" class="form-control"  items="${dbTableInfos}" itemLabel="label"   itemValue="label"></form:select>
		             <label class="Validform_checktip"></label>
		         </td>
		         <td  class="width-15 active text-right">	<label><font color="red">*</font>表类型:</label></td>
			     <td  class="width-35" >
			             <form:select path="tableType"  dict="tabletype" defaultvalue="1" class="form-control"></form:select>
			             <label class="Validform_checktip"></label>
			     </td>
		      </tr>
		      
		   </tbody>
	   </table> 
	</form:form>
</body>
</html>