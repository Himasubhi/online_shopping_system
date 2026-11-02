public class CartItem {
   
    private Product product;
    private int quantity;

    public CartItem(Product product,int quantity){
        this.product = product;
        this.quantity = quantity;
    }
    public Product getProduct(){
        return product;
    }
     public void setQuantity(int quantity) {
    this.quantity = quantity;
     }
    public int getQuantity(){
        return quantity;
    }
   

    public double getSubtotal(){
           return product.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return product.getName() + " x" + quantity + " = Rs." + getSubtotal();
    }
}
    

