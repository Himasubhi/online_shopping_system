
import java.util.ArrayList;

public class Cart {

    private ArrayList<CartItem> items = new ArrayList<>();

    // Add item
    public void addItem(Product product, int quantity) {

        for (CartItem item : items) {

            if (item.getProduct().getId() == product.getId()) {

                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }

        items.add(new CartItem(product, quantity));
    }

    // Remove item
    public void removeItem(int productId) {

        items.removeIf(item ->
            item.getProduct().getId() == productId
        );
    }

    // Calculate total
    public double getTotal() {

        double total = 0;

        for (CartItem item : items) {
            total += item.getSubtotal();
        }

        return total;
    }

    // Display cart
    public void displayCart() {

        if (items.isEmpty()) {
            System.out.println("Cart is empty");
            return;
        }

        System.out.println("----- YOUR CART -----");

        for (CartItem item : items) {
            System.out.println(item);
        }

        System.out.println("---------------------");
        System.out.println("Total: Rs." + getTotal());
    }

    public ArrayList<CartItem> getItems() {
    return new ArrayList<>(items);
}

public void clearCart() {
    items.clear();
}
}
