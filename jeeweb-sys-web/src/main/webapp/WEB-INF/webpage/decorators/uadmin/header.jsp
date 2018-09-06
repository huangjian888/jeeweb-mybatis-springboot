<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="Thu, 19 Nov 1900 08:52:00 GMT">

	<title><spring:message code="sys.site.title" arguments="${platformName}"/></title>
	<meta name="keywords" content="<spring:message code="sys.site.keywords" arguments="${platformName}"/>">
	<meta name="description" content="<spring:message code="sys.site.description" arguments="${platformName}"/>">
	
	<!--Loading bootstrap css-->
	<link type="text/css" rel="stylesheet" href="${staticPath}/vendors/jquery-ui-1.10.4.custom/css/ui-lightness/jquery-ui-1.10.4.custom.min.css">
	<html:css  name="favicon,bootstrap,font-awesome,animate,pace"/>
	<!--Loading style-->
	<link type="text/css" rel="stylesheet" href="${staticPath}/uadmin/css/themes/style1/orange-blue.css">	
	<link type="text/css" rel="stylesheet" href="${staticPath}/uadmin/css/style-responsive.css"> 
	
	<html:js  name="jquery"/>
	<script src="${staticPath}/uadmin/js/jquery-migrate-1.2.1.min.js"></script>
	<script src="${staticPath}/uadmin/js/jquery-ui.js"></script>