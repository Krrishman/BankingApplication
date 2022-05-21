
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Owen Wurster
 */
public class Account {
    static Connection con;
    static Statement stmt;
    static ResultSet rs;
    static ResultSet rp;
    static String accountName, accountType;
    static double pa;
    static int accountNumber;
    static int accountPassword;
    static double accountBalance;
    static int ty;
    static LocalDate locdate = LocalDate.now();
    
    
    
    public static void ins() throws SQLException{
         // SELECT query
         try {
             con = ConnectionSQL.connectDB();
             stmt= con.createStatement();
         } catch(java.lang.ClassNotFoundException e){
             System.out.println(e);
         }
            
         String q1 = "SELECT * FROM `Bank`";
         rs = stmt.executeQuery(q1);
         if (rs.next()){
             System.out.printf("%n%-16s%-10s%-10s%-11s%-12s%-10s%n",
                     "Account_Number","UserName","Password","Type","Balance","Date");
             System.out.printf("     %-11s%-10s%-10s%-11s%-12.2f%-10s%n",
                     rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getDouble(5),rs.getDate(6));
         } else { 
             System.out.println("No such user id is already registered");
         }
    }
    
    public static void createAcc(String type) {
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("For Creating a New Account On Our Bank,"
                  + "\n~We need to have An Unique UserName, Password and how Much What To Deposit."
                  + "\n~For Creating an UserName It can't be no more than 15 charecters."
                  + "\n~For Password It can't be no more than 8 charecters (Only Number)."
                  + "\n~No Space~\n~No Special Charecters~\n");
            
            System.out.println("UserName : ");
            accountName = sc.nextLine();
          
            System.out.println("Password : ");
            accountPassword = sc.nextInt();
          
            System.out.println("$Deposit : ");
            accountBalance = sc.nextDouble();
          
            con = ConnectionSQL.connectDB();
            stmt= con.createStatement();
            String q1 = "INSERT INTO Bank (user_name,pass_code,account_type,account_balance,date)"
                  + " VALUES ('"+accountName+"', '"+accountPassword+"', '"+ type +"', '"+accountBalance+"', '"+locdate+"');";
            int result = stmt.executeUpdate(q1);
            if (result > 0){ System.out.println("Successfully Account Created!");
            } else { 
                System.out.println("Unsucessful Retry!");
            }
        }catch(java.sql.SQLIntegrityConstraintViolationException e){
            System.out.println("UserName Already Exist");
        }
      
        catch(java.lang.ClassNotFoundException e){
            System.out.println(e);
        }
      
        catch(SQLException e){
            System.out.println(e);
        }
            
    }
    
    public static void login(String name,int password) throws SQLException{
         // SELECT query
         try{
             con = ConnectionSQL.connectDB();
             stmt= con.createStatement();
         }catch(java.lang.ClassNotFoundException e){
             System.out.println(e);
         }

            
         String q1 = "SELECT * FROM Bank WHERE user_name='" + name + "' AND pass_code='" + password + "';";
         rs = stmt.executeQuery(q1);
         if (rs.next());
         else 
             throw new ArithmeticException("Invalid UserName Or Password!");
         
         accountNumber = rs.getInt(1);
         accountName = rs.getString(2);
         accountPassword = rs.getInt(3);
         accountType = rs.getString(4);
         accountBalance = rs.getDouble(5);
         
    }
    
    public static void checkBalance() throws SQLException {
        System.out.println("Your balance is: " + rs.getDouble(5));
    }
    
    public static void deposit() throws SQLException{
        
        Scanner sc = new Scanner(System.in);
        double money;
        
        System.out.println("How much would you like to deposit?");
        System.out.println("Enter amount:");
        money = sc.nextDouble();
        
        try{
            con = ConnectionSQL.connectDB();
            stmt= con.createStatement();
            
            String q1 = "UPDATE Bank SET account_balance = account_balance + " + money + " WHERE Bank.account_number = " + accountNumber + ";";
            //int result = stmt.executeUpdate(q1);
            stmt.executeUpdate(q1);
             
        }catch(SQLException e){
            System.out.println(e);
        }
        
        catch(java.lang.ClassNotFoundException e){
            System.out.println(e);
        }
        
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void withdraw() throws SQLException{
        
        Scanner sc = new Scanner(System.in);
        double money;
        
        System.out.println("How much would you like to withdraw?");
        System.out.println("Enter amount:");
        money = sc.nextDouble();
        
        try{
            con = ConnectionSQL.connectDB();
            stmt= con.createStatement();
            
            String q1 = "UPDATE Bank SET account_balance = account_balance - " + money + " WHERE Bank.account_number = " + accountNumber + ";";
            //int result = stmt.executeUpdate(q1);
            stmt.executeUpdate(q1);
             
        }catch(SQLException e){
            System.out.println(e);
        }
        
        catch(java.lang.ClassNotFoundException e){
            System.out.println(e);
        }
        
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void Transfer() throws SQLException{
        
        Scanner sc = new Scanner(System.in);
        double money;
        
        System.out.println("Who You Like To Send Money?");
        System.out.println("Enter Account Number:");
        int o_ac =sc.nextInt();
        
        System.out.println("How Much You Like To send?");
        System.out.println("Enter Amount:");
        money = sc.nextDouble();
        
        try{
            con = ConnectionSQL.connectDB();
            stmt= con.createStatement();
             
            if (accountBalance < money){
                throw new ArithmeticException("Insufficient Balance");
            }
            
            String q2 = "UPDATE Bank SET account_balance = account_balance + "+money+ " WHERE Bank.account_number = "+o_ac+";";
            int result2 = stmt.executeUpdate(q2);
            
            if (result2 == 0){
                throw new ArithmeticException("Invalid Account Number");
            }
            
            String q1 = "UPDATE Bank SET account_balance = account_balance - "+money+ " WHERE Bank.account_number = "+accountNumber+";";
            int result = stmt.executeUpdate(q1);

            if (result2 ==1 && result == 1){
                System.out.println("We take money from account. successfully send to His Account.");
            }

        }catch(SQLException e){
            System.out.println(e);
        }
        
        catch(java.lang.ClassNotFoundException e){
            System.out.println(e);
        }
        
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void Profile() throws SQLException {
        Scanner sc = new Scanner(System.in);
        
        System.out.printf("%n%-16s%-10s%-10s%-11s%-12s%-10s%n",
                "Account_Number","UserName","Password","Type","Balance","Date");
        System.out.printf("     %-11s%-10s%-10s%-11s%-12.2f%-10s%n",
                rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getDouble(5),rs.getDate(6));
        sc.nextLine();
    }
}
