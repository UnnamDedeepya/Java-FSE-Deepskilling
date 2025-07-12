package service;

import repository.CustomerRepository;
import model.Customer;

public class CustomerService {
    private CustomerRepository repository;

    // ✅ Dependency Injection via constructor
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void getCustomerDetails(String customerId) {
        Customer customer = repository.findCustomerById(customerId);
        if (customer != null) {
            System.out.println("Customer Found: " + customer);
        } else {
            System.out.println("Customer Not Found with ID: " + customerId);
        }
    }
}
