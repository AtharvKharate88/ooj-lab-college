import java.util.Scanner;

class InsufficientFundsException extends Exception {
    // empty custom exception
}

public class BankWithdrawal {
    public static void main(String[] args) {
        double balance = 500.0;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter withdrawal amount: ");

        try {
            double amount = Double.parseDouble(input.nextLine());

            if (amount > balance) {
                throw new InsufficientFundsException();
            }

            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);

        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a numeric amount.");
        } catch (InsufficientFundsException e) {
            System.out.println("Error: Insufficient funds.");
        }
    }
}
