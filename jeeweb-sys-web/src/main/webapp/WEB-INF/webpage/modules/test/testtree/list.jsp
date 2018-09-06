<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
  <title>测试树列表</title>
  <meta name="decorator" content="list"/>
</head>
<body title="测试树">
<grid:grid id="testTreeGridId" async="true" treeGrid="true"  expandColumn="name"  url="${adminPath}/test/testtree/ajaxTreeList">
	<grid:column label="sys.common.key" hidden="true"   name="id" width="100"/>
    <grid:column label="机构名称"  name="name" />
    <grid:column label="sys.common.opt"  name="opt" formatter="button" width="100"/>
	<grid:button groupname="opt" function="delete"/>
	<grid:toolbar function="create"/>
	<grid:toolbar function="update"/>
	<grid:toolbar function="delete"/>
	
	<grid:toolbar function="search"/>
	<grid:toolbar function="reset"/>
</grid:grid>
</body>
</html>