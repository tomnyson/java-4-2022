/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author tomnyson
 */
import Utils.DBProvider;
import DTO.CategoryDTO;
import DTO.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {

    Connection conn = DBProvider.getConnection();

    public boolean create(CategoryDTO cat) {
        boolean result = false;
        try {
            String sql = "INSERT INTO category(name, description, image) VALUES(?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, cat.getName());
            pst.setString(2, cat.getDescription());
            pst.setString(3, cat.getImage());
            int ketqua = pst.executeUpdate();
            if (ketqua > 0) {
                result = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public CategoryDTO getDetailById(int id) {
        CategoryDTO cat = new CategoryDTO();
        try {
            String sql = "SELECT * FROM category where id=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rst = pst.executeQuery();
            if (rst.next()) {
                cat.setId(rst.getInt("id"));
                cat.setName(rst.getString("name"));
                cat.setDescription(rst.getString("description"));
                cat.setImage(rst.getString("image"));
            }
            return cat;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<CategoryDTO> getList() throws SQLException {
        List<CategoryDTO> list = new ArrayList<CategoryDTO>();
        try {
            String sql = "select * from category";
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet resultSet = pst.executeQuery();
                while (resultSet.next()) {
                    CategoryDTO category = new CategoryDTO();
                    category.setId(resultSet.getInt("id"));
                    category.setName(resultSet.getString("name"));
                    category.setDescription(resultSet.getString("description"));
                    category.setImage(resultSet.getString("image"));
                    list.add(category);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
     public boolean update(CategoryDTO cat) {
        boolean result = false;
        try {
            String sql = "UPDATE category set name =?, description=?, image =? where id=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, cat.getName());
            pst.setString(2, cat.getDescription());
            pst.setString(3, cat.getImage());
             pst.setInt(4, cat.getId());
            int ketqua = pst.executeUpdate();
            if (ketqua > 0) {
                result = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
     
     public boolean delete(int id) {
        boolean result = false;
        try {
            String sql = "DELETE from category where id=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            int ketqua = pst.executeUpdate();
            if (ketqua > 0) {
                result = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }


}
