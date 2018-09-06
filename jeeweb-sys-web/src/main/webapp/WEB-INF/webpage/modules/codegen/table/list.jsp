<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
  <title><spring:message code="codegen.table.title" /></title>
  <meta name="decorator" content="list"/>
</head>
<body title="<spring:message code="codegen.table.title" />">
<grid:grid id="codegenGrid"  url="${adminPath}/codegen/table/ajaxList">
    <grid:column label="sys.common.key" hidden="true"   name="id"/>
    <grid:column label="codegen.table.tabletype"   width="60" name="tableType"   dict="tabletype"  query="true" queryMode="select"  />
    <grid:column label="codegen.table.table.name"  width="120"  name="tableName"  query="true" />
	<grid:column label="codegen.table.remarks"  name="remarks" />
	<grid:column label="codegen.table.sync.database"  width="80" dict="sf" formatterClass="0:label label-danger;1:label label-success" name="syncDatabase" />
	
	<grid:column label="sys.common.opt"  name="opt" formatter="button" width="300"/>
	<grid:button title="sys.common.remove"  groupname="opt" function="rowConfirm" tipMsg="确认要移除该条记录吗？" outclass="btn-warning" innerclass="fa-remove" url="${adminPath}/codegen/table/{id}/remove" />
	<grid:button groupname="opt" function="delete" tipMsg="确认要删除该条记录,删除会删除对应的表结构，请谨慎操作！" />
	<grid:button title="codegen.table.sync.database"  groupname="opt" function="rowConfirm"  tipMsg="确认要强制同步数据库吗？同步数据库将删除所有数据重新建表！" outclass="btn-info" innerclass="fa-database"  url="${adminPath}/codegen/table/{id}/syncDatabase" />
	<grid:toolbar  function="create"  winwidth = "1100px"/>
	<grid:toolbar  function="update"  winwidth = "1100px"/>
	<grid:toolbar title="codegen.table.import" btnclass="btn-warning" icon="fa-database" function="createDialog" url="${adminPath}/codegen/table/importDatabase"  />
	<grid:toolbar title="codegen.table.gen" btnclass="btn-info" icon="fa-file-code-o" function="updateDialog" url="${adminPath}/codegen/table/{id}/generateCode"  />
	<grid:toolbar title="codegen.table.createmenu" btnclass="btn-warning" icon="fa-anchor" function="updateDialog" url="${adminPath}/codegen/table/{id}/createMenu"  />
	
	<grid:toolbar  function="search"/>
	<grid:toolbar  function="reset"/>
</grid:grid>
</body>
</html>