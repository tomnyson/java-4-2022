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
        <title>category</title>
    </head>
    <body>
        <button class="btn btn-outline-primary " id="btnCreate">add new</button>
        <table id="catTable" class="table">
            <thead>
                <tr>
                    <th>name</th>
                    <th>description</th>
                    <th>price</th>
                    <th>image</th>
                    <th>category</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>


                <c:forEach items="${list}" var="cat">
                    <tr data-id="${cat.getId()}">
                        <td> <strong>${cat.getName()}</strong></td>
                        <td>${cat.getDescription()}</td>
                        <td>${cat.getPrice()}</td>
                        <td>${cat.getImage()}</td>
                        <td>${cat.getCategoryId()}</td>
                        <td>
                            <div class="dropdown">
                                <button type="button" class="btn p-0 dropdown-toggle hide-arrow" data-bs-toggle="dropdown"><i class="bx bx-dots-vertical-rounded"></i></button>
                                <div class="dropdown-menu">
                                    <a class="dropdown-item" href="javascript:void(0);" onClick="EditProduct(${cat.getId()},{
                                                'name': '${cat.getName()}',
                                                'description': '${cat.getDescription()}',
                                                'image': '${cat.getImage()}'
                                            })" ><i class="bx bx-edit-alt me-1"></i>Edit</a>
                                    <a class="dropdown-item" href="javascript:void(0);" onclick="DeleteCategory(${cat.getId()})"><i class="bx bx-trash me-1"></i>Delete</a>
                                </div>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <!-- Modal -->
        <div class="modal fade" id="productModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">create product</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">
                        </button>
                    </div>

                    <div class="modal-body">
                        <form id="productForm"  method="post" action="AdminCategoryController">
                            <%--<c:import url="${pageContext.request.contextPath}/admin/forms/categoryForm.jsp"/>--%> 
                            <input type="hidden" class="form-control" name="id" id="txtId"
                                   <label for="defaultFormControlInput" class="form-label">Name</label>
                            <input type="text" class="form-control" name="name" id="txtName"
                                   placeholder="name" />
                            <span class="error" id="error-name"></span>
                            <label for="defaultFormControlInput" class="form-label">image</label>
                            <input type="text" name="image" id="image" class="form-control"
                                   placeholder="description" />
                             <label for="defaultFormControlInput" class="form-label">price</label>
                            <input type="number" name="image" id="price" class="form-control"
                                   placeholder="price" />
                            <span class="error" id="error-des"></span>
                            <label for="exampleFormControlTextarea1" class="form-label">description</label>
                            <textarea class="form-control" id="txtDescription" name="description" rows="3"></textarea>
                            <div class="mb-3">
                                <label for="exampleFormControlSelect1" class="form-label">category</label>
                                <select class="form-select" id="category" aria-label="Default select example">
                                    <option selected>select category</option>
                                    <c:forEach items="${catList}" var="cat">
                                         <option value="${cat.getId()}">${cat.getName()}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <button style="margin-top: 30px " type="submit" class="btn btn-primary">Save</button>
                        </form>

                    </div>
                    <div class="modal-footer">
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
