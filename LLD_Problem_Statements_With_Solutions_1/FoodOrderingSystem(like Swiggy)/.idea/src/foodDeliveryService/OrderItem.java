package foodDeliveryService;
public class OrderItem {

    private final MenuItem menuItem;
    private int Quantity;
    public OrderItem(MenuItem menuItem ,int Quantity){
        this.menuItem = menuItem;
        this.Quantity = Quantity;
    }
}