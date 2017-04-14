/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package justorder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kunall17
 */
public class DatabaseHelper {

    private static DatabaseHelper dbHelper;

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/EMP";
    Connection conn = null;
    Statement stmt = null;
    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";

    private Connection getCon() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            return conn;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private DatabaseHelper() {
    }

    public static DatabaseHelper getHelper() {
        return dbHelper;
    }

    public List<Map.Entry<String, Integer>> getAllItems() {
        List<Map.Entry<String, Integer>> items = new ArrayList<>();

        return items;
    }

    public void addItem(String name, double price) {

    }

    public void saveUser(User user) {

    }

    //public boolean checkUser(User user) {

    //}

    public void removeItem(String name, double price) {

    }
}
