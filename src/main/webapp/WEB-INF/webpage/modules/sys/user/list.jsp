<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
  <title><spring:message code="sys.user.title" /></title>
  <meta name="decorator" content="list"/>
  <html:component name="bootstrap-treeview"/>
</head>
<body title="<spring:message code="sys.user.title" />">
<div class="row">
	<div class="col-sm-3 col-md-2" >
	   <view:treeview id="organizationTreeview" dataUrl="${adminPath}/sys/organization/bootstrapTreeData" onNodeSelected="organizationOnclick"></view:treeview>
	    <script type="text/javascript">
	       function organizationOnclick(event, node) {
	    	   //查询时间
	    	   //gridquery隐藏 查询标签概念，query,单独的query
	    	   $("input[name='organizationid']").val(node.href);
	    	   search('userGridIdGrid');
	       }
	   </script>
	</div>
	<div  class="col-sm-9 col-md-10">
		<grid:grid id="userGridId" url="${adminPath}/sys/user/ajaxList">
			<grid:column label="sys.common.key" hidden="true"   name="id" width="100"/>
			<grid:column label="sys.common.opt"  name="opt" formatter="button" width="100"/>
			<grid:button groupname="opt" function="delete"/>
			<grid:query name="organizationid"  queryMode="hidden" />
		    <grid:column label="sys.user.realname"  name="realname"  query="true"  condition="like" />
		    <grid:column label="sys.user.username"  name="username"  query="true" condition="like"   />
		    <grid:column label="sys.user.email"  name="email"  />
		    <grid:column label="sys.user.phone"  name="phone"  />
			<grid:toolbar title="sys.user.createuser" function="create"/>
		 	<grid:toolbar title="sys.user.updateuser" function="update"/>
			<grid:toolbar title="sys.user.modifypwd" icon="fa-database"  function="updateDialog" url="${adminPath}/sys/user/{id}/changePassword"  />
			<grid:toolbar function="delete"/>
			<grid:toolbar  function="search"/>
			<grid:toolbar  function="reset"/>
		</grid:grid>
	</div>
</div>
</body>
</html>