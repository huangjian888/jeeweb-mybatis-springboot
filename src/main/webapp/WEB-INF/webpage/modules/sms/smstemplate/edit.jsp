<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
    <title>短信模版</title>
    <meta name="decorator" content="form"/>
    <html:css name="bootstrap-fileinput" />
    <html:css name="simditor" />
</head>

<body class="white-bg"  formid="smsTemplateForm">
    <form:form id="smsTemplateForm" modelAttribute="data"  method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<table  class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
					<td  class="width-15 active text-right">	
		              <label><font color="red">*</font>模版名称:</label>
		            </td>
					<td class="width-35">
						<form:input path="name" htmlEscape="false" class="form-control"  datatype="*"    />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label><font color="red">*</font>模版编码:</label>
		            </td>
					<td class="width-35">
						<form:input path="code" htmlEscape="false" class="form-control"  datatype="*"    />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label><font color="red">*</font>业务类型:</label>
		            </td>
					<td class="width-35">
						<form:select path="businessType" htmlEscape="false" class="form-control"  dict="businesstype"  datatype="*"    />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label><font color="red">*</font>模版ID:</label>
		            </td>
					<td class="width-35">
						<form:input path="templateId" htmlEscape="false" class="form-control"  datatype="*"    />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label><font color="red">*</font>模版内容:</label>
		            </td>
					<td  colspan="3">
						<form:textarea path="templateContent" rows="4" htmlEscape="false" class="form-control"  datatype="*"    />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
		      
		   </tbody>
		</table>   
	</form:form>
<html:js name="bootstrap-fileinput" />
<html:js name="simditor" />
</body>
</html>