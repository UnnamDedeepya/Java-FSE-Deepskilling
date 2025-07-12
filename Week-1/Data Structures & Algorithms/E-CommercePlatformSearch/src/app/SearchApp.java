package app;

import model.Product;
import service.SearchService;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SearchApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SearchService searchService = new SearchService();

        System.out.print("Enter number of products: ");
        int n = Integer.parseInt(scanner.nextLine());
        Product[] products = new Product[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for product " + (i + 1));
            System.out.print("Product ID: ");
            String id = scanner.nextLine();
            System.out.print("Product Name: ");
            String name = scanner.nextLine();
            System.out.print("Category: ");
            String category = scanner.nextLine();

            products[i] = new Product(id, name, category);
        }

        // Ask user for product name to search
        System.out.print("\nEnter product name to search (Linear Search): ");
        String target1 = scanner.nextLine();

        int index1 = searchService.linearSearch(products, target1);
        if (index1 != -1) {
            System.out.println("Found using Linear Search: " + products[index1]);
        } else {
            System.out.println("Product not found using Linear Search.");
        }

        // Sort products by name for binary search
        Arrays.sort(products, Comparator.comparing(Product::getProductName));

        System.out.print("\nEnter product name to search (Binary Search): ");
        String target2 = scanner.nextLine();

        int index2 = searchService.binarySearch(products, target2);
        if (index2 != -1) {
            System.out.println("Found using Binary Search: " + products[index2]);
        } else {
            System.out.println("Product not found using Binary Search.");
        }

        scanner.close();
    }
}

