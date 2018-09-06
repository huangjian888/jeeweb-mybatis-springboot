<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
  <title><spring:message code="sys.log.title" /></title>
  <meta name="decorator" content="list"/>
</head>
<body title="<spring:message code="sys.log.title" />">
<grid:grid id="logGroupGridId" url="${adminPath}/sys/log/ajaxList" sortname="createDate" sortorder="desc">
	<grid:column label="sys.common.key" hidden="true"   name="id" width="100"/>
	<grid:column label="操作菜单"  name="title" />
    <grid:column label="操作用户名字"  name="createBy.realname" width="100"/>
    <grid:column label="操作用户帐号"  name="createBy.username"  width="80"/>
    <grid:column label="URI"  name="requestUri"  />
    <grid:column label="提交方式"  name="method"   width="60"/>
    <grid:column label="操作者IP"  name="remoteAddr" />
    <grid:column label="操作时间"  name="createDate" query="true" queryMode="date" condition="between"  dateformat='yyyy-MM-dd hh:mm:ss'/>
 	<grid:toolbar   function="delete" />
	
	<grid:toolbar  function="search"  />
	<grid:toolbar  function="reset" />
</grid:grid>
</body>
</html>