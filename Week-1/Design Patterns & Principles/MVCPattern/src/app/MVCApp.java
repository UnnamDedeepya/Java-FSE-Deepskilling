package app;

import controller.StudentController;
import model.Student;
import view.StudentView;

import java.util.Scanner;

public class MVCApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initial dummy data
        Student student = new Student("Dummy", "0000", "N/A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);

        System.out.println("📥 Enter Student Details:");
        System.out.print("Name  : ");
        String name = scanner.nextLine();
        System.out.print("ID    : ");
        String id = scanner.nextLine();
        System.out.print("Grade : ");
        String grade = scanner.nextLine();

        controller.updateStudent(name, id, grade);

        System.out.println("\n📤 Displaying Updated Student Info:");
        controller.showStudent();

        scanner.close();
    }
}
