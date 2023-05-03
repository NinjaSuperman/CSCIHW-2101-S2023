package Project1;

import java.util.Scanner;
/*
 * Appas Bank
 * Bank Account Parameters:
 * public Name -> String ✓
 * private Balance -> double ✓ 
 * private Date of Birth -> String ✓
 * private SSN -> int (Maybe String) ✓
 * private Account Number -> int ✓
 * 
 * Bank Account Methods:
 * Constructor 
 * Getters and Setters
 * Deposit
 * Withdraw
 * Transfer (HomeWork)
 * Balance
 * Menu
 * Compound Interest
 * Simple Interest (HomeWork)
 * Authentication Basic
 * Authentication Advanced (HomeWork?)
 * 
 * Bank Account Constructor
 * Name, Balance, SSN, Account Number, Date of Birth
 * Name, SSN
 */

public class BankAccount {

    // Bank Account Parameters
    public String name;
    private double balance;
    private String dob;
    private int ssn;
    private int accountNumber;
    public double interestRate = 0.01;
    public int period = 4; // quarterly
    private Boolean savings = false;

    // Bank Account Constructor
    public BankAccount(String name, int ssn, double balance, int accountNumber, String dob, Boolean savings) {
        this.name = name;
        this.ssn = ssn;
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.dob = dob;
        this.savings = savings;

        Scanner input = new java.util.Scanner(System.in);
        if (balance > 9999) {
            System.out.println("Would you like to make this a savings account?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int choice = input.nextInt();
            if (choice == 1) {
                this.savings = true;
                System.out.println("This account is now a savings account");
                System.out.println("Would you like to use a compound or simple interest rate?");
                System.out.println("1. Compound");
                System.out.println("2. Simple");
                choice = input.nextInt();
                if (choice == 1) {
                    this.interestRate = 0.0001;
                    System.out.println("How long do you intend to have this account?");
                    int years = input.nextInt();
                    System.out.println("What is the period?");
                    this.period = input.nextInt();
                    compoundInterest(balance, years, interestRate, period);
                } else if (choice == 2){
                    this.interestRate = 0.01;
                    System.out.println("How long do you intend to have this account?");
                    int years = input.nextInt();
                    simpleInterest(balance, years, interestRate);
                } else {
                    System.out.println("Invalid choice");
                }
            } else if (choice == 2) {
                System.out.println("This account is not a savings account");
            } else {
                System.out.println("Invalid choice");
            }
            input.close();
        }
    }

    // Bank Account Constructor
    public BankAccount(String name, int ssn) {
        this.name = name;
        this.ssn = ssn;
    }
    // Bank Account Methods

    // Note you do need to create a getter for public variables however it is best
    // practice to create a getter for all variables

    /*
     * Getters and Setters
     */

    public String getName() {
        return this.name;
    }

    public double getbalance() {
        return this.balance;
    }

    public String getdob() {
        return this.dob;
    }

    public int getssn() {
        return this.ssn;
    }

    public int getaccountNumber() {
        return this.accountNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
     * Should only be used by during the creation of the account never after instead
     * see deposit and withdraw
     */
    public void setbalance(double balance) {
        this.balance = balance;
    }

    public void setdob(String dob) {
        this.dob = dob;
    }

    public void setssn(int ssn) {
        this.ssn = ssn;
    }

    public void setaccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        this.balance -= amount;
        if (this.balance < 0) {
            overdraft();
        } else {
            System.out.println("You have withdrawn $" + amount);
        }
    }

    public void overdraft() {
        System.out.println("You have overdrafted your account");
        System.out.println("You have been charged a $35 fee");
        this.balance -= 35;
    }

    // Create a mthod that will subtract a mothly fee from the balance
    // this method will take a double as a parameter
    // this method will subtract the fee from the balance
    // Netflix subscription is $12.99
    public void monthlyFee(double fee) {
        withdraw(fee);
    }

    // Create a method that will print a menu to the user
    // This is called a helper method / function
    public static int menu() {
        int choice;
        Scanner input = new java.util.Scanner(System.in);
        System.out.println("Welcome to Appas Bank");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Transfer"); // HomeWork
        System.out.println("4. Balance");
        System.out.println("5. Compound Interest");
        System.out.println("6. Simple Interest"); // HomeWork
        System.out.println("0. Exit");
        System.out.println("Please enter your choice: ");
        choice = input.nextInt();
        input.close();
        return choice;
    }

    public void printBalance() {
        System.out.println("Your balance is: $" + this.balance);
    }

    public static void transfer(BankAccount from, BankAccount to, double amount) {
        from.withdraw(amount);
        to.deposit(amount);
    }

    // Create a method that will interact with the user based on their choice from
    // the menu method
    // This method will take a Bank Account as a parameter
    public static void interact(BankAccount account) {
        // get the choice from the menu method
        int choice = menu();
        // create a scanner object
        Scanner input = new java.util.Scanner(System.in);
        // use that choice and run the method associated with that choice
        BankAccount account2 = new BankAccount("Katara", 1234567, 10000, 101, "01/01/2000", false);
        if (choice == 1) {
            System.out.println("Please enter the amount you would like to deposit: ");
            double amount = input.nextDouble();
            account.deposit(amount);
            account.printBalance();
        } else if (choice == 2) {
            System.out.println("How much would you like to withdraw?");
            double amount = input.nextDouble();
            account.withdraw(amount);
            account.printBalance();
        } else if (choice == 3) {
            System.out.println("How much would you like to transfer?");
            double amount = input.nextDouble();
            transfer(account, account2, amount);
            account.printBalance();
        } else if (choice == 4) {
            account.printBalance();
        } else if (choice == 5) {
            System.out.println("How many years? (Whole numbers only)");
            int years = input.nextInt();
            account.compoundInterest(account.getbalance(), years, account.interestRate, account.period);
            account.printBalance();
        } else if (choice == 6){
            System.out.println("How many years? (Whole numbers only)");
            int years = input.nextInt();
            account.simpleInterest(account.getbalance(), years, account.interestRate);
            account.printBalance();
        } else if (choice == 0) {
            System.out.println("Thank you for banking with Appas Bank");
        } else { // this would catch any invalid choices like
            System.out.println("Invalid choice");
        }
        input.close();
    }

    // Create a method that will calculate the interest on the balance using
    // compound interest
    // P(1 + R/n)^(nt) - P
    // A = P(1 + R/n)^(nt)
    // P = Principal
    // R = Rate
    // n = number of times interest is compounded per year (annum)
    // t = number of years
    // This method will take a double as an argument
    // This method will return a double

    // P can be this.balance or getBalance() if you would like to use a getter

    public void compoundInterest(double principal, int time, double rate, int annum) {
        double amount = principal * Math.pow(1 + (rate / annum), annum * time);
        double roundedAmount = Math.round(amount * 100.0) / 100.0;
        double compinterest = amount - principal; // A-P
        compinterest = Math.round(compinterest * 100.0) / 100;

        System.out.println("Current Rate is: " + rate + "%");
        System.out.println("Current Period is: " + annum + " times per year");
        System.out.println("Selected Time is: " + time + " years");
        System.out.println("Compound Interest after " + time + " years is: $" + compinterest);
        System.out.println("Total Amount after " + time + " years is: $" + roundedAmount);
    }

    public void simpleInterest(double principal, int time, double rate) {
        double amount = (principal * rate * time) / 100;
        System.out.println("Current Rate is: " + rate + "%");
        System.out.println("Selected Time is: " + time + " years");
        System.out.println("Simple Interest after " + time + " years is: $" + amount);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }    
    
}