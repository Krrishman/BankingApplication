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
    
    public static void main(String[] args) throws SQLException {
        String na;
        int pa;
        int ac;
        double bl;
        double am;
        String ty;
        Date ti;
        Scanner sc = new Scanner(System.in);
        int num = 0;
        int num2 = 0;
        String y;

        System.out.println("~ Hello, Wellcome To Our Free Banking App ~");
        System.out.println("---------------------------------------------\n");
        
        
        //here?
        
while (num !=3){
                num2 = 0;
                System.out.println("(1) Login");
                System.out.println("(2) Register For New Account");
                System.out.println("(3) Exit");
                System.out.println("Enter: ");
                num = sc.nextInt();
            
            if (num==1){
                        System.out.println("UserName : ");
                        sc.nextLine();
                        na=sc.nextLine();
                        System.out.println("Password : ");
                        pa=sc.nextInt();
                        LoginReg.login(na, pa);
                        System.out.println("Successfully Logged IN\n");
                        
                while (num2 !=7){
                   LoginReg.login(na, pa);
                    ac = LoginReg.rs.getInt(1);
                    na = LoginReg.rs.getString(2);
                    pa = LoginReg.rs.getInt(3);
                    ty = LoginReg.rs.getString(4);
                    am = LoginReg.rs.getDouble(5);
                    ti = LoginReg.rs.getDate(6);
                    try{
                    System.out.println("(1) Profile");
                    System.out.println("(2) Check Balance");
                    System.out.println("(3) Withdraw");
                    System.out.println("(4) Deposit");
                    System.out.println("(5) Send Money");
                    System.out.println("(6) Balance History");
                    System.out.println("(7) LogOut");
                    System.out.println("Entry: ");
                    num2 = sc.nextInt();
                    }catch(Exception e){System.out.println(e);}
                    if (num2==1){}
                    else if (num2==2){
                    System.out.println("You Have Only "+am+"$ Right Now!");
                        sc.nextLine();
                        y =sc.nextLine();
                    
                    }
                    else if (num2==3){}
                    else if (num2==4){}
                    else if (num2==5){}
                    else if (num2==6){
                        System.out.println("~Coming Soon!~\n");
                        sc.nextLine();
                        y =sc.nextLine();
                    }
                    else if (num2==7){
                        System.out.println("You're Logged Out.\n");
                        break;
                        
                        
                        
                        
                    }
                    else {System.out.println("Wrong Input. ~Try Again~");
                        sc.nextLine();
                        y =sc.nextLine();}
                    
                }
                
              
            }
            else if(num==2){
                System.out.println("(1) Checking");
                System.out.println("(2) Savings");
                num2 = sc.nextInt();
                if (num2==1){}
                else if (num2==2){}
                else{ System.out.println("~~~\n ");break;}
            }
}
}
}
//sql5.freesqldatabase.com
//sql5485641
//CmwSKSz67l
//3306
//jdbc:mysql://localhost:3306/mydata
//com.microsoft.sqlserver
//jdbc.SQLServerDriver
//com.mysql.cj.jdbc.Driver
//com.microsoft.sqlserver.jdbc.SQLServerDriver
//com.microsoft.sql.htc