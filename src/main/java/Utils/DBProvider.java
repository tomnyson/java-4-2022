/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author tomnyson
 */
public class DBProvider {
    //  change username, password, dbname = your local

    public static Connection getConnection() {

        String dbURL = "jdbc:mysql://192.168.64.2:3306/db_java4";
        String userName = "dev";
        String password = "dev";

        Connection conn = null;
        try {
            // call driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect db success");

        } catch (Exception e) {
            System.out.println("connect db failed");
            e.printStackTrace();
        }
        return conn;
    }

}
