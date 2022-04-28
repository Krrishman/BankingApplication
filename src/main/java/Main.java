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
                    
                    if (num2==1){
                        System.out.printf("%n%-16s%-10s%-10s%-11s%-12s%-10s%n",
                        "Account_Number","UserName","Password","Type","Balance","Date");
                       System.out.printf("     %-11s%-10s%-10s%-11s%-12.2f%-10s%n",
                        ac,na,pa,ty,am,ti);
                       sc.nextLine();
                       y =sc.nextLine();
                    }
                    else if (num2==2){
                    System.out.println("You Have Only "+am+"$ Right Now!");
                        sc.nextLine();
                        y =sc.nextLine();
                    
                    }
                    else if (num2==3){
                        try{
                        System.out.println("How Much You Like To Withdraw?");
                        System.out.println("Enter Amount:");
                        bl = sc.nextDouble();
                        String x=ty;
                        if (bl > am){throw new ArithmeticException("Insufficient Balance");}
                        if (ty.equals("Savings") && bl > 500){throw new ArithmeticException("You're Using Savings account.\nYou have a daily Limit of 500$.");}
                        LoginReg.withdraw(ac, bl,"-");
                        System.out.println("successfully withdraw");
                        }catch(Exception e){System.out.println(e);}
                        sc.nextLine();
                        y =sc.nextLine();
                    } 
                    else if (num2==4){
                    try{
                        System.out.println("How Much You Like To Deposit?");
                        System.out.println("Enter Amount:");
                        bl = sc.nextDouble();
                        LoginReg.withdraw(ac, bl,"+");
                        System.out.println("successfully Deposit");
                         }catch(Exception e){System.out.println(e);}
                        sc.nextLine();
                        y =sc.nextLine();
                    } 
                    else if (num2==5){
                        System.out.println("Who You Like To Send Money?");
                        System.out.println("Enter Account Number:");
                        int o_ac =sc.nextInt();
                        System.out.println("How Much You Like To send?");
                        System.out.println("Enter Amount:");
                        bl = sc.nextDouble();
                        LoginReg.Transfer(ac,bl,o_ac,am);
                        sc.nextLine();
                        y =sc.nextLine();
                    }
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
                try{
                System.out.println("(1) Checking");
                System.out.println("(2) Savings");
                num2 = sc.nextInt();
                if (num2==1){
                     try{
                        System.out.println("For Creating a New Account On Our Bank,"
                        + "\n~We need to have An Unique UserName, Password and how Much What To Deposit."
                        + "\n~For Creating an UserName It can't be no more than 15 charecters."
                        + "\n~For Password It can't be no more than 8 charecters (Only Number)."
                        + "\n~No Space~\n~No Special Charecters~\n");
                        System.out.println("UserName : ");
                        sc.nextLine();
                        na=sc.nextLine();
                        System.out.println("Password : ");
                        pa=sc.nextInt();
                        System.out.println("$Deposit : ");
                        bl=sc.nextDouble();
                        LoginReg.createAcc(na,bl,pa,"Checking");
                        }catch(Exception e){System.out.println("Invalid Entry");}
                        sc.nextLine();
                        y =sc.nextLine();
                    }
                else if (num2==2){
                        System.out.println("For Creating a New Account On Our Bank,"
                        + "\n~We need to have An Unique UserName, Password and how Much What To Deposit."
                        + "\n~For Creating an UserName It can't be no more than 15 charecters."
                        + "\n~For Password It can't be no more than 8 charecters (Only Number)."
                        + "\n~No Space~\n~No Special Charecters~\n");
                        System.out.println("UserName : ");
                        sc.nextLine();
                        na=sc.nextLine();
                        System.out.println("Password : ");
                        pa=sc.nextInt();
                        System.out.println("$Deposit : ");
                        bl=sc.nextDouble();
                        LoginReg.createAcc(na,bl,pa,"Savings");
                        sc.nextLine();
                        y =sc.nextLine();
                    }
                else{ System.out.println("~~~\n "); break;}
                }catch(java.util.InputMismatchException e){System.out.println(e);}
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