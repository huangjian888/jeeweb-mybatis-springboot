<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
  <title><spring:message code="sys.dict.group.title" /></title>
  <meta name="decorator" content="list"/>
</head>
<body title="<spring:message code="sys.dict.group.title" />">
<grid:grid id="groupGridId"  baseUrl="${adminPath}/sys/dict/group">
	<grid:column label="sys.common.key" hidden="true"   name="id" width="100"/>
	<grid:column label="sys.common.opt"  name="opt" formatter="button" width="100"/>
	<grid:button title="sys.dict.group.adddict"  groupname="opt" function="rowDialogDetailRefresh" outclass="btn-primary"  innerclass="fa-plus" url="${adminPath}/sys/dict?gid=\"+row.id+\"" />
	<grid:button  groupname="opt" function="delete"  />
    <grid:column label="sys.dict.group.name"  name="name"  query="true" condition="like" />
    <grid:column label="sys.dict.group.code"  name="code"  query="true" condition="like" />
    
	<grid:toolbar   function="create"  />
	<grid:toolbar   function="update"    />
	<grid:toolbar   function="delete"    />
	<grid:toolbar   title="强制刷新"   icon="fa-refresh"  onclick="forceRefresh()"  />
	<grid:toolbar  function="search"  />
	<grid:toolbar  function="reset"  />
</grid:grid>
<script>
function forceRefresh() {
	   swal({
            title: "提示",
            text: "您确定强制刷新字典！",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "确定",
            closeOnConfirm: false,
            cancelButtonText: "取消",
        }, function () {
			$.ajax({
				url : '${adminPath}/sys/dict/group/forceRefresh',
				type : 'post',
				cache : false,
				success : function(d) {
					if (d.ret==0) {
						var msg = d.msg;
					    swal("提示！", msg, "success");
					}else{
						var msg = d.msg;
					    swal("提示！", msg, "error");
					}
				}
			});
        });
 }
</script>
</body>
</html>