<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">

<head>
    <title><sitemesh:title/>-<spring:message code="platform.copyright" /></title>
	<%@include file="header.jsp" %>
	<sitemesh:head/>
	<style>
		/* ECHARTS  */
		.echarts {
		    height: 400px;
		}
	</style>
</head>

<body class=" ">
    <div>
        <!--BEGIN BACK TO TOP--><a id="totop" href="#"><i class="fa fa-angle-up"></i></a>
        <!--END BACK TO TOP-->
        <%@include file="topbar.jsp"%>
        <div id="wrapper">
            <%@include file="left.jsp"%>
            <!--BEGIN PAGE WRAPPER-->
            <div id="page-wrapper">
                <!--BEGIN TITLE & BREADCRUMB PAGE-->
                <div id="title-breadcrumb-option-demo" class="page-title-breadcrumb">
                    <div class="page-header pull-left">
                        <div class="page-title"><sitemesh:title/></div>
                    </div>
                    <ol class="breadcrumb page-breadcrumb">
                        <li><i class="fa fa-home"></i>&nbsp;<a href="${adminPath}">首页</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
                        <c:forEach items="${fn:split(pmenuids, '/')}" var="pmenuid">
                        <c:set var="menu" value="${fns:getMenuById(pmenuid)}" />
                        <li><a href="#">${menu.name}</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
                        </c:forEach>
                        <li class="active">${currentMenu.name}</li>
                    </ol>
                    <div class="btn btn-blue reportrange hide"><i class="fa fa-calendar"></i>&nbsp;<span></span>&nbsp;report&nbsp;<i class="fa fa-angle-down"></i>
                        <input type="hidden" name="datestart" />
                        <input type="hidden" name="endstart" />
                    </div>
                    <div class="clearfix"></div>
                </div>
                <!--END TITLE & BREADCRUMB PAGE-->
                <!--BEGIN CONTENT-->
                <div class="page-content">
                     <sitemesh:body/>
                </div>
			    <!--END CONTENT-->
    </div>
    <!--BEGIN FOOTER-->
    <div id="footer">
        <div class="copyright"><spring:message code="sys.site.bottom.copyright" /></div>
    </div>
    <!--END FOOTER-->
    <!--END PAGE WRAPPER-->
    </div>
    </div>
    <%@include file="footer.jsp" %>
    <script type="text/javascript">
		//初始化checkbox样式
		$(document).ready(function() {
		    //BEGIN CHECKBOX & RADIO
		    $('input[type="checkbox"]').iCheck({
		        checkboxClass: 'icheckbox_minimal-grey',
		        increaseArea: '20%' // optional
		    });
		    $('input[type="radio"]').iCheck({
		        radioClass: 'iradio_minimal-grey',
		        increaseArea: '20%' // optional
		    });
		});
	</script>
</body>

</html>