<%-- 
    Document   : testJstl
    Created on : Mar 17, 2022, 6:28:24 AM
    Author     : tomnyson
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <% String username = (String) session.getAttribute("username");%>
        <c:out value="${'Welcome to javaTpoint'}"/>  
        <c:set var="Income" scope="session" value="${4000*4}"/>  
        <c:out value="${Income}"/>  
        <c:set var="income" scope="session" value="${4000*4}"/>  
        <p>Before Remove Value is: <c:out value="${income}"/></p>  
        <c:remove var="income"/>  
        <p>After Remove Value is: <c:out value="${income}"/></p>  

        <c:set var="income1" scope="session" value="${4000*4}"/>  
        <c:if test="${income1 > 8000}">  
            <p>My income is: <c:out value="${income1}"/><p>  
            </c:if>  
            <c:choose>  
                <c:when test="${income1 <= 1000}">  
                    Income is not good.  
                </c:when>  
                <c:when test="${income1 > 10000}">  
                    Income is very good.  
                </c:when>  
                <c:otherwise>  
                    Income is undetermined...  
                </c:otherwise>  
            </c:choose>
            <c:set value="10" var="num"></c:set>  
            <c:choose>  
                <c:when test="${num%2==0}">  
                    <c:out value="${num} is even number"></c:out>  
                </c:when>  
                <c:otherwise>  
                    <c:out value="${num} is odd number"></c:out>  
                </c:otherwise>  
            </c:choose>  

            <c:forEach var="j" begin="1" end="3">  
                Item <c:out value="${j}"/><p>  
            </c:forEach>
            <c:url value="/RegisterDao.jsp"/>  
    </body>
</html>
