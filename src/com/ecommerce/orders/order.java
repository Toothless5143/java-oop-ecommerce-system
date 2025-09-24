package com.ecommerce.orders;

import com.ecommerce.Customer;
import com.ecommerce.Product;
import java.util.List;

/**
 * Represents an order placed by a customer.
 * This class is a snapshot of a transaction at a specific moment.
 */
public class Order {
    private String orderID;
    private Customer customer;
    private List<Product> products;
    private double orderTotal;
    private String status;

    /**
     * Constructs a new Order. The total is calculated automatically.
     * @param orderID  The unique identifier for the order.
     * @param customer The customer who placed the order.
     * @param products A list of products included in the order.
     */
    public Order(String orderID, Customer customer, List<Product> products) {
        this.orderID = orderID;
        this.customer = customer;
        this.products = products;
        this.orderTotal = products.stream().mapToDouble(Product::getPrice).sum();
        this.status = "Pending"; // Default status upon creation
    }

    /**
     * Generates and prints a formatted summary of the order details.
     */
    public void displayOrderSummary() {
        System.out.println("\n========== Order Summary ==========");
        System.out.println("Order ID: " + orderID);
        System.out.println("Customer: " + customer.getName() + " (ID: " + customer.getCustomerID() + ")");
        System.out.println("Status:   " + status);
        System.out.println("--- Products Ordered ---");
        products.forEach(p -> System.out.printf("- %-25s $%.2f%n", p.getName(), p.getPrice()));
        System.out.println("---------------------------------");
        System.out.printf("Order Total:                    $%.2f%n", orderTotal);
        System.out.println("=================================");
    }

    /**
     * Updates the status of the order (e.g., "Shipped", "Delivered").
     * @param newStatus The new status for the order.
     */
    public void updateStatus(String newStatus) {
        this.status = newStatus;
        System.out.println("\n-> Order " + this.orderID + " status updated to: " + newStatus);
    }
}
