<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${charttitle}</title>
    <meta name="decorator" content="single"/>
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="portlet box  portlet-grey">
					 <div class="portlet-header">
						<div class="caption">${charttitle}</div>
						<div class="tools">
	                        <i class="fa fa-chevron-up"></i>
	                        <i class="fa fa-refresh"></i><i class="fa fa-times"></i>
	                     </div>
					</div>	
					<div class="portlet-body">
                        <div class="echarts" id="echarts-${charttype}-chart"></div>
                    </div>
                </div>
            </div>
         </div> 
    </div>
    
	<!-- 全局js -->
	<html:js name="echarts" />
	<script src="${staticPath}/modules/charts/js/echarts/${charttype}.js"></script>
</body>

</html>