
import java.util.Scanner;


class account1 {
    protected String customerName;
    protected String accountNumber;
    protected String accountType;
    protected double balance;
    
    public account1(String customerName, String accountNumber, String accountType, double balance) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
    }

  
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void displayBalance() {
        System.out.println("Account Holder: " + customerName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Current Balance: Rs." + balance);
    }

    
    public void withdraw(double amount) {
        System.out.println("Withdraw method not implemented for base class.");
    }
}


class Sav_acct extends account1 {
    private static final double INTEREST_RATE = 0.05; // 5% annual interest

    public Sav_acct(String customerName, String accountNumber, double balance) {
        super(customerName, accountNumber, "Savings", balance);
    }

   
    public void computeAndDepositInterest() {
        double interest = balance * INTEREST_RATE;
        balance += interest;
        System.out.println("Interest of Rs." + interest + " added to the account.");
    }

  
    @Override
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance! Withdrawal denied.");
        } else {
            balance -= amount;
            System.out.println("Rs." + amount + " withdrawn successfully.");
        }
    }
}


class Cur_acct extends account1 {
    private static final double MIN_BALANCE = 1000.0;
    private static final double PENALTY = 100.0;

    public Cur_acct(String customerName, String accountNumber, double balance) {
        super(customerName, accountNumber, "Current", balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance! Withdrawal denied.");
            return;
        }

        balance -= amount;
        System.out.println("Rs." + amount + " withdrawn successfully.");

       
        if (balance < MIN_BALANCE) {
            balance -= PENALTY;
            System.out.println("Balance below minimum! Penalty of Rs." + PENALTY + " imposed.");
        }
    }
}


public class LabProgram5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- Bank Account Management System ---");

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();

        System.out.print("Enter Account Type (Savings/Current): ");
        String type = sc.nextLine().trim().toLowerCase();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        account1 acc;

        if (type.equals("savings")) {
            acc = new Sav_acct(name, accNo, balance);
        } else if (type.equals("current")) {
            acc = new Cur_acct(name, accNo, balance);
        } else {
            System.out.println("Invalid account type! Exiting...");
            sc.close();
            return;
        }

        int choice;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Balance");
            System.out.println("4. Compute & Deposit Interest (for Savings)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    acc.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    acc.withdraw(withdrawAmount);
                    break;

                case 3:
                    acc.displayBalance();
                    break;

                case 4:
                    if (acc instanceof Sav_acct) {
                        ((Sav_acct) acc).computeAndDepositInterest();
                    } else {
                        System.out.println("Interest calculation is not applicable for Current Account.");
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using our banking system!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}

