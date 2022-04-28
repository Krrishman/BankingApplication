



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

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
    static ResultSet rp;
    static String na;
    static double pa;
    static int ac;
    static double bl;
    static int ty;
    static LocalDate locdate = LocalDate.now();
    
    public static void ins() throws SQLException{
         // SELECT query
             stmt= con.createStatement();
            
            String q1 = "SELECT * FROM `Bank`";
             rs = stmt.executeQuery(q1);
            if (rs.next())
            {
                System.out.printf("%n%-16s%-10s%-10s%-11s%-12s%-10s%n",
                        "Account_Number","UserName","Password","Type","Balance","Date");
                System.out.printf("     %-11s%-10s%-10s%-11s%-12.2f%-10s%n",
                        rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getDouble(5),rs.getDate(6));
            }
            else{ System.out.println("No such user id is already registered");}
}
     public static void createAcc(String na,double bl,int pa,String ty) throws SQLException{
         // SELECT query
             stmt= con.createStatement();
            try{
            String q1 = "INSERT INTO Bank (user_name,pass_code,account_type,account_balance,date)"
                    + " VALUES ('"+na+"', '"+pa+"', '"+ty+"', '"+bl+"', '"+locdate+"');";
            int result = stmt.executeUpdate(q1);
            if (result > 0){ System.out.println("Successfully Account Created!");}
            else{ System.out.println("Unsucessful Retry!");}
            }catch(java.sql.SQLIntegrityConstraintViolationException e){System.out.println("UserName Already Exist");}
            catch(SQLException e){System.out.println(e);}
            
}
    public static void login(String na,int pa) throws SQLException{
         // SELECT query
             stmt= con.createStatement();
            String q1 = "SELECT * FROM Bank WHERE user_name='"+na+"' AND pass_code='"+pa+"';";
             rs = stmt.executeQuery(q1);
             if (rs.next());
             else{throw new ArithmeticException("Invalid UserName Or Password!");}
         
             
}
}
