/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Dadavai
 */
import java.sql.*; 
import java.io.*;
public class ConnectionSQL {
    // Connection instance 
    static Connection con;
    static Statement stmt;
    static ResultSet rs;
    
    public static Connection connectDB() throws SQLException, ClassNotFoundException
    { 
        try { 
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection( 
                    "jdbc:mysql://sql5.freesqldatabase.com:3306/sql5488014", "sql5488014", "qTxEvBpucl");
        } 
        catch (SQLException e) { System.out.println(e); } 
        return con;
    }
   
}
