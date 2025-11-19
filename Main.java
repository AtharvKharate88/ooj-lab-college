class WrongAge extends Exception {
    WrongAge(String msg) { super(msg); }
}

class Father {
    int fage;
    Father(int age) throws WrongAge {
        if (age < 0)
            throw new WrongAge("Father age cannot be negative");
        fage = age;
    }
}

class Son extends Father {
    int sage;
    Son(int fage, int sage) throws WrongAge {
        super(fage);
        if (sage >= fage)
            throw new WrongAge("Son age cannot be >= Father age");
        this.sage = sage;
    }
}

public class Main {
    public static void main(String args[]) {
        try {
            Son s = new Son(10, 20);
            System.out.println("Valid ages!");
        } catch (WrongAge e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

