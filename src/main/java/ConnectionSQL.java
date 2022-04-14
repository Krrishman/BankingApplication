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
    public static Connection connectDB() throws SQLException, ClassNotFoundException
    { 
        try { 
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection( 
                    "jdbc:mysql://sql5.freesqldatabase.com:3306/sql5485641", "sql5485641", "CmwSKSz67l");
            System.out.println("Connection sucess!");
           Statement stmt = con.createStatement();
             
            // SELECT query
            String q1 = "SELECT * FROM `Bank`";
            ResultSet rs = stmt.executeQuery(q1);
            if (rs.next())
            {
                System.out.println("account_number : " + rs.getInt(1));
                System.out.println("user_name : " + rs.getString(2));
                System.out.println("account_balance :" + rs.getInt(3));
                System.out.println("pass_code :" + rs.getString(4));
            }
            else
            {
                System.out.println("No such user id is already registered");
            }
        } 
        catch (SQLException e) {
            System.out.println("Connection failed!");
            System.out.println(e); 

        } 
        return null;
    }
    /*
    public void insertdata() throws SQLException{
        
        Statement stmt = con.createStatement();
        int result = stmt.executeUpdate("INSERT INTO `Bank` (`account_number`, `user_name`, `account_balance`, `pass_code`) VALUES ('1034', 'roy', '100', '2211');");
        if (result > 0)
            System.out.println("successfully inserted");
        else
            System.out.println("unsucessful insertion ");
    
    }*/
   
}
