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
            <table class="table">
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
                    <tr>
                        <td><i class="fab fa-angular fa-lg text-danger me-3"></i> <strong>${cat.getName()}</strong></td>
                        <td>${cat.getDescription()}</td>
                          <td>${cat.getImage()}</td>
                        <td>
                            <div class="dropdown">
                                <button type="button" class="btn p-0 dropdown-toggle hide-arrow" data-bs-toggle="dropdown"><i class="bx bx-dots-vertical-rounded"></i></button>
                                <div class="dropdown-menu">
                                    <a class="dropdown-item" href="javascript:void(0);"><i class="bx bx-edit-alt me-1"></i>Edit</a>
                                    <a class="dropdown-item" href="javascript:void(0);"><i class="bx bx-trash me-1"></i>Delete</a>
                                </div>
                            </div>
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">
                        </button>
                    </div>
                    <div class="modal-body">
                        <p>Croissant jelly beans donut apple pie. Caramels bonbon lemon drops. Sesame snaps lemon drops lemon drops liquorice icing bonbon pastry pastry carrot cake. Dragée sweet sweet roll sugar plum.</p>
                        <p>Jelly-o cookie jelly gummies pudding cheesecake lollipop macaroon. Sweet chocolate bar sweet roll carrot cake. Sweet roll sesame snaps fruitcake brownie bear claw toffee bonbon brownie.</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary">Save changes</button>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
