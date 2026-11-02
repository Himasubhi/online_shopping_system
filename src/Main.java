
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Order> orders = new ArrayList<>();

        int nextOrderId = 1001;

        products.add(new Product(1, "Laptop", 45000, 10));
        products.add(new Product(2, "headset", 15000, 20));
        products.add(new Product(3, "Bath glove", 230, 20));
        products.add(new Product(4, "Bath Towel", 315, 30));
        products.add(new Product(5, "Soap Bars", 300, 45));

        Cart cart = new Cart();

        while (true) {

            System.out.println("\n===== ONLINE SHOPPING SYSTEM =====");
            System.out.println("1. View products");
            System.out.println("2. Add to cart");
            System.out.println("3. View cart");
            System.out.println("4. Remove from cart");
            System.out.println("5. Exit");
            System.out.println("6. Checkout");
            System.out.println("7. View order history");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\n=== Products ===");

                    for (Product p : products) {
                        System.out.println(p);
                    }
                    break;

                case 2:
                    System.out.print("Enter product ID: ");
                    int id = sc.nextInt();

                    Product selectedProduct = null;

                    for (Product p : products) {
                        if (p.getId() == id) {
                            selectedProduct = p;
                            break;
                        }
                    }

                    if (selectedProduct == null) {
                        System.out.println("Product not found!");
                    } else {
                        System.out.print("Enter quantity: ");
                        int quantity = sc.nextInt();

                        if (quantity > 0) {
                            cart.addItem(selectedProduct, quantity);
                            System.out.println("Product added successfully!");
                        } else {
                            System.out.println("Invalid quantity!");
                        }
                    }
                    break;

                case 3:
                    cart.displayCart();
                    break;

                case 4:
                    System.out.print("Enter product ID to remove: ");
                    int removeId = sc.nextInt();

                    cart.removeItem(removeId);
                    System.out.println("Remove operation completed.");
                    break;

                case 5:
                    System.out.println("Thank you for shopping!");
                    sc.close();
                    return;
                case 6:

                    boolean success = checkout(cart, orders, nextOrderId);

                     if (success) {
                      nextOrderId++;
                     }

                   break;
                   case 7:
                     displayOrderHistory(orders);
                     break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        
    }
    public static boolean checkout(Cart cart,ArrayList<Order> orders,int orderId) {

    // Step 1: Check empty cart
    ArrayList<CartItem> items = cart.getItems();

    if (items.isEmpty()) {
        System.out.println("Cart is empty. Cannot checkout!");
        return false;
    }

    // Step 2: Validate stock
    for (CartItem item : items) {

        Product product = item.getProduct();

        if (item.getQuantity() > product.getStock()) {

            System.out.println("Insufficient stock for "
                    + product.getName());

            return false;
        }
    }

    // Step 3: Reduce stock
    for (CartItem item : items) {

        Product product = item.getProduct();

        boolean reduced = product.reduceStock(item.getQuantity());

        if (!reduced) {
            System.out.println("Stock update failed!");
            return false;
        }
    }

    // Step 4: Create order
    Order order = new Order(orderId, items);

    // Step 5: Save order
    orders.add(order);

    // Step 6: Clear cart
    cart.clearCart();

    // Step 7: Confirmation
    System.out.println("\n===== ORDER PLACED SUCCESSFULLY! =====");
    System.out.println("Order ID: " + order.getOrderId());
    System.out.println("Total Amount: Rs." + order.getTotalAmount());
    System.out.println("Order Date: " + order.getOrderDateTime());

    return true;
}

public static void displayOrderHistory(ArrayList<Order> orders) {

    if (orders.isEmpty()) {
        System.out.println("No orders yet");
        return;
    }

    System.out.println("\n===== ORDER HISTORY =====");

    for (Order order : orders) {
        System.out.println(order);
        System.out.println("-------------------------");
    }
}

}
