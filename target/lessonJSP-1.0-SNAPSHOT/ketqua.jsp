<%-- 
    Document   : ketqua
    Created on : Mar 15, 2022, 6:21:44 AM
    Author     : tomnyson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            pageContext.setAttribute("username", "abc");

        %>
        <p>param</p>
        <h1> username: ${param.username}</h1>
        <h1> password ${param.password}</h1>
        <p>requestscope</p>
        <h1> username: ${requestscope.username}</h1>
        <h1> password ${requestscope.password}</h1>
        <p>pageScope</p>
        <h1> username: ${pageScope.username}</h1>
        <h1> password ${pageScope.password}</h1>
        <p>applycationScope</p>
        <h1> username: ${applicationScope.username}</h1>
        <h1> password ${applicationScope.password}</h1>
        <h1>${username}</h1>
        <h1>${password}</h1>
    </body>
</html>
