/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Admin.API;

import DAO.CategoryDao;
import DTO.CategoryDTO;
import Utils.GlobalFunc;
import Utils.JwtHelper;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tomnyson
 */
@WebServlet(name = "APIProductController", urlPatterns = {"/api/product/*", "/api/product/:id"})
public class APIProductController extends HttpServlet {

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

        if (request.getMethod().equals("GET")) {
            HashMap<String, Object> person
                    = new HashMap<String, Object>();

            // add elements dynamically
            person.put("name", "Lem");
            person.put("age", 46);
            person.put("gender", 'M');
            String json = new Gson().toJson(person);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.setStatus(400);
            response.getWriter().write(json);
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

        try {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            HashMap<String, Object> person
                    = new HashMap<String, Object>();
            CategoryDao dao = new CategoryDao();
            CategoryDTO dto = new CategoryDTO();
            String isDetail = request.getPathInfo();
            // get detail
            if (isDetail != null) {
                System.out.println("go here");
                int id = Integer.parseInt(isDetail.split("/")[1]);
                CategoryDTO detail = dao.getDetailById(id);
                if (detail != null) {
                    String json = new Gson().toJson(detail);
                    System.out.println("json" + json);
                    response.getWriter().write(json);
                    return;
                }
                response.setStatus(400);
                person.put("message", "id not exist");
                String json = new Gson().toJson(person);
                System.out.println("json" + json);
                response.getWriter().write(json);
                return;

            }

            ArrayList<CategoryDTO> list = (ArrayList<CategoryDTO>) dao.getList();
            String json = new Gson().toJson(list);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.setStatus(200);
            response.getWriter().write(json);
            return;

        } catch (SQLException ex) {
            Logger.getLogger(APIProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // add elements dynamically
        // add elements dynamically

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
        HashMap<String, Object> person
                = new HashMap<String, Object>();
        try {
            String body = GlobalFunc.parseBody(request);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            Gson g = new Gson();
            CategoryDTO cat = g.fromJson(body, CategoryDTO.class);
            String name = cat.getName();
            String des = cat.getDescription();
            String image = cat.getImage();

            if (!name.equals("") && !des.equals("")) {
                CategoryDTO dto = new CategoryDTO(name, des, image);
                CategoryDao dao = new CategoryDao();
                int isCreate = dao.create(dto);
                person.put("message", "tạo thành công");
                String json = new Gson().toJson(person);
                response.getWriter().write(json);
            } else {
                person.put("message", "invalid data");
                response.setStatus(400);
                String json = new Gson().toJson(person);
                response.getWriter().write(json);
            }
        } catch (Exception e) {
            person.put("message", "invalid data");
            response.setStatus(400);
            String json = new Gson().toJson(person);
            response.getWriter().write(json);
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HashMap<String, Object> person
                = new HashMap<String, Object>();
        try {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            String jwt1 = JwtHelper.generateJwt("admin11");
            System.out.println("token ajdajdjajdj");
            System.out.println("token"+jwt1);
             System.out.println("token"+JwtHelper.decodeJWT(jwt1));
            CategoryDao dao = new CategoryDao();
            CategoryDTO dto = new CategoryDTO();
            Gson g = new Gson();
            String isDetail = request.getPathInfo();
            if (!isDetail.isEmpty()) {
                //get body
                String body = GlobalFunc.parseBody(request);
                CategoryDTO cat = g.fromJson(body, CategoryDTO.class);
                int id = Integer.parseInt(isDetail.split("/")[1]);
                cat.setId(id);
                boolean isDelete = dao.update(cat);
                if (isDelete) {
                    person.put("message", "update success");
                    String json = new Gson().toJson(person);
                    response.getWriter().write(json);
                    return;
                }
                response.setStatus(400);
                person.put("message", "id    not exist");
                String json = new Gson().toJson(person);
                response.getWriter().write(json);
            }
        } catch (Exception e) {
            person.put("message", "invalid data");
            response.setStatus(400);
            String json = new Gson().toJson(person);
            response.getWriter().write(json);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HashMap<String, Object> person
                = new HashMap<String, Object>();
        try {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            CategoryDao dao = new CategoryDao();
            CategoryDTO dto = new CategoryDTO();
            String isDetail = request.getPathInfo();
            if (!isDetail.isEmpty()) {
                int id = Integer.parseInt(isDetail.split("/")[1]);
                boolean isDelete = dao.delete(id);
                if (isDelete) {
                    person.put("message", "delete success");
                    String json = new Gson().toJson(person);
                    response.getWriter().write(json);
                    return;
                }
                response.setStatus(400);
                person.put("message", "id not exist");
                String json = new Gson().toJson(person);
                response.getWriter().write(json);
            }
        } catch (Exception e) {
            person.put("message", "invalid data");
            response.setStatus(400);
            String json = new Gson().toJson(person);
            response.getWriter().write(json);
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
