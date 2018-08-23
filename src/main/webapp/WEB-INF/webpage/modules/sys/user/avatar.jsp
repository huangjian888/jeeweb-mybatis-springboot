<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="decorator" content="single"/>
    <title>上传头像</title>
    <html:css  name="iCheck,Validform"/>
    <html:css name="bootstrap-fileinput" />
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
       <div class="row">
            <div class="col-sm-12">
                <div class="portlet box  portlet-grey">
                     <div class="portlet-header">
                        <div class="caption">上传头像</div>
                        <div class="tools">
	                        <i class="fa fa-chevron-up"></i>
	                        <i class="fa fa-refresh"></i><i class="fa fa-times"></i>
	                    </div>
                    </div>
                    <div class="portlet-body">
                         <form:form id="avatarForm" modelAttribute="data"  method="post" class="form-horizontal">
                            <form:hidden path="id" />
                            <div class="form-group">
                                <div class="col-sm-3" >
                                  <form:fileinput showType="avatar" fileInputWidth="100px"  fileInputHeight="100px"  path="portrait"/>
                            	</div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-3" >
                                    <button class="btn btn-primary" type="submit">提交</button>
                                </div>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <!-- 全局js -->
    <html:js  name="iCheck,Validform,bootstrap-fileinput"/>
	<!-- 自定义js -->
	<script src="${staticPath}/common/js/content.js?v=1.0.0"></script>
	<script type="text/javascript">
	        //初始化表单
			var validateForm;
			$(document).ready(function() {
			        validateForm = $("#avatarForm").Validform({
			        tiptype:3,
			        ajaxPost:true,
			        callback:function(result){
			        	$.Hidemsg();
						if(result.ret==0)
		              	{
		              	    top.layer.alert(result.msg, {icon: 0, title:'提示'});
		              	}else
		              	{
		              		top.layer.alert(result.msg, {icon: 0, title:'警告'});
		              	} 
					}
				});
			});
			//初始化checkbox样式
			$(document).ready(function() {
				$(".i-checks").iCheck({
			           checkboxClass: 'icheckbox_square-green',
			           radioClass: 'iradio_square-green',
			    });
			});
			
			 
	</script>

</body>

</html>