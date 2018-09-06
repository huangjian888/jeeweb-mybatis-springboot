<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="decorator" content="single"/>
    <title>文件上传</title>
    <html:css  name="syntaxhighlighter"/>
    <html:component name="bootstrap-fileinput" />
</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="portlet box  portlet-grey">
					 <div class="portlet-header">
						<div class="caption">文件上传</div>
						<div class="tools">
	                        <i class="fa fa-chevron-up"></i>
	                        <i class="fa fa-refresh"></i><i class="fa fa-times"></i>
	                     </div>
					</div>	
					<div class="portlet-body">
						<p>文件上传标签</p>
						<html:display>
					        <form:fileinput nested="false" path="infoid" buttonText="选择文件"
							defaultValue="40288ab85c33548d015c337aa269002d,40288ab85c33548d015c338ef0c90030,40288ab85c33548d015c338fd1ce0032" />
					    </html:display>
						<form:fileinput   nested="false" path="infoid" buttonText="选择文件"/>
					</div>
					 
				</div>
			</div>
		</div>

	</div>
	<!-- 全局js -->
	<html:js name="iCheck,Validform,markdown,syntaxhighlighter" />
	<!-- 自定义js -->
	<script src="${staticPath}/common/js/content.js?v=1.0.0"></script>
	<script>
	  function refreshCallback(attachmentList){
		  // var fileid= attachmentList[i].data.id;
	  }
	</script>
</body>

</html>