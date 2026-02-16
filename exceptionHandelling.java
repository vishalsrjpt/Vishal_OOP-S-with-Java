import java.util.InputMismatchException;
import java.util.Scanner;

public class exceptionHandelling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String studentName;
        int marks;

        try {
            System.out.print("Enter the student's name: ");
            studentName = scanner.nextLine();

            System.out.print("Enter the student's marks (out of 100): ");
            marks = scanner.nextInt();

            if (marks < 0 || marks > 100) {
                throw new IllegalArgumentException("Marks must be between 0 and 100.");
            }

            String grade = calcGrade(marks);
            System.out.println("Student Name: " + studentName);
            System.out.println("Marks Entered: " + marks);
            System.out.println("Grade Obtained: " + grade);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter numeric marks only.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Marks evaluation completed.");
            scanner.close();
        }
    }

    private static String calcGrade(int marks) {
        if (marks >= 90) {
            return "A";
        } else if (marks >= 75) {
            return "B";
        } else if (marks >= 60) {
            return "C";
        } else if (marks >= 40) {
            return "D";
        } else {
            return "Fail";
        }
    }
}
