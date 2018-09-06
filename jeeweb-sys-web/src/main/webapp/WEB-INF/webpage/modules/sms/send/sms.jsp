<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="decorator" content="single"/>
    <title>短信发送</title>
    <html:css  name="iCheck,Validform"/>
</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
                <div class="col-sm-12">
                    <div class="alert alert-success">
                       <button aria-hidden="true" data-dismiss="alert" class="close" type="button">×</button>
                       	内容方式，内容为:您的验证码是：{1}。请不要把验证码泄露给其他人。<br /> 
                    	模板方式，模版编码为:vercode,参数为:12345
                    </div>
                </div>
                <div class="col-sm-6">
					<div class="portlet box  portlet-grey">
						 <div class="portlet-header">
							<div class="caption">短信发送(短信內容方式发送)</div>
							<div class="tools">
		                        <i class="fa fa-chevron-up"></i>
		                        <i class="fa fa-refresh"></i><i class="fa fa-times"></i>
		                     </div>
						</div>
						<div class="portlet-body">
							<form:form id="smsForm"
								action="${adminPath}/sms/send/sendSmsByContent" method="post"
								class="form-horizontal">
								<div class="form-group col-sm-12">
									<label class="col-sm-4 control-label"><font color="red">*</font>电话号码：</label>
									<div class="col-sm-8">
										<form:input path="phone" class="form-control" nested="false"
											datatype="*" placeholder="电话号码，多个以英文逗号“,”隔开"
											htmlEscape="false" />
									</div>
								</div>
	
								<div class="form-group col-sm-12">
									<label class="col-sm-4 control-label"><font color="red">*</font>发送内容：</label>
									<div class="col-sm-8">
										<form:textarea path="content" nested="false"
											cssClass="form-control" placeholder="发送内容为，内容或服务商的模板ID"
											datatype="*" rows="4" cols="30" />
									</div>
								</div>
	
								<div class="form-group">
									<div class="col-sm-8 col-sm-offset-3 text-right">
										<button class="btn btn-primary" type="submit">发送</button>
									</div>
								</div>
							</form:form>
						</div>
					</div>
				</div>
				<div class="col-sm-6">
				    <div class="portlet box  portlet-grey">
						 <div class="portlet-header">
							<div class="caption">短信发送(模版方式发送)</div>
							<div class="tools">
		                        <i class="fa fa-chevron-up"></i>
		                        <i class="fa fa-refresh"></i><i class="fa fa-times"></i>
		                     </div>
						</div>
						<div class="portlet-body">
							<form:form id="smsTemplateSmsForm"
								action="${adminPath}/sms/send/sendSmsByCode" method="post"
								class="form-horizontal">
								<div class="form-group col-sm-12">
									<label class="col-sm-4 control-label"><font color="red">*</font>电话号码：</label>
									<div class="col-sm-8">
										<form:input path="phone" class="form-control" nested="false"
											datatype="*" placeholder="电话号码，多个以英文逗号“,”隔开"
											htmlEscape="false" />
									</div>
								</div>
	
								<div class="form-group col-sm-12">
									<label class="col-sm-4 control-label"><font color="red">*</font>发送模版编码：</label>
									<div class="col-sm-8">
										<form:input path="code" class="form-control" nested="false"
											datatype="*" placeholder="这里的编码需要在模版配置中能找到" htmlEscape="false" />
									</div>
								</div>
								<div class="form-group col-sm-12">
									<label class="col-sm-4 control-label"><font color="red">*</font>发送内容：</label>
									<div class="col-sm-8">
										<form:input path="data" class="form-control" nested="false"
											datatype="*" placeholder="多内容用英文逗号分割“,”" htmlEscape="false" />
									</div>
								</div>
	
								<div class="form-group">
									<div class="col-sm-8 col-sm-offset-3 text-right">
										<button class="btn btn-primary" type="submit">发送</button>
									</div>
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- 全局js -->
	<html:js name="iCheck,Validform" />

	<!-- 自定义js -->
	<script src="${staticPath}/common/js/content.js?v=1.0.0"></script>

	<script type="text/javascript">
		//初始化表单
		var validateForm;
		$(document).ready(function() {
			validateForm = $("#smsTemplateSmsForm").Validform({
				tiptype : 3,
				ajaxPost : true,
				callback : function(result) {
					$.Hidemsg();
					if (result.ret == 0) {
						top.layer.alert(result.msg, {
							icon : 0,
							title : '提示'
						});
					} else {
						top.layer.alert(result.msg, {
							icon : 0,
							title : '警告'
						});
					}
				}
			});
		});

		//初始化表单
		var validateHyForm;
		$(document).ready(function() {
			validateHyForm = $("#smsForm").Validform({
				tiptype : 3,
				ajaxPost : true,
				callback : function(result) {
					$.Hidemsg();
					if (result.ret == 0) {
						top.layer.alert(result.msg, {
							icon : 0,
							title : '提示'
						});
					} else {
						top.layer.alert(result.msg, {
							icon : 0,
							title : '警告'
						});
					}
				}
			});
		});

		function testHySms() {
			$("#smsForm").attr("action", "${adminPath}/sys/setting/testHySms");
			validateHyForm.ajaxPost();
			return false;
		}
	</script>

</body>

</html>
