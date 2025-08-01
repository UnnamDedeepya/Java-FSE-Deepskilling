package app;

import model.Order;
import service.OrderSorter;
import java.util.Scanner;

public class OrderApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderSorter sorter = new OrderSorter();

        System.out.print("Enter number of orders: ");
        int n = Integer.parseInt(scanner.nextLine());
        Order[] orders = new Order[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Order " + (i + 1));
            System.out.print("Order ID: ");
            String id = scanner.nextLine();
            System.out.print("Customer Name: ");
            String name = scanner.nextLine();
            System.out.print("Total Price: ");
            double price = Double.parseDouble(scanner.nextLine());

            orders[i] = new Order(id, name, price);
        }

        // Bubble Sort
        Order[] bubbleSorted = orders.clone();
        sorter.bubbleSort(bubbleSorted);
        System.out.println("\nSorted Orders by Bubble Sort:");
        for (Order o : bubbleSorted) {
            System.out.println(o);
        }

        // Quick Sort
        Order[] quickSorted = orders.clone();
        sorter.quickSort(quickSorted, 0, quickSorted.length - 1);
        System.out.println("\nSorted Orders by Quick Sort:");
        for (Order o : quickSorted) {
            System.out.println(o);
        }

        scanner.close();
    }
}
