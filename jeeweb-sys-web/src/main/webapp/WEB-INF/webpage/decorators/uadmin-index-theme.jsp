<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<!DOCTYPE html>
<html style="overflow-x:auto;overflow-y:auto;">
<head>
	<title><sitemesh:title/>-<spring:message code="platform.copyright" /></title>
	<%@include file="./include/list-header.jsp" %>		
	<sitemesh:head/>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5><sitemesh:getProperty property='body.title'/></h5>
						<div class="ibox-tools">
							<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
							</a>
							<a class="close-link"> <i class="fa fa-times"></i>
							</a>
						</div>
					</div>
					<div class="ibox-content">
					   <sitemesh:body/>
					</div>
				</div>
			</div>
		</div>
	</div>
    <%@include file="./include/list-footer.jsp" %>		
</body>
</html>