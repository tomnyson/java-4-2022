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
    <body>
        <h1>Hello ${username}</h1>
        <p>username: <%=request.getParameter("username")%>
        <p>password <%=request.getParameter("password")%></p>
        <%
            Cookie cookie = null;
            Cookie[] cookies = null;
            // Get an array of Cookies associated with this domain
            cookies = request.getCookies();
            if (cookies != null) {
                out.println("<h2> Found Cookies Name and Value</h2>");
                for (int i = 0; i < cookies.length; i++) {
                    cookie = cookies[i];
                    out.print("Name : " + cookie.getName() + ",  ");
                    out.print("Value: " + cookie.getValue() + " <br/>");
                }
            } else {
                out.println("<h2>No cookies founds</h2>");
            }
        %>
        
        <%
   // Get an array of Cookies associated with this domain
   cookies = request.getCookies();
   if( cookies != null ){
      out.println("<h2> Found Cookies Name and Value</h2>");
      for (int i = 0; i < cookies.length; i++){
         cookie = cookies[i];
         if((cookie.getName( )).compareTo("username") == 0 || (cookie.getName( )).compareTo("password") == 0 ){
            cookie.setMaxAge(0);
            response.addCookie(cookie);
            out.print("Deleted cookie: " + 
            cookie.getName( ) + "<br/>");
         }
         out.print("Name : " + cookie.getName( ) + ",  ");
         out.print("Value: " + cookie.getValue( )+" <br/>");
      }
  }else{
      out.println(
      "<h2>No cookies founds</h2>");
  }
%>
<!--check session-->
    <%  String username1 = (String) session.getAttribute("username");
        String password1 = (String) session.getAttribute("password");
    %>
        <p>username: <%=username1%>
        <p>password <%=password1%></p>
       <% 
           session.removeAttribute("password");
            session.removeAttribute("username");
       %>
       
       <p>username1 <%=username1%>
        <p>password1 <%=username1%></p>
    </body>
</html>
