<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<!DOCTYPE html>
<c:set var="theme" value="${fns:getTheme()}" />
<c:choose>
    <c:when test="${theme eq 'uadmin'}">
        <%@include file="./uadmin/form-theme.jsp" %>
    </c:when>
    <c:otherwise>
        <%@include file="./default/form-theme.jsp" %>
    </c:otherwise>
</c:choose>