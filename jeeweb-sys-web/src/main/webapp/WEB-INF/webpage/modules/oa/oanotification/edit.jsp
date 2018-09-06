<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
    <title>通知公告</title>
    <meta name="decorator" content="form"/>
    <html:css name="bootstrap-fileinput" />
    <html:css name="simditor" />
</head>

<body class="white-bg"  formid="oaNotificationForm">
    <form:form id="oaNotificationForm" modelAttribute="data"   method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<table  class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
					<td  class="width-15 active text-right">	
		              <label><font color="red">*</font>标题:</label>
		            </td>
					<td class="width-35">
						<form:input path="title" htmlEscape="false" class="form-control"  datatype="*"    />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
		      	<tr>
					<td  class="width-15 active text-right">	
		              <label><font color="red">*</font>内容:</label>
		            </td>
					<td class="width-35">
						<form:textarea path="content" rows="4" htmlEscape="false" class="form-control"  datatype="*"    />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label><font color="red">*</font>是否发布:</label>
		            </td>
					<td class="width-35">
						<form:radiobuttons path="status" htmlEscape="false" class="form-control"  dict="sf"  datatype="*"  cssClass="i-checks required"   />
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