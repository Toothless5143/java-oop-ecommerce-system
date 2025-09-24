package com.ecommerce;

/**
 * Represents a product available for purchase in the e-commerce system.
 * This class encapsulates product information, making fields private and providing
 * public methods for controlled access, a core tenet of data hiding (Bloch, 2018).
 */
public class Product {
    private String productID;
    private String name;
    private double price;

    /**
     * Constructs a new Product.
     * @param productID The unique identifier for the product.
     * @param name      The name of the product.
     * @param price     The price of the product. Must be non-negative.
     */
    public Product(String productID, String name, double price) {
        this.productID = productID;
        this.name = name;
        this.setPrice(price); // Use setter to enforce validation
    }

    // --- Getters and Setters ---
    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    /**
     * Sets the product price, ensuring it is not negative.
     * @param price The new price for the product.
     */
    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            System.err.println("Invalid price. Price cannot be negative.");
        }
    }

    /**
     * Provides a string representation of the Product object.
     * @return A formatted string with product details.
     */
    @Override
    public String toString() {
        return String.format("Product[ID=%s, Name=%s, Price=$%.2f]", productID, name, price);
    }
}
