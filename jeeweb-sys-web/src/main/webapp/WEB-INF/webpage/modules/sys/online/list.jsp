<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
  <title><spring:message code="sys.online.title" /></title>
  <meta name="decorator" content="list"/>
</head>
<body title="<spring:message code="sys.online.title" />">
<grid:grid id="onlineGridId"  datatype="local" datas="${onlineSessionList}" sortname="startTimestamp" sortorder="desc">
	<grid:column label="sys.common.key" hidden="true"   name="id" width="100"/>
    <grid:column label="用户"  name="username"   />
    <grid:column label="用户主机IP"  name="host"  />
    <grid:column label="系统主机IP"  name="systemHost"  />
    <grid:column label="登录时间"  name="startTimestamp" width="140"  queryMode="date" condition="between" dateformat='yyyy-MM-dd hh:mm:ss'/>
    <grid:column label="最后访问时间"  name="lastAccessTime"  width="140"  dateformat='yyyy-MM-dd hh:mm:ss' />
    <grid:column label="状态"  name="status" dict="onlinestatus" />
    <grid:column label="User-Agent"  name="userAgent"  />
    <grid:column label="用户会话ID"  name="id"  />
 
	<grid:toolbar title="强制退出" btnclass="btn-danger" icon="fa-trash-o" function="toolbarSelectConfirm"  url="${adminPath}/sys/online/forceLogout"  tipMsg="您确定要强制退出这些信息么，请谨慎操作！"/>
</grid:grid>
</body>
</html>