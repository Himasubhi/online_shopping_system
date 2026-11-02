
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {

    private int orderId;
    private ArrayList<CartItem> items;
    private double totalAmount;
    private LocalDateTime orderDateTime;

    // Constructor
    public Order(int orderId, ArrayList<CartItem> items) {

        this.orderId = orderId;
        this.items = new ArrayList<>(items);

        this.totalAmount = 0;

        for (CartItem item : this.items) {
            this.totalAmount += item.getSubtotal();
        }

        this.orderDateTime = LocalDateTime.now();
    }

    // Getters
    public int getOrderId() {
        return orderId;
    }

    public ArrayList<CartItem> getItems() {
        return new ArrayList<>(items);
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    // Display order
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("\n===== ORDER DETAILS =====\n");
        sb.append("Order ID: ").append(orderId).append("\n");
        sb.append("Date: ").append(orderDateTime).append("\n");

        sb.append("----- Items -----\n");

        for (CartItem item : items) {
            sb.append(item).append("\n");
        }

        sb.append("-----------------\n");
        sb.append("Total Amount: Rs.").append(totalAmount);

        return sb.toString();
    }
}
