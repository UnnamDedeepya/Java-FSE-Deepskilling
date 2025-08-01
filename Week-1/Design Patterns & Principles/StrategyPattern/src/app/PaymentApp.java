package app;

import strategy.CreditCardPayment;
import strategy.PayPalPayment;
import context.PaymentContext;
import java.util.Scanner;

public class PaymentApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PaymentContext context = new PaymentContext();

        System.out.print("Enter amount to pay: ₹");
        double amount = Double.parseDouble(scanner.nextLine());

        System.out.println("Choose Payment Method:");
        System.out.println("1. Credit Card");
        System.out.println("2. PayPal");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                System.out.print("Enter Card Number: ");
                String cardNum = scanner.nextLine();
                System.out.print("Enter Card Holder Name: ");
                String cardHolder = scanner.nextLine();
                context.setPaymentStrategy(new CreditCardPayment(cardNum, cardHolder));
                break;
            case 2:
                System.out.print("Enter PayPal Email: ");
                String email = scanner.nextLine();
                context.setPaymentStrategy(new PayPalPayment(email));
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }

        context.executePayment(amount);
        scanner.close();
    }
}
