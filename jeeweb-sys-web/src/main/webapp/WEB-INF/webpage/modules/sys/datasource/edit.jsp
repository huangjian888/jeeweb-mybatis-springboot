<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="sys.datasource.edittitle" /></title>
    <meta name="decorator" content="form"/> 
    
</head>

<body class="white-bg"  formid="datasourceForm">
    <form:form id="datasourceForm" modelAttribute="data" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<table  class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
		       <tr>
		         <td  class="width-15 active text-right">	
		              <label><font color="red">*</font>数据库关键字:</label>
		         </td>
		         <td class="width-35" >
		             <form:input path="dbKey" class="form-control " datatype="/^[a-zA-Z 0-9]+$/" errormsg="数据库关键字必须为英文" htmlEscape="false" />
		             <label class="Validform_checktip"></label>
		         </td>
		         <td  class="width-15 active text-right">	
		          	<label><font color="red">*</font>数据库类型:</label>
		         </td>
		         <td  class="width-35" >
		             <form:select path="dbType" dict="dbtype" class="form-control"  htmlEscape="false"  datatype="*"  nullmsg="请输入数据库类型！"/>
		             <label class="Validform_checktip"></label>
		         </td>
		      </tr>
		      <tr>
		         <td  class="width-15 active text-right">	
		              <label><font color="red">*</font>驱动类:</label>
		         </td>
		         <td class="width-35" colspan="3">
		             <form:input path="driverClass" class="form-control " datatype="*" nullmsg="请输入驱动类！" htmlEscape="false" />
		             <label class="Validform_checktip"></label>
		         </td>
		      </tr>
		      <tr>
		         <td  class="width-15 active text-right">	
		          	<label><font color="red">*</font>数据源地址:</label>
		         </td>
		         <td  class="width-35"  colspan="3">
		             <form:input path="url" class="form-control " datatype="*" nullmsg="请输入数据源地址！" htmlEscape="false" />
		             <label class="Validform_checktip"></label>
		         </td>
		      </tr>
		      <tr>
		         <td  class="width-15 active text-right">	
		              <label><font color="red">*</font>数据库名称:</label>
		         </td>
		         <td class="width-35" >
		             <form:input path="dbName" class="form-control " datatype="*" nullmsg="请输入驱动类！" htmlEscape="false" />
		             <label class="Validform_checktip"></label>
		         </td>
		         <td  class="width-15 active text-right">	
		          	<label><font color="red">*</font>数据库用户名:</label>
		         </td>
		         <td  class="width-35" >
		             <form:input path="dbUser" class="form-control " datatype="*" nullmsg="请输入数据源地址！" htmlEscape="false" />
		             <label class="Validform_checktip"></label>
		         </td>
		      </tr>
		       <tr>
		         <td  class="width-15 active text-right">	
		              <label><font color="red">*</font>数据库密码:</label>
		         </td>
		         <td class="width-35" >
		             <form:input path="dbPassword" class="form-control " datatype="*" nullmsg="请输入驱动类！" htmlEscape="false" />
		             <label class="Validform_checktip"></label>
		         </td>
		         <td  class="width-15 active text-right">	
		              <label>描述:</label>
		         </td>
		         <td class="width-35">
		              <form:textarea path="description" htmlEscape="false" rows="3" maxlength="200" class="form-control "/>
		         </td>
		      </tr>
		   </tbody>
		</table>   
	</form:form>
	<script type="text/javascript">
		$(function(){
			$('#dbType').change(function(){
				var dbType = $("#dbType").val();
				$.ajax({
					type: "POST",
					url: "${adminPath}/sys/datasource/dataSourceParameter",
					data: "dbType=" + dbType,
					success: function(data){
						var driverData=data.data;
						$('#driverClass').val(driverData.driverClass);
						$('#url').val(driverData.url);
					}
				});
			});
		});
	</script>
</body>
</html>