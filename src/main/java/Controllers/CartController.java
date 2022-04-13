/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.ProductDao;
import DTO.Cart;
import DTO.Item;
import DTO.ProductDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tomnyson
 */
@WebServlet(name = "CartController", urlPatterns = {"/CartController"})
public class CartController extends HttpServlet {

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
        String action = request.getParameter("cart");
         HttpSession session = request.getSession();
        if(action != null) {
        // lay cart ra
        // lay id ra
          Cart cart = (Cart) session.getAttribute("cart");
          String id = request.getParameter("id");
          if(id != null) {
              // lay detail product
              ProductDao dao = new ProductDao();
              ProductDTO product = dao.getDetailById(Integer.parseInt(id));
              System.out.println("product"+product.getId());
              //create Item
              // public Item(int maSP, int soluong, String title, float price, String image)
              Item item = new Item(product.getId(),
                      1, product.getName(),
                      product.getPrice(), product.getImage());
              System.out.println("go here");
              if(action.equals("add")) {
              // them
              // kiem tra xem da co cart item chua
              if(cart == null) {
                  cart = new Cart();
              }
              cart.add(item);
             }
              // set lay cart session
              session.setAttribute("cart", cart);
              response.sendRedirect("./giohang.jsp");
          }
        
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
