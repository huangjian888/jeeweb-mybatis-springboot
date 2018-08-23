<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
  <title><spring:message code="sys.role.title" /></title>
  <meta name="decorator" content="list"/>
</head>
<body title="<spring:message code="sys.role.title" />">
<grid:grid id="roleGridId" url="${adminPath}/sys/role/ajaxList">
    <div>
       <form:hidden path="id" nested="false" />
        <form:input path="nametest" nested="false" />
    </div>

	<grid:column label="sys.common.key" hidden="true"   name="id" width="100"/>
	<grid:column label="sys.common.opt"  name="opt" formatter="button" width="100"/>
	<grid:button title="sys.role.authMenu"  groupname="opt" function="updateObj" outclass="btn-info" winwidth="300px" innerclass="fa-plus" url="${adminPath}/sys/role/authMenu" />
	<grid:button groupname="opt" function="delete" />
    <grid:column label="sys.role.name"  name="name"  query="true"  />
    <grid:column label="sys.role.code"  name="code"  query="true"  />
    <grid:column label="sys.role.isSys"  name="isSys"  dict="sf" />
    <grid:column label="sys.role.usable"  name="usable"  dict="sf"/>

	<grid:toolbar function="create"/>
	<grid:toolbar function="update"/>
	<grid:toolbar function="delete"/>

	<grid:toolbar function="search"/>
	<grid:toolbar function="reset"/>
</grid:grid>
</body>
</html>