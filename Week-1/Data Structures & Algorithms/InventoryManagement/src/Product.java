package model;

/**
 * Represents a single product in the inventory.
 */
public class Product {
    private String prodId;
    private String prodName;
    private int quantity;
    private double price;

    public Product(String prodId, String prodName, int quantity, double price) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters & Setters
    public String getProductId() {
        return prodId;
    }

    public String getProductName() {
        return prodName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "[ID: " + prodId + ", Name: " + prodName + ", Qty: " + quantity + ", Price: ₹" + price + "]";
    }
}
