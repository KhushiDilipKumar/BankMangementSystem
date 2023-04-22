package Bank_Management;
import java.util.Scanner;
class Bank_Management_System
{
    public static void main(String[] args)
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.print("Enter your Name: ");
        String name = sc1.nextLine();
        System.out.print("Enter your ID: ");
        String id = sc1.nextLine();
        BankAccount obj = new BankAccount(name, id);
        obj.showMenu();
    }
}