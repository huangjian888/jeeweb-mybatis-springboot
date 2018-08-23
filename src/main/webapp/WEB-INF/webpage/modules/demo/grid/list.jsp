<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
  <title><spring:message code="task.schedulejob.title" /></title>
  <meta name="decorator" content="list"/>
</head>
<body title="<spring:message code="task.schedulejob.title" />">
<grid:grid id="schedulejobGridId" url="${adminPath}/task/schedulejob/ajaxList">
	<grid:column label="sys.common.key" hidden="true"   name="id" width="100"/>
	<grid:column label="sys.common.opt"  name="opt" formatter="button" width="160"/>
	<grid:button title="开启"  exp="row.jobStatus==0" tipMsg="你确定要启动该计划任务么?"  groupname="opt" function="rowConfirm" outclass="btn-primary" innerclass="fa-hourglass-start" url="${adminPath}/task/schedulejob/changeJobStatus?cmd=start" />
	<grid:button title="停止" exp="row.jobStatus==1" tipMsg="你确定要停止该计划任务么?" groupname="opt" function="rowConfirm" outclass="btn-danger"  innerclass="fa-square-o" url="${adminPath}/task/schedulejob/changeJobStatus?cmd=stop" />
	<grid:button title="更新cron" exp="row.jobStatus==1"  groupname="opt" outclass="btn-primary" tipMsg="你确定要更新该计划任务么?" function="rowConfirm" innerclass="fa-refresh" url="${adminPath}/task/schedulejob/updateCron" />
	<grid:button title="sys.common.delete"  groupname="opt" function="delObj" outclass="btn-danger" innerclass="fa-trash" url="${adminPath}/task/schedulejob/delete" />
    <grid:column label="任务名称"   name="jobName"   query="true" />
    <grid:column label="任务分组"  name="jobGroup"     />
    <grid:column label="类路径"  name="beanClass"     />
    <grid:column label="方法名"   name="methodName" formatter="email"  width="60"  />
    <grid:column label="SpringBean"  name="springBean"  />
    <grid:column label="cron表达式"  name="cronExpression" formatter="image" imageWidth="100" imageHeight="100" />
    <grid:column label="是否启动任务"  name="jobStatus" formatter="currency" formatoptions="{ decimalSeparator: '.', decimalPlaces: 1, suffix: ' USD', thousandsSeparator: ',', prefix: '$' }" width="60"/>
    <grid:column label="是否同步"  name="isConcurrent"  dict="sf"  prefix="Us" suffix="Uds" formatterValue="0:是;1:否"  formatterClass="0:label label-success;1:label label-success" width="60" />
    <grid:column label="创建时间"  name="createDate" />
	<grid:toolbar title="sys.common.add" icon="fa-plus" function="add" url="${adminPath}/task/schedulejob/edit"  />
	<grid:toolbar title="sys.common.update" icon="fa-file-text-o" function="update" url="${adminPath}/task/schedulejob/edit"  />
	
	<grid:toolbar  layout="right" title="sys.common.search" icon="fa-search"  function="doSearch"  />
	<grid:toolbar  layout="right" title="sys.common.reset" icon="fa-refresh"  function="searchReset"  />
</grid:grid>
</body>
</html>