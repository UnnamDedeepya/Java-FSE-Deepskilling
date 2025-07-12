package app;

import model.Product;
import service.InventoryManager;
import java.util.Scanner;


/**
 * Entry point for Inventory Management System.
 */
public class InventoryApp {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Inventory Menu ---");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. View Inventory");
            System.out.println("5. Exit");
            System.out.print("Select option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            switch (choice) {
                case 1:
                    System.out.print("Product ID: ");
                    String id = sc.nextLine();
                    System.out.print("Product Name: ");
                    String name = sc.nextLine();
                    System.out.print("Quantity: ");
                    int qty = sc.nextInt();
                    System.out.print("Price: ");
                    double price = sc.nextDouble();
                    Product product = new Product(id, name, qty, price);
                    if (manager.addProduct(product)) {
                        System.out.println("Product added.");
                    } else {
                        System.out.println("Product already exists.");
                    }
                    break;

                case 2:
                    System.out.print("Product ID to update: ");
                    String updateId = sc.nextLine();
                    System.out.print("New Quantity: ");
                    int newQty = sc.nextInt();
                    System.out.print("New Price: ");
                    double newPrice = sc.nextDouble();
                    if (manager.updateProduct(updateId, newQty, newPrice)) {
                        System.out.println("Product updated.");
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 3:
                    System.out.print("Product ID to delete: ");
                    String deleteId = sc.nextLine();
                    if (manager.deleteProduct(deleteId)) {
                        System.out.println("Product deleted.");
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 4:
                    manager.displayInventory();
                    break;

                case 5:
                    System.out.println("Exiting system.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
