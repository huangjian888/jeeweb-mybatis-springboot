<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
  <title>邮件发送模板列表</title>
  <meta name="decorator" content="list"/>
</head>
<body title="邮件发送模板">
<grid:grid id="emailTemplateGridId" url="${adminPath}/email/emailtemplate/ajaxList">
    <grid:column label="sys.common.key" hidden="true"   name="id" width="100"/>
	<grid:column label="sys.common.opt"  name="opt" formatter="button" width="100"/>
	<grid:button groupname="opt" function="delete" />
    <grid:column label="模版名称"  name="name" />
    <grid:column label="模版编码"  name="code" />
    <grid:column label="业务类型"  name="businessType"  dict="businesstype"/>
    <grid:column label="模版主题"  name="templateSubject" />
    <grid:column label="创建时间"  name="createDate" />
	<grid:toolbar function="create"/>
	<grid:toolbar function="update"/>
	<grid:toolbar function="delete"/>
	
	<grid:toolbar function="search"/>
	<grid:toolbar function="reset"/>
</grid:grid>
</body>
</html>