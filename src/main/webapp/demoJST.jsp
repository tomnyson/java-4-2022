<%-- 
    Document   : demoJST
    Created on : Mar 24, 2022, 8:43:02 AM
    Author     : tomnyson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:set var="name" scope="session" value="${1500}"/>
        <c:out value="${name}"/>
        <%--<c:remove var="name"/>--%>  
        <h1>print here</h1>
        <c:out value="${name}"/>
        <%if (4 > 2) {%>
        <h1>4>2</h1>
        <%}%>
        <c:if test="${4 > 2}">  
            <h1>4>2</h1> 
        </c:if>
        <c:choose>
            <c:when test="${name>2000}">
                <h1>>2000</h1> 
            </c:when>
            <c:when test="${name>1000}">
                <h1>>1000</h1> 
            </c:when>
            <c:otherwise>
                <h1><1000</h1>
            </c:otherwise>
        </c:choose>
        <c:import url="login.jsp"></c:import>
    </body>
</html>
