<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html:js  name="peity,iCheck,sweetalert,datepicker,Validform"/>
<!-- 自定义js -->
<script src="${staticPath}/common/js/content.js?v=1.0.0"></script>

<script type="text/javascript">
        //初始化表单
		var validateForm;
		var callFunc;
		//回调函数，在编辑和保存动作时，供openDialog调用提交表单。
		function doSubmit(func){
			callFunc=func;
		    validateForm.ajaxPost();
		}
		$(document).ready(function() {
		        validateForm = $("#<sitemesh:getProperty property='body.formid'/>").Validform({
				tiptype:function(msg,o,cssctl){
					if(!o.obj.is("form")){
						var objtip=o.obj.siblings(".Validform_checktip");
						cssctl(objtip,o.type);
						objtip.text(msg);
					}
				},beforeSubmit:function(curform){
					try{
						var beforeFunc=<sitemesh:getProperty property='body.beforeSubmit' default='beforeSubmit'/>;
						if(beforeFunc&&typeof(beforeFunc)=="function"){
							return beforeFunc(curform); 
						}
					}catch(err){
						
					}
					return true;	
				},callback:function(result){
					if(result.ret==0)
	              	{
	              	    top.layer.alert(result.msg, {icon: 0, title:'提示'});
	              	    //运行回调
	          	        callFunc();
	              	}else
	              	{
	              		top.layer.alert(result.msg, {icon: 0, title:'警告'});
	              	}
				}
			});
		});
</script>