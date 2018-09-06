<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
  <title>邮件发送日志列表</title>
  <meta name="decorator" content="list"/>
</head>
<body title="邮件发送日志">
<grid:grid id="emailSendLogGridId" url="${adminPath}/email/emailsendlog/ajaxList">
	<grid:column label="sys.common.key" hidden="true"   name="id" width="100"/>
    <grid:column label="EMAIL"  name="email" />
    <grid:column label="主题" widht="200" name="subject" query="true"/>
    <grid:column label="发送数据"  name="senddata" />
    <grid:column label="响应时间"  name="responseDate" />
    <grid:column  label="是否发送成功"  name="status" dict="sf"  />
   	<grid:toolbar function="delete"/>
	<grid:toolbar function="search"/>
	<grid:toolbar function="reset"/>
</grid:grid>
</body>
</html>