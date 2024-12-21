package OnlineShoppingService;
import java.util.ArrayList;
public class Order {

private final String orderID;
private  final User user ;
private final List<OrderItem> items;
private final double orderTotalAmount;
private OrderStatus status;

public Order(String orderID , User user , List<OrderItem> items){
      this.orderID = orderID;
      this.user = user;
      this.items = items;
      this.orderTotalAmount = calculateTotalAmout();
      this.status = OrderStatus.PENDING;
}
  private double calculateTotalAmout(){
    return items.stream().mapToDouble()(item->item.getProdcut().getPrice()*item.getQuanity()).sum();
  }
   public void setStatus(OrderStatus status){
    this.status = status;
   }

    public String getOrderID() {
        return orderID;
    }

    public User getUser() {
        return user;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public double getOrderTotalAmount() {
        return orderTotalAmount;
    }

    public OrderStatus getStatus() {
        return status;
    }
}