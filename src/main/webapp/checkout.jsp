<%-- 
    Document   : giohang.jsp
    Created on : Jan 22, 2021, 12:43:47 AM
    Author     : tomnyson
--%>

<%@page import="DTO.Item"%>
<%@page import="DTO.Cart"%>
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
        <title>Giỏ hàng</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

        <style>
            .tongTien {
                color: red;
                margin-top: 20px;
            }
        </style>
    </head>

    <body>
        <div class="container">
            <div class="row">
                <div class="col col-md-6">
                    <form>
                        <h4>Thông tin thanh toán</h4>
                        <div>
                            <label for="firstName">họ và tên</label>
                            <input type="text" class="form-control" id="firstName" placeholder="" value="" required="">
                            <div class="invalid-feedback"> </div>
                        </div>
                        <div>
                            <label for="firstName">SĐT</label>
                            <input type="text" class="form-control" id="firstName" placeholder="" value="" required="">
                            <div class="invalid-feedback"> </div>
                        </div>
                        <div>
                            <label for="firstName">Địa chỉ nhận hàng</label>
                            <input type="text" class="form-control" id="firstName" placeholder="" value="" required="">
                            <div class="invalid-feedback"> </div>
                        </div>
                        <button type="submit"  class="btn btn-info">Thanh Toán</button>
                    </form>
                </div>
                <div class="col col-md-6">
                    <table class="table  table-sm" border="1" width="70%">
                        <tr><th>Tên Sản phẩm</th>
                            <th>Ảnh</th>
                            <th>Số lượng</th>
                            <th>Đơn giá</th>
                        </tr>

                        <%
                            Cart cart = (Cart) session.getAttribute("cart");
                            if (cart != null) {
                                ArrayList<Item> items = cart.getCart();
                                for (Item item : items) {
                        %>


                        <tr>
                            <td><%= item.getTitle()%></td>
                            <td> <img src="<%= item.getImage()%>" width="200px"/></td>
                            <td><%= item.getSoluong()%></td>
                            <td>
                                <fmt:formatNumber type="number" maxFractionDigits="2" value="<%= item.getPrice()%>" />
                            </td>
                        </tr>
                        </form>

                        <% }%>
                        <p class="tongTien"><strong >Tổng tiền:  <fmt:formatNumber type="number" maxFractionDigits="2" value="<%= cart.getTongTien()%>" /> VNĐ<strong></p>
                                    <% }%> 


                                    </table> 
                                    </div>
                                    </div>


                                    </div>
                                    </body>
                                    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
                                    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
                                    </html>
