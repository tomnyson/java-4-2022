<%-- 
    Document   : danhsachxe
    Created on : Jan 21, 2021, 11:06:55 PM
    Author     : tomnyson
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>danh sách xe oto</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="./style/styles.css">
    </head>
    <body>
        <c:import  url="include/header.jsp"/>
        <div class="container">
            <div class="row">
                <div class="col col-sm-2">
                    <h5>Danh mục</h5>
                    <ul class="list-group">
                        <c:forEach items="${listCat}" var="cat">
                            <a class="list-group-item list-group-item-action" 
                               href="category/${cat.getId()}">${cat.getName()}</a> 
                        </c:forEach>
                    </ul>
                </div>
                <div class="col col-sm-10">
                    <div class="row">
                        <div class="col-sm-4">
                            <image width="300px" src="${detail.getImage()}"/>
                        </div>
                        <div class="col-sm-8">
                            <h2>${detail.getName()}</h2>
                            <h3><fmt:formatNumber type="number" maxFractionDigits="2" value="${detail.getPrice()}" /> VNĐ</h3>
                            <p>category: <a href="category?id=${catDetail.getId()}">${catDetail.getName()}</a></p>
                            <button type="button" style="width: 100px" class="btn btn-primary">BUY</button>
                        </div>
                    </div>
                    <div class="col-sm-12">
                        ${detail.getDescription()}
                    </div>
                </div>
            </div>
            <c:import  url="include/footer.jsp"/>
    </body>
</html>
