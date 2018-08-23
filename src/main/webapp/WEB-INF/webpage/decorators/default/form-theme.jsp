<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html style="overflow-x:auto;overflow-y:auto;">
<head>
	<title><sitemesh:title/>-<spring:message code="platform.copyright" /></title>
	<%@include file="form-header.jsp" %>		
	<sitemesh:head/>
	</style>
</head>
<body id="<sitemesh:getProperty property='body.id'/>" class="<sitemesh:getProperty property='body.class'/>"  style="<sitemesh:getProperty property='body.style'/>">
	<div class="page-content">
	  <sitemesh:body/>
	</div>
    <%@include file="form-footer.jsp" %>		
</body>
</html>