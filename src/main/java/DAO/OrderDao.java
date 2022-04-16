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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author tomnyson
 */
public class OrderDao {

    public boolean insert(OrderDTO order) {
        Connection conn = DBProvider.getConnection();
        try {
            String sql = "INSERT INTO orders(customerName, phone, addressShip, total, status, createAt) VALUES(?, ?, ?, ?,?, ?)";
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                pst.setString(1, order.getCustomerName());
                pst.setString(2, order.getPhone());
                pst.setString(3, order.getAddressShip());
                pst.setFloat(4, order.getTotal());
                pst.setString(5, "PENDING");
                pst.setDate(6, java.sql.Date.valueOf(java.time.LocalDate.now()));
                int result = pst.executeUpdate();
                long orderId = 0;
                if (result > 0) {
                    ResultSet generatedKeys = pst.getGeneratedKeys();

                    if (generatedKeys.next()) {
                        orderId = generatedKeys.getInt(1);
                    }

                    if (orderId > 0) {
                        Integer orderIdConvert = (int) (long) orderId;
                        ArrayList<Item> items = order.getItems();
                        String sqlDetail2 = "INSERT INTO order_details (orderId, productId, price, quantity) VALUES(?, ?, ?, ?)";
                        PreparedStatement pst1 = conn.prepareStatement(sqlDetail2);

                        for (Item item : items) {
                            pst1.setInt(1, orderIdConvert);
                            pst1.setInt(2, item.getMaSP());
                            pst1.setFloat(3,item.getPrice());
                            pst1.setInt(4, item.getSoluong());
                            pst1.executeUpdate();
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
