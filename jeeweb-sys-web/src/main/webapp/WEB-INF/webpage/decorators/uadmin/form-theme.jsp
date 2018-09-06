<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<!DOCTYPE html>
<html style="overflow-x:auto;overflow-y:auto;">
<head>
	<title><sitemesh:title/>-<spring:message code="platform.copyright" /></title>
	<%@include file="form-header.jsp" %>		
	<sitemesh:head/>
</head>
<body id="<sitemesh:getProperty property='body.id'/>" class="<sitemesh:getProperty property='body.class'/>"  style="<sitemesh:getProperty property='body.style'/>">
	<div class="page-content">
	  <sitemesh:body/>
	</div>
    <%@include file="form-footer.jsp" %>		
</body>
</html>