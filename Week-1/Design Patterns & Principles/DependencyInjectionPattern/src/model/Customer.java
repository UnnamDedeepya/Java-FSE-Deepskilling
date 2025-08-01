package model;

public class Customer {
    private String id;
    private String name;
    private String email;

    public Customer(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "[Customer: ID=" + id + ", Name=" + name + ", Email=" + email + "]";
    }
}
