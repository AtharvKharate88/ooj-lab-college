import java.util.Scanner;

public class arithmeticoperator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the operands:");
        int a = input.nextInt();
        int b = input.nextInt();

        System.out.println("Enter the operator (+, -, *, /):");
        char operator = input.next().charAt(0);  // Read a single character

        if (operator == '+') {
            System.out.println("The sum is " + (a + b));
        } else if (operator == '-') {
            System.out.println("The difference is " + (a - b));
        } else if (operator == '*') {
            System.out.println("The product is " + (a * b));
        } else if (operator == '/') {
            if (b != 0) {
                System.out.println("The quotient is " + (a / b));
            } else {
                System.out.println("Error: Division by zero is not allowed.");
            }
        } else {
            System.out.println("Enter a valid operator.");
        }

        input.close();
    }
}
