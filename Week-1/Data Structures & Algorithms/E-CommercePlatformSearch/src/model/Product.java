package model;

public class Product {
    private String productId;
    private String productName;
    private String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    public String getProductId() {
        return productId;
    }

    @Override
    public String toString() {
        return "[ID: " + productId + ", Name: " + productName + ", Category: " + category + "]";
    }
}
