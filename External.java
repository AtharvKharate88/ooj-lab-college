package SEE;

import CIE.*;

public class External extends Personal {
    public int[] seeMarks;
    
    public External(String usn, String name, int sem) {
        super(usn, name, sem);
        seeMarks = new int[5];
    }
    
    public void setSeeMarks(int[] marks) {
        for (int i = 0; i < 5; i++) {
            this.seeMarks[i] = marks[i];
        }
    }
    
    public int[] getSeeMarks() {
        return seeMarks;
    }
    
    public void displaySeeMarks() {
        System.out.println("SEE Marks:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Course " + (i + 1) + ": " + seeMarks[i]);
        }
    }
}