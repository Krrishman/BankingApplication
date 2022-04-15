



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Dadavai
 */

public class LoginReg { 
    
    static Connection con = ConnectionSQL.connectDB();
    static Statement stmt;
    static ResultSet rs;
    static String na;
    static int pa;
    static int ac;
    static int bl;
    
    public static void ins() throws SQLException{
         // SELECT query
             stmt= con.createStatement();
            
            String q1 = "SELECT * FROM `Bank`";
            //PreparedStatement st= con.prepareStatement(q1);
             rs = stmt.executeQuery(q1);
            if (rs.next())
            {
                System.out.println("account_number : " + rs.getInt(1));
                System.out.println("user_name : " + rs.getString(2));
                System.out.println("account_balance :" + rs.getInt(3));
                System.out.println("pass_code :" + rs.getString(4));
                //System.out.println( rs);
            }
            else
            {
                System.out.println("No such user id is already registered");
            }
}
    public static void createAcc(String na,double bl,int pa) throws SQLException{
         // SELECT query
             stmt= con.createStatement();
            
            String q1 = "INSERT INTO Bank "
                    + "(user_name, account_balance, pass_code)"
                    + " VALUES ('"+na+"', '"+bl+"', '"+pa+"');";
            int result = stmt.executeUpdate(q1);
             //rs = stmt.executeQuery(q1);
            if (result > 0){
                System.out.println("successfully inserted");}
            else{
                System.out.println("unsucessful insertion ");}
}
    public static void login(String na,int pa) throws SQLException{
         // SELECT query
             stmt= con.createStatement();
            
            String q1 = "SELECT * FROM Bank WHERE user_name='"+na+"' AND pass_code='"+pa+"'";
            //PreparedStatement st= con.prepareStatement(q1);
             rs = stmt.executeQuery(q1);
            if (rs.next())
            {
                System.out.println("account_number : " + rs.getInt(1));
                System.out.println("user_name : " + rs.getString(2));
                System.out.println("account_balance :" + rs.getInt(3));
                System.out.println("pass_code :" + rs.getString(4));
                
            }
            else
            {
                System.out.println("No such user is registered");
            }
}
}
