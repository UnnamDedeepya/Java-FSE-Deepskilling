package app;

import adapter.PayPalAdapter;
import adapter.StripeAdapter;
import target.PaymentProcessor;
import java.util.Scanner;

public class PaymentApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter amount to pay: ₹");
        double amount = Double.parseDouble(scanner.nextLine());

        System.out.println("Choose payment method:");
        System.out.println("1. PayPal");
        System.out.println("2. Stripe");

        int choice = Integer.parseInt(scanner.nextLine());
        PaymentProcessor processor;

        switch (choice) {
            case 1:
                processor = new PayPalAdapter();
                break;
            case 2:
                processor = new StripeAdapter();
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        processor.processPayment(amount);
        scanner.close();
    }
}
