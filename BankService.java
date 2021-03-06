package com.keyword;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

class AccountCreate
{
    static int id=3;
    static String ename;
    static int age;
    static String accountNumber="56789";
    public AccountCreate(String ename,int age)
    {
        this.ename=ename;
        this.age=age;
    }
    public void display()
    {
        System.out.println("Hi "+ename +" welcome to XYZ Bank");
        details();
    }
    public static void details()
    {
        System.out.println("The Details are ");
        System.out.println("Name : "+ename);
        System.out.println("Age : "+age);
        System.out.println("Account Number : "+accountNumber);
        System.out.println("Your Account is created successfully!!!");

    }
}

class BankEmployee
{
    private int id;
    private String name;
    private String accountNumber;
    public TreeMap<Integer,String> Accounts = new TreeMap<Integer,String>();
    public TreeMap<String,String> employeeName = new TreeMap<String,String>();
    static int flag = 0;
    BankEmployee(int id,String accountNumber) {
        this.id = id;
        this.name = name;
        this.Accounts.put(1,"12345");
        this.Accounts.put(2,"54321");
        this.Accounts.put(AccountCreate.id,AccountCreate.accountNumber);
        this.employeeName.put("12345","Ram");
        this.employeeName.put("54321","Sam");
        this.employeeName.put(AccountCreate.accountNumber,AccountCreate.ename);
        if(Accounts.containsKey(this.id))
        {
            if(Accounts.get(this.id).equals(accountNumber))
            {

                System.out.println("Hi " + employeeName.get(accountNumber) + " welcome to XYZ Bank!!!");
                flag = 1;

            }
            else
            {
                System.out.println("Incorrect Account Number or Id.");
                System.exit(0);
            }
        }
        else
        {
            System.out.println("Account number does not exists!!!");
            System.exit(0);
        }
    }

}

class BankingOperations
{
    static ArrayList<Double> Balances = new ArrayList<Double>(Arrays.asList(100.0));
    static double updateVal=100;
    public static void Balance()
    {
        System.out.println("Balance "+Arrays.toString(Balances.toArray()).replace("[","").replace("]",""));
    }
    public static void Deposit(double depositAmount)
    {
        Balances.set(Balances.indexOf(updateVal),Balances.get(0)+depositAmount);
        updateVal=Balances.get(0);
        System.out.println("Deposited Successfully!!!");

    }
    public static void Withdraw(double withdrawAmount)
    {
        double charges=0;
        if (withdrawAmount % 5 != 0)
        {
            System.out.println("Please correct the amount of value. It should be multiple of USD 5");
        }
        else
        {
            charges=((withdrawAmount<=100)?(2*withdrawAmount)/100:(4*withdrawAmount)/100);
            Balances.set(Balances.indexOf(updateVal), Balances.get(0) - withdrawAmount - charges);
            if(Balances.get(0)>=100)
            {
                updateVal = Balances.get(0);
                System.out.println("Charges " + charges);
                System.out.println("Withdrawn Successfully!!!");
            }
            else
            {
                System.out.println("Insufficient money in the account.Minimum balance in the bank should be 100. ");
                System.out.println("-------------------------------------------------------------------------------");
                System.exit(0);

            }
        }
    }
    public static void Swipe(double swipes)
    {
        double cashBack;
        cashBack =(swipes*1)/100;
        Balances.set(Balances.indexOf(updateVal),Balances.get(0)+cashBack);
        updateVal = Balances.get(0);
        System.out.println("CashBack "+cashBack);
        System.out.println("Cashback added Successfully!!!");

    }

}

public class BankService
{

    public static void Processing(int id, String account)
    {
        BankEmployee bankEmployee = new BankEmployee(id, account);
        Scanner in = new Scanner(System.in);
        if (bankEmployee.flag == 1) {
            while (true) {
                System.out.println();
                System.out.println("What do you want to do ");
                System.out.println("1.Balance");
                System.out.println("2.Deposit");
                System.out.println("3.Withdraw");
                System.out.println("4.Swipe");
                System.out.println("5.Exit");
                System.out.print("Your option : ");
                int option = in.nextInt();
                switch (option) {
                    case 1: {
                        BankingOperations operations = new BankingOperations();
                        operations.Balance();
                        break;
                    }
                    case 2: {
                        BankingOperations operations = new BankingOperations();
                        System.out.print("Enter the deposit amount : ");
                        double depositToBank = in.nextDouble();
                        operations.Deposit(depositToBank);
                        break;
                    }
                    case 3: {
                        BankingOperations operations = new BankingOperations();
                        System.out.print("Enter the withdraw amount : ");
                        double withdrawFromBank = in.nextDouble();
                        operations.Withdraw(withdrawFromBank);
                        break;
                    }
                    case 4: {
                        BankingOperations operations = new BankingOperations();
                        System.out.print("Enter the number times you want to swipe: ");
                        double swipes = in.nextDouble();
                        operations.Swipe(swipes);
                        break;

                    }
                    case 5: {
                        System.out.println("Thank You!!!. Please Visit Again!!!.");
                        System.out.println("-------------------------------------------------------------------------------");
                        System.exit(0);
                    }
                }
            }
        }

    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("--------------XYZ BANK SERVICE--------------");
        System.out.println("Do you have account ?");
        System.out.print("Enter Y or y for Yes, N or n for No : ");
        String havingAccount = in.next();
        if (havingAccount.equals("Y") || havingAccount.equals("y")) {
            System.out.print("Enter ID : ");
            int id = in.nextInt();
            System.out.print("Enter the account number to get started : ");
            String accountNumber = in.next();
            Processing(id, accountNumber);
        }
        else
        {
            System.out.println("Enter the name : ");
            String userName = in.next();
            System.out.println("Enter the age : ");
            int age = in.nextInt();
            AccountCreate creation = new AccountCreate(userName, age);
            creation.display();
            Processing(AccountCreate.id, AccountCreate.accountNumber);


        }

    }
}
