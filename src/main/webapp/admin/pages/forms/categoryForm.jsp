<%-- 
    Document   : categoryForm
    Created on : Mar 26, 2022, 7:40:50 AM
    Author     : tomnyson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<form id="categoryForm" method="post" action="AdminCategoryController">
    <label for="defaultFormControlInput" class="form-label">Name</label>
    <input type="text" class="form-control" name="name" id="txtName"
           placeholder="name" />
    <span class="error" id="error-name"></span>
    <label for="defaultFormControlInput" class="form-label">image</label>
    <input type="text" name="image" class="form-control"
           placeholder="description" />
    <label for="exampleFormControlTextarea1" class="form-label">description</label>
    <textarea class="form-control" name="description" rows="3"></textarea>
    <button class="btn btn-primary">create</button>
</form>

<style>
    .error {
        color: red;
        display: block;
    }
</style>