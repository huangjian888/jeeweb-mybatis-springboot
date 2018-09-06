<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
  <title>短信发送日志列表</title>
  <meta name="decorator" content="list"/>
</head>
<body title="短信发送日志">
<grid:grid id="smsSendLogGridId" url="${adminPath}/sms/smssendlog/ajaxList">
	<grid:column label="sys.common.key" hidden="true"   name="id" width="100"/>
	<grid:column label="业务类型"  name="businessType"  width="80" query="true"  queryModel="select"  condition="eq"   dict="businesstype"/>
    <grid:column label="联系电话"  name="phone"  query="true"  width="120" queryModel="input"  condition="like" />
    <grid:column label="模板ID"  name="templateId"  query="true" width="120" queryModel="input"  condition="like" />
    <grid:column label="模板内容"  name="templateContent"  query="true" width="300"  queryModel="input"  condition="like" />
    <grid:column label="发送数据"  name="senddata" width="100" query="true"  queryModel="input"  condition="eq" />
    <grid:column label="是否发送成功"  name="status" dict="sf"  query="true"  queryModel="input"  condition="eq" />
    <grid:column label="响应消息ID"  width="120" name="smsid" />
    <grid:column label="返回码"  name="code" hidden="true" />
    <grid:column label="返回消息"  name="msg" />
    <grid:column label="响应时间"  name="responseDate" />
	<grid:toolbar function="delete"/>
	
	<grid:toolbar function="search"/>
	<grid:toolbar function="reset"/>
</grid:grid>
</body>
</html>