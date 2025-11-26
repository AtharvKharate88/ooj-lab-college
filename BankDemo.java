import java.util.Scanner;

class Account {
    String name;
    int acc_no;
    String accType;
    double balance;

    Account(String name, int acc_no, String accType, double balance) {
        this.name = name;
        this.acc_no = acc_no;
        this.accType = accType;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    void displayBalance() {
        System.out.println("Current balance: " + balance);
    }
}

class SavAcct extends Account {
    double interestRate = 0.05;

    SavAcct(String name, int acc_no, double balance) {
        super(name, acc_no, "Savings", balance);
    }

    void computeAndDepositInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Interest added: " + interest);
    }

    void withdraw(double amount) {
        if (balance - amount < 1000) {
            System.out.println("Cannot withdraw. Minimum balance of 1000 required.");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        }
    }
}

class CurAcct extends Account {
    double minBalance = 2000;
    double penalty = 100;

    CurAcct(String name, int acc_no, double balance) {
        super(name, acc_no, "Current", balance);
    }

    void withdraw(double amount) {
        balance -= amount;
        if (balance < minBalance) {
            balance -= penalty;
            System.out.println("Penalty of " + penalty + " imposed for low balance.");
        }
        System.out.println("Withdrawn: " + amount);
    }
}

public class BankDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SavAcct sa = new SavAcct("Alice", 101, 5000);
        CurAcct ca = new CurAcct("Bob", 202, 3000);

        sa.deposit(1000);
        sa.computeAndDepositInterest();
        sa.withdraw(2000);
        sa.displayBalance();

        System.out.println();

        ca.withdraw(1500);
        ca.displayBalance();

        sc.close();
    }
}
