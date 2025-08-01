package app;

import factory.*;
import document.Document;
import java.util.Scanner;

public class DocumentApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DocumentFactory factory = null;

        System.out.println("Select document type to open:");
        System.out.println("1. Word\n2. PDF\n3. Excel");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                factory = new WordFactory();
                break;
            case 2:
                factory = new PdfFactory();
                break;
            case 3:
                factory = new ExcelFactory();
                break;
            default:
                System.out.println("Invalid choice.");
                System.exit(0);
        }

        Document doc = factory.createDocument();
        doc.open();

        scanner.close();
    }
}
