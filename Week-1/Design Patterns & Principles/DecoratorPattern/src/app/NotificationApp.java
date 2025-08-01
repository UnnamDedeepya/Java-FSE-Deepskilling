package app;

import decorator.SMSNotifierDecorator;
import decorator.SlackNotifierDecorator;
import notifier.EmailNotifier;
import notifier.Notifier;

import java.util.Scanner;

public class NotificationApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Notifier notifier = new EmailNotifier();  // base notifier

        System.out.println("Choose additional channels:");
        System.out.println("1. Email only");
        System.out.println("2. Email + SMS");
        System.out.println("3. Email + Slack");
        System.out.println("4. Email + SMS + Slack");

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 2:
                notifier = new SMSNotifierDecorator(notifier);
                break;
            case 3:
                notifier = new SlackNotifierDecorator(notifier);
                break;
            case 4:
                notifier = new SlackNotifierDecorator(new SMSNotifierDecorator(notifier));
                break;
            case 1:
            default:
                // no additional wrapping
                break;
        }

        System.out.print("\nEnter message to send: ");
        String message = scanner.nextLine();

        System.out.println("\nSending Notification...");
        notifier.send(message);

        scanner.close();
    }
}
