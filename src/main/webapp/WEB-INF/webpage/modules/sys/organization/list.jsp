<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
  <title><spring:message code="sys.organization.title" /></title>
  <meta name="decorator" content="list"/>
</head>
<body title="<spring:message code="sys.organization.title" />">
<grid:grid id="organizationGridId" async="true" treeGrid="true" expandColumn="name"   url="${adminPath}/sys/organization/ajaxTreeList">
	<grid:column label="sys.common.key" hidden="true"   name="id" width="100"/>
	<grid:column label="sys.organization.name"  name="name"  query="true" condition="like"   />
	<grid:column label="sys.organization.remarks"  name="remarks"  />
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