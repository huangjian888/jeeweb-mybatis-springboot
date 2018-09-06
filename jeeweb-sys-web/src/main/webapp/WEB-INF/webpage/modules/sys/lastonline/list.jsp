<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
  <title>用户最后在线情况列表</title>
  <meta name="decorator" content="list"/>
</head>
<body title="用户最后在线情况">
<grid:grid id="userLastOnlineGridId" url="${adminPath}/sys/lastOnline/ajaxList">
	<grid:column label="sys.common.key" hidden="true"   name="id" width="100"/>
    <grid:column label="用户"  name="username" width="70"/>
    <grid:column label="userId"  name="userId" hidden="true"/>
    <grid:column label="uid"  name="uid" hidden="true" />
    <grid:column label="登录次数"  name="loginCount" width="80"/>
    <grid:column label="登录总时长"  name="totalOnlineTime" />
    <grid:column label="用户主机IP"  name="host" />
    <grid:column label="User-Agent"  name="userAgent" />
    <grid:column label="系统主机IP"  name="systemHost" />
    <grid:column label="最后停止时间"  name="lastStopTimestamp" />
    <grid:column label="最后登录时间"  name="lastLoginTimestamp" />
	<grid:toolbar  function="search"  />
	<grid:toolbar  function="reset" />
</grid:grid>
</body>
</html>