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
import DTO.ProductDTO;
import DTO.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    Connection conn = DBProvider.getConnection();

    public int create(ProductDTO product) {
        boolean result = false;
        int id = 0;
        try {
            String sql = "INSERT INTO product(name, description, image, price, categoryId)"
                    + " VALUES(?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, product.getName());
            pst.setString(2, product.getDescription());
            pst.setString(3, product.getImage());
            pst.setFloat(4, product.getPrice());
            pst.setInt(5, product.getCategoryId());

            int ketqua = pst.executeUpdate();
            if (ketqua > 0) {
                if (ketqua > 0) {
                    // Retrieves any auto-generated keys created as a result of executing this Statement object

                    ResultSet generatedKeys = pst.getGeneratedKeys();

                    if (generatedKeys.next()) {
                        id = generatedKeys.getInt(1);
                    }
                }
                return id;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }

    public ProductDTO getDetailById(int id) {
        ProductDTO cat = new ProductDTO();
        try {
            String sql = "SELECT * FROM product where id=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rst = pst.executeQuery();
            if (rst.next()) {
                cat.setId(rst.getInt("id"));
                cat.setName(rst.getString("name"));
                cat.setDescription(rst.getString("description"));
                cat.setImage(rst.getString("image"));
                cat.setPrice(rst.getFloat("price"));    
                cat.setCategoryId(rst.getInt("categoryId"));

                return cat;
            }
            return null;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ProductDTO> getList() throws SQLException {
        List<ProductDTO> list = new ArrayList<ProductDTO>();
        try {
            String sql = "select * from product ORDER BY id DESC";
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet resultSet = pst.executeQuery();
                while (resultSet.next()) {
                    ProductDTO product = new ProductDTO();
                    product.setId(resultSet.getInt("id"));
                    product.setName(resultSet.getString("name"));
                    product.setDescription(resultSet.getString("description"));
                    product.setImage(resultSet.getString("image"));
                    product.setPrice(resultSet.getFloat("price"));
                    product.setCategoryId(resultSet.getInt("categoryId"));
                    list.add(product);
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
            System.out.println("ketqua" + cat.getId());
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
