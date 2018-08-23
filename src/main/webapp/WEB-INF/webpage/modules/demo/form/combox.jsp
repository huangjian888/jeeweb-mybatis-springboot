<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="decorator" content="single"/>
    <title>自动搜索</title>
    <html:css  name="syntaxhighlighter"/>
</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="portlet box  portlet-grey">
					 <div class="portlet-header">
						<div class="caption">自动搜索</div>
						<div class="tools">
	                        <i class="fa fa-chevron-up"></i>
	                        <i class="fa fa-refresh"></i><i class="fa fa-times"></i>
	                     </div>
					</div>	
					<div class="portlet-body">
						<p>文件上传标签</p>
						<html:display>
					      <form:combox nested="false" effectiveFields="realname" effectiveFieldsAlias="realname|用户名"  
                                  showHeader="true" path="infoid"  dataUrl="${adminPath}/demo/form/ajaxCombox" />
					    </html:display>
						<form:combox nested="false" idField="id" keyField="realname" effectiveFields="realname" multiWord="true"
							effectiveFieldsAlias="realname|用户名" showHeader="true" path="infoid"
							dataUrl="${adminPath}/demo/form/ajaxCombox" />
					</div>
				</div>
			</div>
		</div>

	</div>
	<!-- 全局js -->
	<html:js name="suggest" />
	<!-- 自定义js -->
	<script src="${staticPath}/common/js/content.js?v=1.0.0"></script>
	<script type="text/javascript">
		
	</script>
</body>

</html>