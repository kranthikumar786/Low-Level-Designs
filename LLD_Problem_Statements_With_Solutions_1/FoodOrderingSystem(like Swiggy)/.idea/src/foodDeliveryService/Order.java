package foodDeliveryService;
import java.util.ArrayList;
import java.util.List;
public class Order {
 private final String orderID;
 private final Customer customer;
 private final Restaurant restaurant;
 private final List<OrderItem> items;
 private OrderStatus orderStatus;  // for one order status always get changes like ordered , wiatingforRest to accept, OUT_FOR_DELIVERY, COOKing inprogress etc..
 private DeliveryAgent deliveryAgent ; // in one order delivery agent may changes like firstly accept then after cancel due to vehicle issue or some other issue

 public Order(String orderID , Customer customer , Restaurant restaurant) {
  this.orderID = orderID;
  this.customer = customer;
  this.restaurant = restaurant;
  this.items = new ArrayList<>();
  this.orderStatus = OrderStatus.PENDING;
 }

 public void addItem(OrderItem item){
  items.add(item);
 }
 public void removeItem(OrderItem item){
  items.remove(item);
 }

 public void setOrderStatus(OrderStatus orderStatus){
  this.orderStatus = orderStatus;
 }
 public void assignDeliveryAgent(DeliveryAgent deliveryAgent){
  this.deliveryAgent = deliveryAgent;
 }
 public String getOrderID(){retrun orderID;}

 public OrderStatus getOrderStatus() {
  return orderStatus;
 }
}
