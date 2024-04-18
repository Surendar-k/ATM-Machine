import java.util.Scanner;
import java.util.*;

public class ATM{
    public static void main(String[] args){
        int pin=2004;       //pin number
        int balance=1000;   //balance
        int deposit=0;      //deposit
        int withdraw=0;     //withdraw
        int totalbalance;   //totalbalance
        int receipt;     //receipt

        String name;        //user name
        Scanner sc=new Scanner(System.in);

        // Entering the PIN NUMBER
        System.out.println("\n"+ "$$$ This is a ATM Bank $$$" +"\n");

        System.out.println("Enter Your PIN Number: ");
        int password=sc.nextInt();      // input by the user

        if(password==pin){
            System.out.println("Enter Your Name ");
            name=sc.next();
            System.out.println("\n"+ "------Hello "+name+"------");

            while(true){
                System.out.println("Enter 1 to check your Balance");
                System.out.println("Enter 2 to Deposit");
                System.out.println("Enter 3 to Withdraw");
                System.out.println("Enter 4 to print receipt");
                System.out.println("Enter 5 to end the transaction");
                System.out.println("--------------------------------");
                int options=sc.nextInt();
                switch(options) {
                    case 1:
                        System.out.println("->Your Current Balance is " + balance+"\n");
                        break;
                    case 2:
                        System.out.println("Enter your amount to deposit ");
                        deposit = sc.nextInt();
                        balance = balance + deposit;
                        System.out.println("\n"+"->Your amount is deposited successfully");
                        break;
                    case 3:
                        System.out.println("Enter amount to Withdraw");
                        withdraw = sc.nextInt();
                        if (withdraw > balance) {
                            System.out.println("*** You have not enough balance to do this transaction*** ");
                        } else {
                            System.out.println("\n"+"->Your current Withdrawl is " + withdraw);
                            balance = balance - withdraw;
                        }
                        break;
                    case 4:
                        System.out.println("===Do You need receipt?===");
                        System.out.println("Enter 1 to print the receipt");
                        System.out.println("Enter 0 to no need");
                        receipt = sc.nextInt();
                        if (receipt == 1) {
                            totalbalance = balance + deposit - withdraw;
                            System.out.println("\n"+"*******************************");
                            System.out.println("$$$ This is a ATM Bank $$$");
                            System.out.println("->Available Balance: " + balance);
                            System.out.println("->Amount deposited: " + deposit);
                            System.out.println("->Amount withdraw:" + withdraw);
                            System.out.println("->Your total balance is: " + totalbalance);
                            System.out.println("*****************************");
                        } else {
                            System.out.println("# Thank you for this transaction #");
                        }
                        break;
                }
                        if(options==5){
                            System.out.println("Your transaction is successfully ended");
                            break;
                }
            }
        }
        else{
            System.out.println("Your PIN Number is incorrect");
            System.out.println("Please Try again");
        }
    }
}
