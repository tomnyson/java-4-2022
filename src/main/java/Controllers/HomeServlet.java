/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

/**
 *
 * @author tomnyson
 */
public class HomeServlet extends HttpServlet {

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
        RequestDispatcher dis = this.getServletContext().getRequestDispatcher("/login.html");
        dis.forward(request, response);
    }

    protected void processResult(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher dis = this.getServletContext().getRequestDispatcher("/result.html");
        dis.forward(request, response);
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
//        processRequest(request, response);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String[] favorite = request.getParameterValues("favorite1");
        String gender = request.getParameter("gender");
        String role = request.getParameter("role");
        request.setAttribute("username", username);
        request.setAttribute("password", password);
        String[]  test = {"aa", "bbb"};
        request.setAttribute("favorite", favorite);
        request.getRequestDispatcher("result.jsp").forward(request, response);
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
         * lấy dữ liệu từ form
         */
        String username = request.getParameter("username");
        String password = request.getParameter("password");
//        String[] paramValues = request.getParameterValues("favorite1");
//        for (int i = 0; i < paramValues.length; i++) {
//            String paramValue = paramValues[i];
//            System.out.println("favorite: " + paramValue);
//        }
//        String gender = request.getParameter("gender");
//        String role = request.getParameter("role");
//        System.out.println("role" + role);
//        System.out.println("gender" + gender);
        request.setAttribute("username", username);
        request.setAttribute("password", password);
        request.getServletContext().setAttribute("username", username);
        request.getServletContext().setAttribute("password", password);
        request.getRequestDispatcher("ketqua.jsp").forward(request, response);
//        processResult(request, response);

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
