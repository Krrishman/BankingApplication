/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Owen Wurster
 */
import java.sql.*; 
import java.util.Scanner;

public class Main {
    
    
    public static void appLoop() throws SQLException  {
        
        // Used for account info
        String name,accountType;
        int password, accountNumber;
        double balance, amount;
        
        Scanner sc = new Scanner(System.in);
        
        // User's choice
        int choice = 0;
        int choice2 = 0;
        
        while (choice != 3) {
            
            System.out.println("(1) Register for a new account");
            System.out.println("(2) Login");
            System.out.println("(3) Exit");
            System.out.println("Enter: ");
                
                choice = sc.nextInt();
                
                switch (choice) {
                    case 1:
                        // Start of Registration
                        System.out.println("Would you like to create a Savings or Checking account?");
                        System.out.println("(1) Checking");
                        System.out.println("(2) Savings");
                        System.out.println("(3) Exit");
                        
                        choice2 = sc.nextInt();
                        
                        switch (choice2) {
                            case 1:
                                // Create Checking Account
                                Account.createAcc("Checking");
                                break;
                            case 2:
                                // Create Savings Account
                                Account.createAcc("Savings");
                                break;
                            default:
                                // Return
                                break;
                        }
                        // End of Registration
                        break;
                    case 2:
                        // Start of Login

                        System.out.println("UserName : ");
                        sc.nextLine();
                        name = sc.nextLine();
                        System.out.println("Password : ");
                        password=sc.nextInt();
                        Account.login(name, password);
                        System.out.println("Successfully Logged IN\n");
                        
                            System.out.println("(1) Check Balance");
                            System.out.println("(2) Withdraw");
                            System.out.println("(3) Deposit");
                            System.out.println("(4) Transfer");
                            System.out.println("(5) Profile");
                            System.out.println("(6) Log Out");
                            
                            choice2 = sc.nextInt();
                        
                            switch (choice2) {
                                case 1:
                                    // Check Balance
                                    Account.checkBalance();
                                    break;
                                case 2:
                                    // Withdraw
                                    Account.withdraw();
                                    break;
                                case 3:
                                    // Deposit
                                    Account.deposit();
                                    break;
                                case 4:
                                    // Transfer
                                    Account.Transfer();
                                    break;
                                case 5:
                                    // Profile
                                    Account.Profile();
                                    break;
                                default:
                                    // Log Out
                                    break;
                            }
                        // End of Login
                        break;
                    default:
                        // Exit
                        return;
                        
                }
        }
    }
    
    public static void main(String[] args) throws SQLException {

        System.out.println("~ Hello, Wellcome To Our Free Banking App ~");
        System.out.println("---------------------------------------------\n");
        
        appLoop();
    } 
}


//Host: sql5.freesqldatabase.com
//Database name: sql5493778
//Database user: sql5493778
//Database password: E8NZuyfi2B
//Port number: 3306
//jdbc:mysql://localhost:3306/mydata
//com.microsoft.sqlserver
//jdbc.SQLServerDriver
//com.mysql.cj.jdbc.Driver
//com.microsoft.sqlserver.jdbc.SQLServerDriver
//com.microsoft.sql.htc