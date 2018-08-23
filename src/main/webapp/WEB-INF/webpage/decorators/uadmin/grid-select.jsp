<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">

<head>
    <title><sitemesh:title/>-<spring:message code="platform.copyright" /></title>
	<%@include file="header.jsp" %>
	<!-- list新增 -->
    <html:css  name="datepicker,jqgrid,sweetalert,layer"/>	
	<sitemesh:head/>
	<style>
	   .uadmin-grid-margin{
	   	   margin-top:8px;
	   }
	</style>
</head>

<body>
   <div class="page-content">
      <div class="portlet box">
          <div class="portlet-body">
              <sitemesh:body/>
          </div>
      </div>
   </div>
        
    <%@include file="footer.jsp" %>
    <!-- list新增  -->
    <html:js  name="jqGrid,jqGrid_curdtools,layer,sweetalert,datepicker"/>
</body>

</html>