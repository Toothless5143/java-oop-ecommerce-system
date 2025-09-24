import com.ecommerce.Customer;
import com.ecommerce.Product;
import com.ecommerce.orders.Order;

/**
 * Main driver class to demonstrate the functionality of the e-commerce system.
 * This class simulates a customer's shopping journey from browsing to ordering.
 * Following Java naming conventions enhances readability (Oracle, 1999).
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("--- Welcome to the E-commerce System Simulation ---\n");

        // Step 1: Create product instances to populate the store catalog.
        System.out.println("1. Initializing store products...");
        Product laptop = new Product("P001", "Gaming Laptop", 1499.99);
        Product mouse = new Product("P002", "Wireless Mouse", 75.50);
        Product keyboard = new Product("P003", "Mechanical Keyboard", 120.00);
        System.out.println("   Available products: " + laptop + ", " + mouse + ", " + keyboard + "\n");

        // Step 2: Create a customer instance.
        System.out.println("2. A new customer, Alice, starts shopping...");
        Customer customerAlice = new Customer("CUST101", "Alice");
        System.out.println("   Welcome, " + customerAlice.getName() + "!\n");

        // Step 3: Customer adds products to their shopping cart.
        System.out.println("3. Alice adds items to her cart...");
        customerAlice.addProductToCart(laptop);
        customerAlice.addProductToCart(keyboard);

        // Step 4: Display the contents of the shopping cart.
        customerAlice.viewShoppingCart();

        // Step 5: Customer removes an item, demonstrating cart management.
        System.out.println("\n4. Alice decides she doesn't need the keyboard yet...");
        customerAlice.removeProductFromCart(keyboard);
        customerAlice.viewShoppingCart();

        // Step 6: Customer adds a different item.
        System.out.println("\n5. Alice adds a mouse to her cart instead...");
        customerAlice.addProductToCart(mouse);
        customerAlice.viewShoppingCart();

        // Step 7: Customer places the order.
        System.out.println("\n6. Alice proceeds to checkout...");
        Order alicesOrder = customerAlice.placeOrder("ORD2024-001");

        // Step 8: Display the final order summary if the order was successful.
        if (alicesOrder != null) {
            System.out.println("\n7. Displaying final order confirmation...");
            alicesOrder.displayOrderSummary();

            // Step 9: Demonstrate updating the order status.
            alicesOrder.updateStatus("Shipped");
            alicesOrder.displayOrderSummary();
        }

        // Step 10: Verify that the customer's shopping cart is now empty.
        System.out.println("\n8. Verifying Alice's cart is empty post-order...");
        customerAlice.viewShoppingCart();

        System.out.println("\n--- Simulation Complete ---");
    }
}
