/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Admin;

import DAO.CategoryDao;
import DAO.ProductDao;
import DTO.CategoryDTO;
import DTO.ProductDTO;
import Utils.GlobalFunc;
import com.google.gson.Gson;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tomnyson
 */
public class AdminProductController extends HttpServlet {

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
        try {
               String method = request.getMethod();
        if (method.equals("GET")) {
            try {
                // Xử lý get method
                /**
                 * b1: lay ds cat => db => dao b2 = set bien attribute => client
                 * ProductDAO
                 * ProductDTO
                 */
                HttpSession session = request.getSession();
                ProductDao dao = new ProductDao();
                CategoryDao catDao = new CategoryDao();
                List<ProductDTO> list = new ArrayList<ProductDTO>();
                List<CategoryDTO> cats = new ArrayList<CategoryDTO>();
                
                list = dao.getList();
                cats = catDao.getList();
                request.setAttribute("list", list);
                request.setAttribute("catList", cats);
                session.setAttribute("view", "pages/product.jsp");
                request.getRequestDispatcher("dashboard.jsp").forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(AdminProductController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (method.equals("PUT")) {

            //chuc nang update
            String body = GlobalFunc.parseBody(request);
            Gson g = new Gson();
            CategoryDTO cat = g.fromJson(body, CategoryDTO.class);
            String name = cat.getName();
            String des = cat.getDescription();
            String image = cat.getImage();
            HashMap<String, Object> person
                    = new HashMap<String, Object>();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            if (!name.equals("") && !des.equals("")) {
                CategoryDTO dto = new CategoryDTO(name, des, image);
                CategoryDao dao = new CategoryDao();
                boolean isCreate = dao.update(cat);
                System.err.println("isCreate" + isCreate);
                if (isCreate) {
                    person.put("message", "cập nhật thành công");
                    // lay thong tin category vừa tạo
                    CategoryDTO detail = dao.getDetailById(cat.getId());
                    person.put("data", detail);
                    String json = new Gson().toJson(person);
                    response.getWriter().write(json);
                    return;
                }

                String json = new Gson().toJson(person);
                response.getWriter().write(json);
                return;
            }

        } else if (method.equals("DELETE")) {
            //chuc nang update
            String body = GlobalFunc.parseBody(request);
            Gson g = new Gson();
            HashMap<String, Object> person
                    = new HashMap<String, Object>();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            CategoryDTO cat = g.fromJson(body, CategoryDTO.class);
            int id = cat.getId();

            CategoryDao dao = new CategoryDao();
            boolean isCreate = dao.delete(id);
            if (isCreate) {
                person.put("message", "xoá thành công");
                // lay thong tin category vừa tạo
                String json = new Gson().toJson(person);
                response.getWriter().write(json);
                return;
            }

            String json = new Gson().toJson(person);
            response.getWriter().write(json);
            return;

        } else {
            /**
             * b1: parse dữ dữ liệu từ user JSON b2: dùng GJSOn convert json to
             * object g.fromJson(body, CategoryDTO.class); b3: them du lieu xong
             * db va get statuves tra b4: tra status ve cho nguoi dung bang
             */
            String body = GlobalFunc.parseBody(request);
            System.err.println(body);
            Gson g = new Gson();
            ProductDTO cat = g.fromJson(body, ProductDTO.class);
            String name = cat.getName();
            String des = cat.getDescription();
            HashMap<String, Object> person
                    = new HashMap<String, Object>();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            if (!name.equals("") && !des.equals("")) {
                ProductDao productDao = new ProductDao();
                int isCreate = productDao.create(cat);
                if (isCreate > 0) {
                    // lay thong tin category vừa tạo
                    ProductDTO detail = productDao.getDetailById(isCreate);
                    person.put("message", "tạo thành công");
                    person.put("data", detail);
                }

                String json = new Gson().toJson(person);
                response.getWriter().write(json);
                return;
            } else {
                person.put("message", "invalid data");
                response.setStatus(400);
                String json = new Gson().toJson(person);
                response.getWriter().write(json);
            }
            return;
        }
            
        } catch (Exception e) {
            e.printStackTrace();
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

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
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
