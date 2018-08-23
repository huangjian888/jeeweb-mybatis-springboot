<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html style="overflow-x:auto;overflow-y:auto;">
<head>
	<title><sitemesh:title/>-<spring:message code="platform.copyright" /></title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="keywords" content="<spring:message code="sys.site.keywords" arguments="${platformName}"/>">
	<meta name="description" content="<spring:message code="sys.site.description" arguments="${platformName}"/>">
	
	<html:css  name="favicon,bootstrap,font-awesome,animate"/>
	
	<!-- 由于使用了自定义标签，jquery必须在之前 -->
	<!-- 全局js -->
	<html:js  name="jquery,common"/>
	<link href="${staticPath}/common/css/style.css?v=4.1.0" rel="stylesheet">		
	<!--Loading style-->
	<link type="text/css" rel="stylesheet" href="${staticPath}/uadmin/css/themes/style1/orange-blue.css" class="default-style">
	<link type="text/css" rel="stylesheet" href="${staticPath}/uadmin/css/themes/style1/orange-blue.css" id="theme-change" class="style-change color-change">
	<link type="text/css" rel="stylesheet" href="${staticPath}/uadmin/css/style-responsive.css">
	
	<sitemesh:head/>
</head>
<body class="gray-bg">
	<sitemesh:body/>
	<html:js  name="bootstrap"/>
</body>
</html>