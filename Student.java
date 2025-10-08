import java.util.*;

public class Student {
    String usn;
    String name;
    int[] credits;
    int[] marks;
    int numSubjects;

    public void inputDetails() {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter USN: ");
        usn = input.nextLine();
        
        System.out.print("Enter Name: ");
        name = input.nextLine();
        
        System.out.print("Enter number of subjects: ");
        numSubjects = input.nextInt();

        credits = new int[numSubjects];
        marks = new int[numSubjects];

        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = input.nextInt();
        }

        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter credits for subject " + (i + 1) + ": ");
            credits[i] = input.nextInt();
        }

        // input.close(); // Don't close here if using Scanner later
    }

    public void displayDetails() {
        System.out.println("\n--- Student Details ---");
        System.out.println("Name: " + name);
        System.out.println("USN: " + usn);
        for (int i = 0; i < numSubjects; i++) {
            System.out.println("Subject " + (i + 1) + ": Marks = " + marks[i] + ", Credits = " + credits[i]);
        }
    }

    public void calcSGPA() {
        int totalGradePoints = 0, totalCredits = 0;

        for (int i = 0; i < numSubjects; i++) {
            int gradePoint;

            if (marks[i] >= 90) {
                gradePoint = 10;
            } else if (marks[i] >= 80) {
                gradePoint = 9;
            } else if (marks[i] >= 70) {
                gradePoint = 8;
            } else if (marks[i] >= 60) {
                gradePoint = 7;
            } else if (marks[i] >= 50) {
                gradePoint = 6;
            } else if (marks[i] >= 40) {
                gradePoint = 5;
            } else {
                gradePoint = 0; // Failed
            }

            totalGradePoints += gradePoint * credits[i];
            totalCredits += credits[i];
        }

        double sgpa = (double) totalGradePoints / totalCredits;
        System.out.printf("SGPA: %.2f\n", sgpa);
    }

    public static void main(String[] args) {
        Student s = new Student();
        s.inputDetails();
        s.displayDetails();
        s.calcSGPA();
    }
}
