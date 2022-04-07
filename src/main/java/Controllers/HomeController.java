/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.CategoryDao;
import DAO.ProductDao;
import DTO.CategoryDTO;
import DTO.ProductDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tomnyson
 */
@WebServlet(name = "HomeController", urlPatterns = {"/HomeController"})
public class HomeController extends HttpServlet {

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
        try {
            response.setContentType("text/html;charset=UTF-8");
            /* TODO output your page here. You may use following sample code. */
            /**
             * b1: danh mục sản phẩm b2: danh sách sản phẩm
             */
            CategoryDao catDao = new CategoryDao();
            ProductDao productDao = new ProductDao();
            List<CategoryDTO> listCat = new ArrayList<CategoryDTO>();
            listCat = catDao.getList();
            request.setAttribute("listCat", listCat);
            
            String id = request.getParameter("id");
            if (id != null) {
                // detail page
                ProductDTO detail = productDao.getDetailById(Integer.parseInt(id));
                CategoryDTO catDetail = catDao.getDetailById(detail.getCategoryId());
                request.setAttribute("detail", detail);
                request.setAttribute("catDetail", catDetail);
                request.getRequestDispatcher("productDetail.jsp").forward(request, response);
            }
            
            List<ProductDTO> lisProduct = new ArrayList<ProductDTO>();
            
            lisProduct = productDao.getList();
          
            request.setAttribute("listProduct", lisProduct);
            request.getRequestDispatcher("products.jsp").forward(request, response);
        } catch (Exception e) {
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
        processRequest(request, response);
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
