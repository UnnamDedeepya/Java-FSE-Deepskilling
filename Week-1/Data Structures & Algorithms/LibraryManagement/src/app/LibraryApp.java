package app;

import model.Book;
import service.LibrarySearchService;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibrarySearchService searchService = new LibrarySearchService();

        System.out.print("Enter number of books: ");
        int n = Integer.parseInt(scanner.nextLine());
        Book[] books = new Book[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Book " + (i + 1));
            System.out.print("Book ID: ");
            String id = scanner.nextLine();
            System.out.print("Title: ");
            String title = scanner.nextLine();
            System.out.print("Author: ");
            String author = scanner.nextLine();

            books[i] = new Book(id, title, author);
        }

        // Linear Search
        System.out.print("\nEnter book title to search (Linear Search): ");
        String target1 = scanner.nextLine();
        int index1 = searchService.linearSearch(books, target1);

        if (index1 != -1) {
            System.out.println("Found using Linear Search: " + books[index1]);
        } else {
            System.out.println("Book not found using Linear Search.");
        }

        // Binary Search
        Arrays.sort(books, Comparator.comparing(Book::getTitle));
        System.out.print("\nEnter book title to search (Binary Search): ");
        String target2 = scanner.nextLine();
        int index2 = searchService.binarySearch(books, target2);

        if (index2 != -1) {
            System.out.println("Found using Binary Search: " + books[index2]);
        } else {
            System.out.println("Book not found using Binary Search.");
        }

        scanner.close();
    }
}

