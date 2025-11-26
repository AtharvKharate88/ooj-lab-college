import java.util.Scanner;

public class ListIndexExample {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] items = {"apple", "banana", "cherry", "date"};

        System.out.println("Items:");
        for (int i = 0; i < items.length; i++) {
            System.out.println(i + ": " + items[i]);
        }

        System.out.print("Enter an index: ");

        try {
            int index = input.nextInt();
            System.out.println("You selected: " + items[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Index out of range.");
        } catch (Exception e) {
            System.out.println("Error: Please enter a valid integer.");
        }
    }
}

