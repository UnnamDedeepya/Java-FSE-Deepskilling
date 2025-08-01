package app;

import service.TaskManager;
import model.Task;
import java.util.Scanner;

public class TaskApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        while (true) {
            System.out.println("\n--- Task Menu ---");
            System.out.println("1. Add Task");
            System.out.println("2. Search Task");
            System.out.println("3. Delete Task");
            System.out.println("4. View All Tasks");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Task ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Task Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Status: ");
                    String status = scanner.nextLine();
                    manager.addTask(id, name, status);
                    System.out.println("Task added.");
                    break;

                case 2:
                    System.out.print("Enter Task ID to search: ");
                    String searchId = scanner.nextLine();
                    Task task = manager.searchTask(searchId);
                    if (task != null) {
                        System.out.println("Task found: " + task);
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Task ID to delete: ");
                    String delId = scanner.nextLine();
                    if (manager.deleteTask(delId)) {
                        System.out.println("Task deleted.");
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;

                case 4:
                    manager.displayTasks();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
