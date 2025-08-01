package app;

import model.Employee;
import service.EmployeeManager;
import java.util.Scanner;

public class EmployeeApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter max number of employees: ");
        int capacity = Integer.parseInt(scanner.nextLine());

        EmployeeManager manager = new EmployeeManager(capacity);

        while (true) {
            System.out.println("\n--- Employee Menu ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. View All Employees");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Employee ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Position: ");
                    String position = scanner.nextLine();
                    System.out.print("Salary: ");
                    double salary = Double.parseDouble(scanner.nextLine());

                    Employee emp = new Employee(id, name, position, salary);
                    if (manager.addEmployee(emp)) {
                        System.out.println("Employee added.");
                    } else {
                        System.out.println("No space available.");
                    }
                    break;

                case 2:
                    System.out.print("Enter Employee ID to search: ");
                    String searchId = scanner.nextLine();
                    int index = manager.searchEmployee(searchId);
                    if (index != -1) {
                        System.out.println("Employee found: " + manager.searchEmployee(searchId));
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Employee ID to delete: ");
                    String delId = scanner.nextLine();
                    if (manager.deleteEmployee(delId)) {
                        System.out.println("Employee deleted.");
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 4:
                    manager.displayAll();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
