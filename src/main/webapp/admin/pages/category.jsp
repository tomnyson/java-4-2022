<%-- 
    Document   : category
    Created on : Mar 26, 2022, 6:20:31 AM
    Author     : tomnyson
--%>

<%@page import="java.util.List"%>
<%@page import="DTO.CategoryDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <button class="btn btn-outline-primary " id="btnCreate">add new</button>
        <table id="catTable" class="table">
            <thead>
                <tr>
                    <th>name</th>
                    <th>description</th>
                    <th>image</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>


                <c:forEach items="${list}" var="cat">
                    <tr data-id="${cat.getId()}">
                        <td> <strong>${cat.getName()}</strong></td>
                        <td>${cat.getDescription()}</td>
                        <td>${cat.getImage()}</td>
                        <td>
                            <div class="dropdown">
                                <button type="button" class="btn p-0 dropdown-toggle hide-arrow" data-bs-toggle="dropdown"><i class="bx bx-dots-vertical-rounded"></i></button>
                                <div class="dropdown-menu">
                                    <a class="dropdown-item" href="javascript:void(0);" onClick="EditCategory(${cat.getId()}, {
                                                'name': '${cat.getName()}',
                                                'description':'${cat.getName()}',
                                                'image': '${cat.getImage()}'
                                            })" ><i class="bx bx-edit-alt me-1"></i>Edit</a>
                                    <a class="dropdown-item" href="javascript:void(0);"><i class="bx bx-trash me-1"></i>Delete</a>
                                </div>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <!-- Modal -->
        <div class="modal fade" id="catModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">create category</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">
                        </button>
                    </div>

                    <div class="modal-body">
                        <form id="categoryForm1"  method="post" action="AdminCategoryController">
                            <%--<c:import url="${pageContext.request.contextPath}/admin/forms/categoryForm.jsp"/>--%> 
                              <input type="hidden" class="form-control" name="id" id="txtId"
                            <label for="defaultFormControlInput" class="form-label">Name</label>
                            <input type="text" class="form-control" name="name" id="txtName"
                                   placeholder="name" />
                            <span class="error" id="error-name"></span>
                            <label for="defaultFormControlInput" class="form-label">image</label>
                            <input type="text" name="image" id="image" class="form-control"
                                   placeholder="description" />
                            <span class="error" id="error-des"></span>
                            <label for="exampleFormControlTextarea1" class="form-label">description</label>
                            <textarea class="form-control" id="txtDescription" name="description" rows="3"></textarea>
                            <button style="margin-top: 30px " type="submit" class="btn btn-primary">Save</button>
                        </form>

                    </div>
                    <div class="modal-footer">
                    </div>
                </div>
            </div>
        </div>
        <div class="bs-toast toast fade show bg-primary" role="alert" aria-live="assertive" aria-atomic="true">
            <div class="toast-header">
                <img src="assets/img/avatars/1.png" class="d-block w-px-20 h-auto rounded me-2" alt="" />
                <div class="me-auto fw-semibold">Bootstrap</div>
                <small>11 mins ago</small>
                <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
            </div>
            <div class="toast-body">
                Fruitcake chocolate bar tootsie roll gummies gummies jelly beans cake.
            </div>
        </div>
    </body>
</html>
