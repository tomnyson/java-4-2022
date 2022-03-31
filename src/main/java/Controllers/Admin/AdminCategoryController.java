/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Admin;

import DAO.CategoryDao;
import DTO.CategoryDTO;
import Utils.GlobalFunc;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
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
public class AdminCategoryController extends HttpServlet {

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
        String method = request.getMethod();
        System.out.println("method" + method);
        if (method.equals("GET")) {
            try {
                // Xử lý get method
                /**
                 * b1: lay ds cat => db => dao b2 = set bien attribute => client
                 */
                HttpSession session = request.getSession();
                CategoryDao dao = new CategoryDao();
                List<CategoryDTO> list = new ArrayList<CategoryDTO>();
                list = dao.getList();
                request.setAttribute("list", list);
                System.out.println(list.size());
                session.setAttribute("view", "pages/category.jsp");
                request.getRequestDispatcher("dashboard.jsp").forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(AdminCategoryController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            /**
             * b1: parse dữ dữ liệu từ user JSON b2: dùng GJSOn convert json to
             * object g.fromJson(body, CategoryDTO.class); b3: them du lieu xong
             * db va get statuves tra b4: tra status ve cho nguoi dung bang
             */
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
                int isCreate = dao.create(dto);
                if (isCreate > 0) {
                    person.put("message", "tạo thành công");
                    // lay thong tin category vừa tạo
                    CategoryDTO detail = dao.getDetailById(isCreate);
                     person.put("message", "tạo thành công");
                     person.put("data", detail);
                     String json = new Gson().toJson(person);
                    response.getWriter().write(json);
                    return;
                }
               
                String json = new Gson().toJson(person);
                response.getWriter().write(json);
            } else {
                person.put("message", "invalid data");
                response.setStatus(400);
                String json = new Gson().toJson(person);
                response.getWriter().write(json);
            }
            System.out.println("${body1}" + body);
        }
//        String name = request.getParameter("name");
//        String image = rsetequest.getParameter("image");
//        String description = request.getParameter("description");
//        if(!name.equals("")) {
//            System.out.println("image"+image);
//             System.out.println("description"+description);
//            CategoryDTO dto = new CategoryDTO(name, image, description);
//            CategoryDao dao = new CategoryDao();
//            boolean isCreate = dao.create(dto);
//        }
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
