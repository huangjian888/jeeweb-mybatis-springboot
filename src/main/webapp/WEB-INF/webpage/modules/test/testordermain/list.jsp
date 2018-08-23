<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
  <title>测试主表列表</title>
  <meta name="decorator" content="list"/>
</head>
<body title="测试主表">
<grid:grid id="testOrderMainGridId" url="${adminPath}/test/testordermain/ajaxList">
	<grid:column label="sys.common.key" hidden="true"   name="id" width="100"/>
	<grid:column label="sys.common.opt"  name="opt" formatter="button" width="100"/>
	<grid:button title="sys.common.delete"  groupname="opt" function="delObj" outclass="btn-danger" innerclass="fa-trash" url="${adminPath}/test/testordermain/delete" />
    <grid:column label="订单号"  name="orderno" />
    <grid:column label="订单金额"  name="money" />
    <grid:column label="订单日期"  name="orderdate" />
	<grid:toolbar function="create"/>
	<grid:toolbar function="update"/>
	<grid:toolbar function="delete"/>
	
	<grid:toolbar function="search"/>
	<grid:toolbar function="reset"/>
</grid:grid>
</body>
</html>