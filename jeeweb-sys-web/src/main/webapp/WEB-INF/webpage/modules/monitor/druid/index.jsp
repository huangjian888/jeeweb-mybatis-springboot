<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="decorator" content="single"/>
    <title>数据库监控</title>
</head>
<body class="gray-bg">
    <iframe  id="druidIframe" onload="reinitIframe()"  width="100%" height="100%" src="${adminPath}/sys/monitor/druid/index.html" frameborder="0"  seamless></iframe>
	<script type="text/javascript">
	function reinitIframe() {
	    var iframe = document.getElementById("druidIframe");
	    try {
	        var bHeight = iframe.contentWindow.document.body.scrollHeight;
	        var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
	        var height = Math.max(bHeight, dHeight);
	        iframe.height = height;
	        console.log(height);
	    } catch(ex) {}
	}
	window.setInterval("reinitIframe()", 200);
	</script>
</body>

</html>