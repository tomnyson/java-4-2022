<%-- 
    Document   : result.jsp
    Created on : Mar 15, 2022, 7:41:26 AM
    Author     : tomnyson
--%>

<%@page import="java.lang.String"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>username: ${username}</h1>
        <h1>username: ${password}</h1>
        <h1>username: ${favorite}</h1>
        <% String[] favorite = (String[])request.getAttribute("favorite"); %>
        <%
            for(int i=0; i< favorite.length; i++) {
        %>
        <h3><%= favorite[i] %></h3>
        <%}%>
    </body>
</html>
