/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Dadavai
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;

public class ConnectionSQL {
    // Connection instance 
    static Connection con;
    static Statement stmt;
    static ResultSet rs;
    
    public static Connection connectDB() throws ClassNotFoundException{ 
        try { 
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection( 
                    "jdbc:mysql://sql5.freesqldatabase.com:3306/sql5493778", "sql5493778", "E8NZuyfi2B");
        } 
        catch (SQLException e) { System.out.println(e); } 
        catch (ClassNotFoundException e) { System.out.println(e); }
        return con;
    }
   
}
