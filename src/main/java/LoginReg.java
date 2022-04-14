
import java.sql.Connection;
import java.sql.PreparedStatement;
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
    
    public LoginReg(){
    //Connection con = null; 
    //PreparedStatement p = null; 
    //con = ConnectionSQL.connectDB(); 
    }
    
    public void ins() throws SQLException{
        Statement stmt = con.createStatement();
        int result = stmt.executeUpdate("INSERT INTO `Bank` (`account_number`, `user_name`, `account_balance`, `pass_code`) VALUES ('1034', 'roy', '100', '2211');");
        if (result > 0)
            System.out.println("successfully inserted");
        else
            System.out.println("unsucessful insertion ");
}
}
