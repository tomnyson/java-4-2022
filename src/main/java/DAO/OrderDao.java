/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Item;
import DTO.OrderDTO;
import Utils.DBProvider;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author tomnyson
 */
public class OrderDao {

    Connection conn = DBProvider.getConnection();

    public boolean insert(OrderDTO order) {
        try {
            String sql = "INSERT INTO order (userId, customerName, addressShip, phone"
                    + ", total, createAt)"
                    + " VALUES(?, ?, ?, ?, ?, ?)";
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                pst.setInt(1, order.getUserId());
                pst.setString(2, order.getCustomerName());
                pst.setString(3, order.getAddressShip());
                pst.setString(4, order.getPhone());
                pst.setFloat(5, order.getTotal());
                pst.setDate(5, (Date) order.getCreateAt());
                int result = pst.executeUpdate();
                long orderId = 0;
                if (result > 0) {
                    ResultSet generatedKeys = pst.getGeneratedKeys();

                    if (generatedKeys.next()) {
                        orderId = generatedKeys.getInt(1);
                    }
                    if (orderId > 0) {
                        ArrayList<Item> items = order.getItems();
                        for (Item item : items) {
                            String sqlDetail = "INSERT INTO orderDetail (orderId, productId, price, quantity) VALUES(?, ?, ?, ?, ?)";
                            pst.setInt(1, (int) orderId);
                            pst.setInt(2, (int) item.getMaSP());
                            pst.setInt(3, (int) item.getPrice());
                            pst.setInt(4, (int) item.getSoluong());
                            pst.executeUpdate();
                        }

                    }

                    return true;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;

    }
}
