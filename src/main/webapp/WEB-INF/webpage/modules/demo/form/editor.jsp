<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="decorator" content="single"/>
    <title>编辑器</title>
    <html:css  name="markdown,syntaxhighlighter"/>
    <html:component name="bootstrap-fileinput" />
</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="portlet box  portlet-grey">
					 <div class="portlet-header">
						<div class="caption">编辑器</div>
						<div class="tools">
	                        <i class="fa fa-chevron-up"></i>
	                        <i class="fa fa-refresh"></i><i class="fa fa-times"></i>
	                     </div>
					</div>	
					<div class="portlet-body">		 
                        <p>
                           	 扩展实现了TextareaTag 具有TextareaTag标签的一些功能。编辑器目前支持，markdown、simditor、Summernote、CodeMirror 
                        </p>

                         <html:display>
 							 <form:editor editorType="markdown"
								height="100px" path="editor"
								defaultValue="${tesdfsdfsdf}" nested="false" />
						 </html:display>
					     <form:editor editorType="markdown"
						    editorAfterSetting="editorAfterSetting"  path="test"
							defaultValue="" nested="false" />
					</div>
				</div>
			</div>
		</div>

	</div>
	<!-- 全局js -->
	<html:js name="iCheck,Validform,markdown" />
	<!-- 自定义js -->
	<script src="${staticPath}/common/js/content.js?v=1.0.0"></script>
</body>

</html>
