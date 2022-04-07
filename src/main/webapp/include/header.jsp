<%-- 
    Document   : header
    Created on : Jan 29, 2021, 4:18:45 PM
    Author     : tomnyson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <div class="left-header">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="./">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">DANH MỤC</a>
                    </li>
                </ul>
                <form class="d-flex">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
            <div class="profile">
                <c:choose>
                    <c:when test="${not empty currentUser}">
                        <c:if test="${currentUser.getRole() eq 'admin' }">
                            <a href="admin/dashboard.jsp">danh board</a>
                        </c:if>
                        <form action="AuthController" method="post">
                            <button class="btn btn-link" type="submit" name="action" value="logout">đăng xuất</button>
                        </form>
                    </c:when>
                    <c:otherwise>
                        <a href="login.jsp">đăng nhập</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</nav>