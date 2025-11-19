import CIE.*;
import SEE.*;
import java.util.*;

public class FinalMarks {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        External ext[] = new External[n];
        Internals in[] = new Internals[n];

        for (int i = 0; i < n; i++) {
            in[i] = new Internals();
            ext[i] = new External();

            System.out.println("\nEnter details for student " + (i + 1));
            System.out.print("USN: "); in[i].usn = sc.next();
            System.out.print("Name: "); in[i].name = sc.next();
            System.out.print("Semester: "); in[i].sem = sc.nextInt();

            System.out.println("Enter 5 internal marks:");
            for (int j = 0; j < 5; j++)
                in[i].internalMarks[j] = sc.nextInt();

            System.out.println("Enter 5 SEE marks:");
            for (int j = 0; j < 5; j++)
                ext[i].seeMarks[j] = sc.nextInt();
        }

        System.out.println("\nFinal Marks of Students:");
        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent: " + in[i].name);
            for (int j = 0; j < 5; j++) {
                int finalMarks = in[i].internalMarks[j] + ext[i].seeMarks[j] / 2;
                System.out.println("Course " + (j + 1) + ": " + finalMarks);
            }
        }

        sc.close();
    }
}

