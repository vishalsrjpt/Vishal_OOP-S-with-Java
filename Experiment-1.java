class Student {

    int rollNo;
    String name;
    Double marks;   

    Student() {
        rollNo = 0;
        name = "Not Available";
        marks = 0.0;
    }

    Student(int r, String n, Double m) {
        rollNo = r;
        name = n;
        marks = m;
    }

    void display() {
        System.out.println("Roll No:" + rollNo);
        System.out.println("Name:" + name);
        System.out.println("Marks:" + marks);
    }
}

public class Main {
    public static void main(String[] args) {

        Student s1 = new Student();

        Student s2 = new Student(101, "Vishal", 87.5);

        System.out.println("Student 1 Details");
        s1.display();

        System.out.println("\nStudent 2 Details");
        s2.display();

        
    }
}
