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
    
}
