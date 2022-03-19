/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DTO.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 *
 * @author tomnyson
 */
public class UserController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /**
         * b1: get username, password b2: khoi object User -> gọi hàm
         * isLogin(username, password) b3: true => dispatcher -> set user, pass
         * to request.attribute => profile.jsp b4: false=> dispathcher -> login
         * , kem them error
         */
        //b1
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //b2
        UserDTO user = new UserDTO();
        boolean isLogin = user.isLogin(username, password);
//        processRequest(request, response);
//b3:
//System.out.println("Controllers.UserController.doPost()" + isLogin);
        if (isLogin) {
            // true
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            // cookie
//            Cookie cookieUsername = new Cookie("username", username);
//            Cookie cookiePassword = new Cookie("username", username);
//            cookieUsername.setMaxAge(60 * 60 * 24);
//            cookiePassword.setMaxAge(60 * 60 * 24);
//            response.addCookie(cookieUsername);
//            response.addCookie(cookiePassword);
            // session
//            HttpSession session = request.getSession();
//            //set gia tri cho session
//            session.setAttribute("login", true);
//            session.setAttribute("username", username);
//            session.setAttribute("password", password);
            // tao ra đối tượng cookie
            Cookie cookieAuth = new Cookie("isAuth", "true");
            cookieAuth.setMaxAge(60*60);
            response.addCookie(cookieAuth);
            
            request.getRequestDispatcher("profile.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "username or password not correct");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
