package app;

import repository.CustomerRepositoryImpl;
import service.CustomerService;
import java.util.Scanner;

public class DIApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inject dependency via constructor
        CustomerService service = new CustomerService(new CustomerRepositoryImpl());

        System.out.print("Enter Customer ID to fetch: ");
        String id = scanner.nextLine();

        service.getCustomerDetails(id);
        scanner.close();
    }
}
