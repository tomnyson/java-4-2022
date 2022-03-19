<%-- 
    Document   : profile
    Created on : Mar 15, 2022, 9:20:51 AM
    Author     : tomnyson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        button {
            background: green;
            color: #fff;
            width:150px;
            padding: 10px;
        }
    </style>
    <body>
        <h1>Hello ${username}</h1>
        <p>username: <%=request.getParameter("username")%>
        <p>password <%=request.getParameter("password")%></p>

        <h1><%
//            String username1 = (String) session.getAttribute("username");
//            boolean value = (boolean) session.getAttribute("login");
//            if (!value) {
//                response.sendRedirect(request.getContextPath() + "/login.jsp");
//            }
            %> 
            cookie ${cookie['isAuth'].value}
            <%
                Cookie cookie = null;
                Cookie[] cookies = null;
                boolean isCheck = false;
                // Get an array of Cookies associated with this domain
                cookies = request.getCookies();
                if (cookies != null) {
                    out.println("<h2> Found Cookies Name and Value</h2>");
                    for (int i = 0; i < cookies.length; i++) {
                        cookie = cookies[i];
                        if (cookie.getName().equals("isAuth")) {
                            isCheck = true;

                        }
                    }
                }
            %>
            <%
                if(!isCheck) {
                  response.sendRedirect(request.getContextPath() + "/login.jsp");  
                }
            %>
            <form method="post" action="logout" >
                <button>logout</button>
            </form>
        </h1>


    </body>
</html>
