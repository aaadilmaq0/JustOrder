/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package justorder;

import java.sql.*;
import java.util.AbstractMap;
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
        dbHelper = new DatabaseHelper();
        return dbHelper;
    }

    public List<Map.Entry<String, Integer>> getAllItems() {
        try {
            List<Map.Entry<String, Integer>> items = new ArrayList<>();
            
            Connection c = getCon();
            Statement st = c.createStatement();
            ResultSet s = st.executeQuery("select * from items");
            while(!s.next()){
                Map.Entry<String, Integer> me = new AbstractMap.SimpleEntry<>(s.getString(0), Integer.parseInt(s.getString(1)));
                items.add(me);
            }
                      return items;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void addAdmin(String name,String email,String phone, String username, String password){
        
    }
    
    public void addCustomer(String name,String email,String phone,String username,String password){
        
    }
    public void addItem(String name, double price) {
        try {
            Connection c = getCon();
            PreparedStatement prepareStatement = c.prepareStatement("insert into items values("+name+","+price+");" );
            prepareStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean checkAdmin(String username,String password){
        return true;
    }

    public boolean checkCustomer(String username,String passsword){
        return true;
    }
    public void removeItem(String name, double price) {
          
    }
}
