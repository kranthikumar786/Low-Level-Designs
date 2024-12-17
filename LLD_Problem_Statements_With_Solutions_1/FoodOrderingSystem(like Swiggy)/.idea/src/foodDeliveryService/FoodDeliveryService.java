package foodDeliveryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
public class FoodDeliveryService {
  private static FoodDeliveryService foodDeliveryServiceInstance;
  private final Map<String ,Customer>customersMap;
  private final Map<String, Restaurant> restaurantsMap;
  private final Map<String, Order> ordersMap;
  private final Map<String,DeliveryAgent> deliveryAgentMap;

  private FoodDeliveryService(){
      customersMap = new ConcurrentHashMap<>();
      restaurantsMap = new ConcurrentHashMap<>();
      ordersMap = new ConcurrentHashMap<>();
      deliveryAgentMap = new ConcurrentHashMap<>();
  }

  public static synchronized FoodDeliveryService getInstance(){
       if(foodDeliveryServiceInstance == null) {
       foodDeliveryServiceInstance = new FoodDeliveryService();
       }
       return foodDeliveryServiceInstance;
  }
  public void registerCustomer(Customer customer){
      customersMap.put(customer.getCustomerId(),customer);
  }
  public void registerRestaurant(Restaurant restaurant){
      restaurantsMap.put(restaurant.getRestaruntId(),restaurant);
  }
  public void registerDeliveryAgent(DeliveryAgent deliveryAgent){
      deliveryAgentMap.put(deliveryAgent.getDeliveryAgentId(),deliveryAgent);
  }
  public List<Restaurant> getAvailableRestaurants(){
      return new ArrayList<>(restaurantsMap.values());
  }
  public List<MenuItem> getRestaruntMenu(String restaruntID){
      Restarunt restarunt = restaurantsMap.get(restaruntID);
        if(restarunt != null){
            return  restarunt.getMenuItemList();
        }
        return new ArrayList<>();
  }

  public Order placeOrder(String customerId , String restaruntID ,List<OrderItem> items){
      Customer customer = customersMap.get(customerId);
      Restaurant restaurant = restaurantsMap.get(restaruntID);
      if(customer != null && restaurant != null){
           Order order = new Order(generateOrderId(),customer,restaurant);
           for(OrderItem item : items) {
               Order.addItem(item);
           }
      }
      ordersMap.put(order.getOrderID(),order);
      notifyRestaurant(order);
      System.out.prinlnt("Order places : " + order.getOrderID());
     return order;
  }
  return null;
}

public void updateOrderStatus(String orderId , OrderStatus status){
    Order order = ordersMap.get(orderId);
    if(order != null) {
        order.setOrderStatus(status);
        notifyCustomer(order);
         if(status == OrderStatus.CONFIRMED) {
             assignDeliveryAgent(order);
         }
    }
}

public void cancelOrder (String orderID){
    Order order = ordersMap.get(orderID);
    if(order != null && order.getOrderStatus() == OrderStatus.PENDING){
        order.setOrderStatus(OrderStatus.CANCELLED);
        notifyCustomer(order);
        notifyRestaurant(order);
        System.out.println("Order cancelled :" + order.getOrderID());
    }
}
private void notifyCustomer(Order order){

}
private void notifyRestaurant(Order order){


}

private void assignDeliveryAgent(Order order) {
    for(DeliveryAgent agent : deliveryAgentMap.values()) {
         if(agent.getdelvieryAgentCurrentStatus()){
             agent.setDeliveryAgentCurrentStatus(false);
             order.assignDeliveryAgent(agent);
             notifyDeliveryAgent(order);
             break;
         }

    }
}
private void notifyDeliveryAgent(Order order){

}
private String generateOrderId(){
    retrun "ORD" + UUID.randomUUID().toString().substring(0,8).toUpperCase();
}





















