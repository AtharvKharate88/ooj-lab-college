import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class fileOpenExample {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a filename: ");
        String filename = input.nextLine();

        try {
            File file = new File(filename);
            Scanner fileReader = new Scanner(file);

            System.out.println("File opened successfully!");
            while (fileReader.hasNextLine()) {
                System.out.println(fileReader.nextLine());
            }

            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: The file does not exist.");
        }
    }
}
