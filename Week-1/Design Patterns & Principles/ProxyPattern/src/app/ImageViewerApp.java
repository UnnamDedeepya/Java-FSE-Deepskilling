package app;

import proxy.ProxyImage;
import image.Image;

import java.util.Scanner;

public class ImageViewerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Image img1 = new ProxyImage("pic1.jpg");
        Image img2 = new ProxyImage("pic2.jpg");

        while (true) {
            System.out.println("\n--- Image Viewer ---");
            System.out.println("1. View Image 1");
            System.out.println("2. View Image 2");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    img1.display();
                    break;
                case 2:
                    img2.display();
                    break;
                case 3:
                    System.out.println("Exiting viewer.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
