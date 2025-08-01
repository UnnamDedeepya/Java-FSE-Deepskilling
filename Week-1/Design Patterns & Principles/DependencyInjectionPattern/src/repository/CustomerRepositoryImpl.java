package repository;

import model.Customer;
import java.util.HashMap;
import java.util.Map;

public class CustomerRepositoryImpl implements CustomerRepository {
    private Map<String, Customer> db = new HashMap<>();

    public CustomerRepositoryImpl() {
        // Simulated database
        db.put("C101", new Customer("C101", "Dedeepya", "dedeepyaunnam@gmail.com"));
        db.put("C102", new Customer("C102", "Bhuvana", "bhuvanainturi@gmail.com"));
    }

    @Override
    public Customer findCustomerById(String id) {
        return db.getOrDefault(id, null);
    }
}
