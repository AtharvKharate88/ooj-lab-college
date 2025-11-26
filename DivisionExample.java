import java.util.Scanner;

public class DivisionExample {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter numerator: ");
        double num = input.nextDouble();

        System.out.print("Enter denominator: ");
        double den = input.nextDouble();

        try {
            if (den == 0) {
                throw new ArithmeticException("Cannot divide by zero.");
            }

            double result = num / den;
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
        input.close();
    }
}
