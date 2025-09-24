package com.ecommerce;

import com.ecommerce.orders.Order;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a customer of the online store.
 * This class manages customer details and their shopping cart.
 */
public class Customer {
    private String customerID;
    private String name;
    private List<Product> shoppingCart;

    /**
     * Constructs a new Customer and initializes an empty shopping cart.
     * @param customerID The unique identifier for the customer.
     * @param name       The name of the customer.
     */
    public Customer(String customerID, String name) {
        this.customerID = customerID;
        this.name = name;
        this.shoppingCart = new ArrayList<>();
    }

    /**
     * Adds a product to the customer's shopping cart.
     * @param product The Product to add.
     */
    public void addProductToCart(Product product) {
        shoppingCart.add(product);
        System.out.println("-> '" + product.getName() + "' was added to " + this.name + "'s cart.");
    }

    /**
     * Removes a product from the customer's shopping cart.
     * @param product The Product to remove.
     */
    public void removeProductFromCart(Product product) {
        if (shoppingCart.remove(product)) {
            System.out.println("-> '" + product.getName() + "' was removed from the cart.");
        } else {
            System.out.println("-> Could not find '" + product.getName() + "' in the cart.");
        }
    }

    /**
     * Creates an Order from the items in the shopping cart and clears the cart.
     * @param orderID The unique ID for the new order.
     * @return The created Order object, or null if the cart is empty.
     */
    public Order placeOrder(String orderID) {
        if (shoppingCart.isEmpty()) {
            System.out.println("Cannot place an order with an empty cart.");
            return null;
        }
        Order newOrder = new Order(orderID, this, new ArrayList<>(this.shoppingCart));
        shoppingCart.clear();
        System.out.println("Order placed successfully! The shopping cart is now empty.");
        return newOrder;
    }

    /**
     * Displays the current contents and total cost of the shopping cart.
     */
    public void viewShoppingCart() {
        System.out.println("\n--- " + this.name + "'s Shopping Cart ---");
        if (shoppingCart.isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
            shoppingCart.forEach(p -> System.out.printf("- %-25s $%.2f%n", p.getName(), p.getPrice()));
        }
        double total = shoppingCart.stream().mapToDouble(Product::getPrice).sum();
        System.out.println("---------------------------------");
        System.out.printf("Total Cost:                     $%.2f%n", total);
    }

    // --- Getters ---
    public String getCustomerID() { return customerID; }
    public String getName() { return name; }
    public List<Product> getShoppingCart() { return shoppingCart; }
}
