/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainPackage;
import java.sql.*;

/**
 *
 * @author D.Dell
 */
public class DBConnection {
    public static final String DB_URL = "jdbc::sqlite:database/login.db";
    
    public Connection connect(){
        Connection conn =null;
        try {
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Connected to SQLite Database");
        } catch(SQLException e) {
            System.out.println("Error connecting database: "+ e.getMessage());
        }
        return conn;
    }
  
    public boolean verifyLogin (String username, String password){
        String query = "SELECT + FROM users WHERE username = ? AND password = ?";
        
        try (Connection conn = DriverManager.getConnection(query);
          PreparedStatement pstmt = conn.prepareStatement(query)){
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            
            ResultSet rs = pstmt.executeQuery();
            
            return rs.next();
            
        }catch(SQLException e){
            System.out.println("Login Failed: " + e.getMessage());
            return false;
        }
    }
}

