package service;

import model.Product;
import java.util.HashMap;
import java.util.Map;
/**
 * Handles core inventory operations like add, update, delete, and list.
 */
public class InventoryManager {
    private final Map<String, Product> productMap;

    public InventoryManager() {
        this.productMap = new HashMap<>();
    }

    // Adds a new product
    public boolean addProduct(Product product) {
        if (productMap.containsKey(product.getProductId())) {
            return false; // Product already exists
        }
        productMap.put(product.getProductId(), product);
        return true;
    }

    // Updates an existing product
    public boolean updateProduct(String productId, int quantity, double price) {
        Product product = productMap.get(productId);
        if (product != null) {
            product.setQuantity(quantity);
            product.setPrice(price);
            return true;
        }
        return false;
    }

    // Deletes a product
    public boolean deleteProduct(String productId) {
        return productMap.remove(productId) != null;
    }

    // Lists all products
    public void displayInventory() {
        if (productMap.isEmpty()) {
            System.out.println("Inventory is currently empty.");
        } else {
            for (Product product : productMap.values()) {
                System.out.println(product);
            }
        }
    }
}
