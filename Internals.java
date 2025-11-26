package CIE;

public class Internals {
    public int[] internalMarks;
    
    public Internals() {
        internalMarks = new int[5];
    }
    
    public void setInternalMarks(int[] marks) {
        for (int i = 0; i < 5; i++) {
            internalMarks[i] = marks[i];
        }
    }
    
    public int[] getInternalMarks() {
        return internalMarks;
    }
    
    public void displayInternalMarks() {
        System.out.println("Internal Marks:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Course " + (i + 1) + ": " + internalMarks[i]);
        }
    }
}