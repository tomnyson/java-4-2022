<%-- 
    Document   : dashboard.jsp
    Created on : Mar 22, 2022, 6:21:36 AM
    Author     : tomnyson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

<!-- =========================================================
* Sneat - Bootstrap 5 HTML Admin Template - Pro | v1.0.0
==============================================================

* Product Page: https://themeselection.com/products/sneat-bootstrap-html-admin-template/
* Created by: ThemeSelection
* License: You must have a valid license purchased in order to legally use the theme for your project.
* Copyright ThemeSelection (https://themeselection.com)

=========================================================
-->
<!-- beautify ignore:start -->
<html
    lang="en"
    class="light-style layout-menu-fixed"
    dir="ltr"
    data-theme="theme-default"
    data-assets-path="assets/"
    data-template="vertical-menu-template-free"
    >
    <c:import url="includes/header.jsp"/>

    <body>
        <!-- Layout wrapper -->
        <div class="layout-wrapper layout-content-navbar">
            <div class="layout-container">
                <!-- Menu -->

                <c:import url="includes/menu.jsp"/>
                <!-- / Menu -->

                <!-- Layout container -->
                <div class="layout-page">
                    <!-- Navbar -->
                    <c:import url="includes/search.jsp"/>
                    <!-- / Navbar -->
                    <div class="content-wrapper">
                        <!-- Content -->
                        <div class="container-xxl flex-grow-1 container-p-y">
                            <%--<c:import url="pages/forms/categoryForm.jsp"/>--%>
                             <c:choose>
                                <c:when test="${sessionScope.view != null}">
                                    <c:import url="${sessionScope.view}"/> 
                                </c:when>
                                <c:otherwise>
                                    <c:import url="pages/404.jsp"/>
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <c:import url="includes/footer.jsp"/>
                        </body>
                        </html>

