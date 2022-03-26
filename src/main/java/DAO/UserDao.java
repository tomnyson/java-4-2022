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
import DTO.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {

    Connection conn = DBProvider.getConnection();

    public boolean create(UserDTO user) {
        boolean result = false;
        try {
            String sql = "INSERT INTO users(username, password, email, role) VALUES(?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getEmail());
            pst.setString(4, user.getRole());
            int ketqua = pst.executeUpdate();
            if (ketqua > 0) {
                result = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean isLogin(String username, String password) {
        boolean result = false;
        try {
            String sql = "SELECT * FROM users where username=? and password = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rst = pst.executeQuery();
            if (rst.next()) {
                result = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public UserDTO getDetailByUserName(String username) {
        UserDTO user = new UserDTO();
        try {
            String sql = "SELECT * FROM users where username=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            ResultSet rst = pst.executeQuery();
            if (rst.next()) {
                user.setUsername(rst.getString("email"));
                user.setPassword(rst.getString("password"));
                user.setRole(rst.getString("role"));
            }
            return user;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    public boolean isUserExist(String username) {
        boolean result = false;
        try {
            String sql = "SELECT * FROM users where username=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            ResultSet rst = pst.executeQuery();
            if (rst.next()) {
                result = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}
