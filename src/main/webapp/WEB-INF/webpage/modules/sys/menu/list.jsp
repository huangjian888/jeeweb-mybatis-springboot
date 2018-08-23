<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
  <title><spring:message code="sys.menu.title" /></title>
  <meta name="decorator" content="list"/>
</head>
<body title="<spring:message code="sys.menu.title" />">
<grid:grid id="menuGridId" async="true" treeGrid="true"  expandColumn="name"  sortname="sort" url="${adminPath}/sys/menu/ajaxTreeList">
	<grid:column label="sys.common.key" hidden="true"   name="id" />
	<grid:column label="sys.menu.name"  name="name"  query="true" condition="like"/>
	<grid:column label="sys.menu.url"  name="url"  />
    <grid:column label="sys.menu.permission"  name="permission"  />
    <grid:column label="sys.menu.isshow"  name="isshow" dict="sf"/>
    
    <grid:column label="sys.common.opt"  name="opt" formatter="button" width="100"/>
	<grid:button   groupname="opt" function="delete" />
    
	<grid:toolbar  function="create"/>
	<grid:toolbar  function="update"/>
	<grid:toolbar  function="delete"/>
	<grid:toolbar  function="search"/>
	<grid:toolbar  function="reset"/>
</grid:grid>
</body>
</html>