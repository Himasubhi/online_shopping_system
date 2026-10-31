import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Laptop", 45000, 10));
        products.add(new Product(2, "headset", 15000, 20));
        products.add(new Product(3, "Bath glove", 230,20));
        products.add(new Product(4, "Bath Towel", 315,30));
        products.add(new Product(5, "Soap Bars", 300, 45));

        System.out.println("=== Products ===");
        for (Product p : products) {
            System.out.println(p);
        }
    }
}