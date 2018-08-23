<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
    <title>邮件发送模板</title>
    <meta name="decorator" content="form"/>
    <html:css name="bootstrap-fileinput" />
    <html:css name="simditor" />
</head>

<body class="white-bg"  formid="emailTemplateForm">
    <form:form id="emailTemplateForm" modelAttribute="data" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<table  class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
					<td  class="width-15 active text-right">	
		              <label><font color="red">*</font>模版名称:</label>
		            </td>
					<td class="width-35">
						<form:input path="name" htmlEscape="false" class="form-control"  datatype="*"     />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label><font color="red">*</font>模版编码:</label>
		            </td>
					<td class="width-35">
						<form:input path="code" htmlEscape="false" class="form-control"  datatype="*"     />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label><font color="red">*</font>业务类型:</label>
		            </td>
					<td class="width-35">
						<form:select path="businessType" dict="businesstype" datatype="*"  htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label><font color="red">*</font>模版主题:</label>
		            </td>
					<td class="width-35">
						<form:input path="templateSubject" htmlEscape="false" class="form-control" datatype="*"       />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label><font color="red">*</font>模版内容:</label>
		            </td>
					<td colspan="3">
						<form:editor path="templateContent" htmlEscape="false" class="form-control"  datatype="*"     />
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