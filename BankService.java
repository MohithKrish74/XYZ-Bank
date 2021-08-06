package com.keyword;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
class BankEmployee {
    private int id;
    private String name;
    private String accountNumber;
    public ArrayList<String> Accounts = new ArrayList<String>();
    int flag = 0;

    BankEmployee(int id, String name, String accountNumber)
    {
        this.id = id;
        this.name = name;
        this.Accounts.add(accountNumber);
        if (Accounts.contains("12345"))
        {
            System.out.println();
            System.out.println("Hi " + name + " welcome to XYZ Bank!!!");
            flag = 1;
        }
        else
        {
            System.out.println("Account number does not exists!!!");
        }
    }
}

class BankingOperations
{
    static ArrayList<Double> Balances = new ArrayList<Double>(Arrays.asList(100.0));
    static double updateVal=100;
    public static void Balance()
    {
        System.out.println("Balance USD "+Arrays.toString(Balances.toArray()).replace("[","").replace("]",""));
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
                System.out.println("Charges USD  " + charges);
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
        System.out.println("CashBack USD "+cashBack);
        System.out.println("Cashback added Successfully!!!");

    }

}

public class BankService
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("--------------XYZ BANK SERVICE--------------");
        System.out.print("Enter the account number to get started : ");
        String accountNumber = in.next();
        BankEmployee bankEmployee = new BankEmployee(1,"Ram",accountNumber);
        if(bankEmployee.flag==1)
        {
            while(true)
            {
                System.out.println();
                System.out.println("What do you want to do ");
                System.out.println("1.Balance");
                System.out.println("2.Deposit");
                System.out.println("3.Withdraw");
                System.out.println("4.Swipe");
                System.out.println("5.Exit");
                System.out.print("Your option : ");
                int option = in.nextInt();
                switch (option)
                {
                    case 1:
                    {
                        BankingOperations operations = new BankingOperations();
                        operations.Balance();
                        break;
                    }
                    case 2:
                    {
                        BankingOperations operations = new BankingOperations();
                        System.out.print("Enter the deposit amount : ");
                        double depositToBank = in.nextDouble();
                        operations.Deposit(depositToBank);
                        break;
                    }
                    case 3:
                    {
                        BankingOperations operations = new BankingOperations();
                        System.out.print("Enter the withdraw amount : ");
                        double withdrawFromBank = in.nextDouble();
                        operations.Withdraw(withdrawFromBank);
                        break;
                    }
                    case 4:
                    {
                        BankingOperations operations = new BankingOperations();
                        System.out.print("Enter the number times you want to swipe: ");
                        double swipes = in.nextDouble();
                        operations.Swipe(swipes);
                        break;

                    }
                    case 5:
                    {
                        System.out.println("Thank You!!!. Please Visit Again!!!.");
                        System.out.println("-------------------------------------------------------------------------------");
                        System.exit(0);
                    }
                }
            }
        }

    }
}
