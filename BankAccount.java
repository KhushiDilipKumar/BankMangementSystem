package Bank_Management;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Random;
class BankAccount
{
    int balance=0; //The money which we have in account
    int previousTransaction; //For showing the last previous transaction done by user
    String CustomerName; //For customer name
    String CustomerId; //For ID of the customer of that bank
    int transact[]=new int[100000];
    int j=0;

    BankAccount(String cname, String cId) //cname = customer name and cId = customer Id
    {
        CustomerName = cname;
        CustomerId = cId;
    }
    void deposit(int amount)
    {
        Scanner scan = new Scanner(System.in);
        if((amount>0)&&(amount<=50000)) //To avoid unnecessary operations condition to check for amount to be 0
        {
            Random rand1 = new Random();
            int x1 = rand1.nextInt((9999-100)+1)+10;
            System.out.println("Your One time Password is: "+x1);
            System.out.println("Don't Share it with anyone! Keep it safe with you for further transactions");
            System.out.print("Enter OTP sent on your registered mobile number: ");
            int OTP = scan.nextInt();
            if(OTP==x1)
            {
                balance = balance+amount;
                previousTransaction = amount;
                transact[j]=previousTransaction;
                j++;
                System.out.println("Amount Deposited Successfully.");
                System.out.println("----------------------------------------------------------------");
                System.out.println("Updated Balance: "+balance);
                System.out.println("----------------------------------------------------------------");
            }
            else
            {
                System.out.println("Incorrect OTP entered! Transaction Declined!");
            }
        }
        else if(amount<0)
        {
            System.out.println("**********Warning! You need to enter a positive amount****************");
            System.out.println("Enter a positive and a valid amount.");
        }
        else if(amount==0)
        {
            System.out.println("0 rs cannot be Deposited!");
        }
        else if(amount>50000)
        {
            System.out.println("Amount more than 50000 cannot be deposited in one shot! ");
        }
        else
        {
            System.out.println("**********Warning! You can only Deposit 50000 in one shot****************");
            System.out.println("You exceed the given limit.");
        }
    }
    void withdraw(int amount)
    {
        int x1;
        Scanner scan = new Scanner(System.in);
        if((amount>0)&&(balance>=amount)&&(amount<=50000))
        {
            Random rand = new Random();
            x1 = rand.nextInt((9999 - 100) + 1)+10;
            System.out.println("Your One time Password is: "+x1);
            System.out.println("Don't Share it with anyone! Keep it safe with you for further transactions");
            System.out.print("Enter OTP sent on your registered mobile number: ");
            int OTP = scan.nextInt();
            if(OTP==x1)
            {
                balance = balance-amount;
                previousTransaction = -amount;
                transact[j]=previousTransaction;
                j++;
                System.out.println("Amount Withdrawn Successfully.");
                System.out.println("----------------------------------------------------------------");
                System.out.println("Remaining Balance : "+balance);
                 System.out.println("----------------------------------------------------------------");
            }
            else
            {
                System.out.println("Incorrect OTP entered! Transaction Declined!");
            }
        }
        else if(amount==0)
        {
            System.out.println("INR 0 Cannot be Withdrawn.");
        }
        else if(amount>50000)
        {
            System.out.println("You Cannot Withdraw more than 50000 in one go!");
        }
        else if(amount<0)
        {
            System.out.println("Negated Amount Cannot be Withdrawn.");
        }
        else
        {
            System.out.println("You have not enough balance to withdraw entered Amount.");
        }
    }

    void terms_conditions()
    {
         try {  
            // Create f1 object of the file to read data  
            File f1 = new File("C:/Users/Tushar Gandhi/Desktop/Bank_Management/Terms and Condition.txt");    
            Scanner dataReader = new Scanner(f1);  
            while (dataReader.hasNextLine())// obj.hasNextLine() will read the file until the end of file 
            {  
                String fileData = dataReader.nextLine();  
                System.out.println(fileData);  
            }  
            dataReader.close();  
        } 
        catch (FileNotFoundException exception) 
        {  
            System.out.println("Unexcpected error occurred!");  
            exception.printStackTrace();  
        }  
    }
    void load()
    {
        try
	    {	
		    new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
	    }
        catch(Exception E) 
		{
			System.out.println("Error");
		}
    }
    void showMenu()
    {
        char option = '\0';
        int n;
        Scanner sc = new Scanner(System.in);
        load();
        System.out.println("Welcome "+CustomerName);
        System.out.println("Your ID is  "+CustomerId); 
        System.out.println("\n");
        System.out.println("-------------------------------------------------------------------------");
        outer: do
        {
            System.out.println("A. Check Current Balance");
            System.out.println("B. Deposit Money");
            System.out.println("C. Withdraw Money");
            System.out.println("D. Show Full Transaction History");
            System.out.println("E. Terms and Conditions 2021");
            System.out.println("F. Exit");
            System.out.println("========================================================================");
            System.out.print("Enter your choice: ");
            option = sc.next().charAt(0);
            switch(option)
            {
                case 'A':
                System.out.println("----------------------------------------------------------------");
                System.out.println("Balance = "+balance);
                System.out.println("----------------------------------------------------------------");
                System.out.println("\n");
                System.out.println("Do you want to Continue using our system? (1-Yes) (0-No) ");
                n = sc.nextInt();
                if(n==1)
                {
                    load();
                }
                else
                {
                    break outer; 
                }
                break;
                case 'B': 
                System.out.println("----------------------------------------------------------------");
                System.out.println("**********Warning! You can only Deposit 50000 in one shot****************");
                System.out.print("Enter an amount to Deposit: ");
                int amount = sc.nextInt();
                System.out.println("----------------------------------------------------------------"); 
                deposit(amount);
                System.out.println("\n");
                System.out.println("Do you want to Continue using our system? (1-Yes) (0-No) ");
                n = sc.nextInt();
                if(n==1)
                {
                    load();
                }
                else
                {
                    break outer; 
                }
                break;
                case 'C':
                System.out.println("----------------------------------------------------------------");
                System.out.println("**************Warning! You cannot withdraw more than 50000 in one shot**********");
                System.out.print("Enter an amount to Withdraw: ");
                int amount2 = sc.nextInt();
                withdraw(amount2);
                System.out.println("\n");
                System.out.println("Do you want to Continue using our system? (1-Yes) (0-No) ");
                n = sc.nextInt();
                if(n==1)
                {
                    load();
                }
                else
                {
                    break outer; 
                }
                break;
                case 'D':
                System.out.println("----------------------------------------------------------------"); 
                int k=0;
                if(transact[0] == 0)
                {
                    System.out.println("You have not Done Any Transactions yet!");
                }
                else{
                for(k=0;k<=100000;k++)
                {
                    if(transact[k]>0)
                    {
                        System.out.println("Deposited: "+transact[k]);
                    }
                    else if(transact[k]<0)
                    {
                        System.out.println("Withdrawn: "+Math.abs(transact[k]));
                    }
                    else
                    {
                        break;
                    }
                }
                System.out.println("----------------------------------------------------------------"); 
                System.out.println("Total Balance = "+balance);
                }
                System.out.println("----------------------------------------------------------------"); 
                System.out.println("\n");
                System.out.println("Do you want to Continue using our system? (1-Yes) (0-No) ");
                n = sc.nextInt();
                if(n==1)
                {
                    load();
                }
                else
                {
                    break outer; 
                }
                break;
                case 'E':
                System.out.println("----------------------------------------------------------------"); 
                terms_conditions();
                System.out.println("\n");
                System.out.println("Do you want to Continue using our system? (1-Yes) (0-No) ");
                n = sc.nextInt();
                if(n==1)
                {
                    load();
                }
                else
                {
                    break outer; 
                }
                break;
                case 'F':
                System.out.println("----------------------------------------------------------------"); 
                break;
                default:
                System.out.println("Invalid Option! Please Enter Again.");
                break;
            }
        }while(option!='F');
        System.out.println("Thank You for Using Our System");
        System.out.println("----------------------------------------------------------------"); 
    }
}