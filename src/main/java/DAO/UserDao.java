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

public class UserDao {

    Connection conn = DBProvider.getConnection();

    public boolean create(UserDTO user) {
        boolean result = false;
        try {
            String sql = "INSERT INTO users(username, password, email, role) VALUES(?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getEmail());
            pst.setString(4, user.getPassword());
            int ketqua = pst.executeUpdate();
            if(ketqua >0) {
                result = true;
            } 

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}
