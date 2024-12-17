package foodDeliveryService;
import java.util.ArrayList;
import java.util.List;
public class FoodDeliveryServiceDemo {
public static void run(){
    FoodDeliveryService foodDeliveryService = FoodDeliveryService.getInstance();
     // Register customers
    Customer customer1 = new Customer("COO1","John Doe", "john@example.com","12345");
    Customer customer2 = new Customer("COO2","Jane smith", "jane@example.com","678910");
    foodDeliveryService.registerCustomer(customer1);
    foodDeliveryService.registerCustomer(customer2);
     // Register restaurants
    List<MenuItem> restaurant1Menu = new ArrayList<>();
    restaurant1Menu.add(new MenuItem("M0001","Burger","Delicious burger",9.09));
    restaurant1Menu.add(new MenuItem("M0002","Pizza","chesse pizza",12.09));
    Restaurant restaurant1 = new Restaurant("R001","Restaurant1","Address1",restaurant1Menu);
    foodDeliveryService.registerRestaurant(restaurant1);

    List<MenuItem> restaurant2Menu = new ArrayList<>();
    restaurant2Menu.add(new MenuItem("M0003","shusi","Fresh sushi",9.09));
    restaurant2Menu.add(new MenuItem("M0004","ramen","Delicious remen",12.09));
    Restaurant restaurant2 = new Restaurant("R002","Restaurant2","Address2",restaurant2Menu);
    foodDeliveryService.registerRestaurant(restaurant2);


    // Register delivery agents

    DeliveryAgent agent1 = new DeliveryAgent("D001","agent1", "9999");
    DeliveryAgent agent2 = new DeliveryAgent("D002","agent2", "8888");
    foodDeliveryService.registerDeliveryAgent(agent1);
    foodDeliveryService.registerDeliveryAgent(agent2);

    // place an order
    List<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new OrderItem(restaurant1Menu.get(0),2));
    orderItems.add(new OrderItem(restaurant1Menu.get(1),1));
    Order order = foodDeliveryService.placeOrder(customer1.getCustomerId(),restaurant1.getRestaruntId(),orderItems);
    //Update order status
    foodDeliveryService.updateOrderStatus(order.getOrderID(),OrderStatus.CONFIRMED);
    System.out.println("Order status updated:" + order.getOrderStatus());
    // cancel the order
    Order order2 = foodDeliveryService.placeOrder(customer1.getCustomerId(),restaurant2.getRestaruntId(),List.of(new OrderItem(restaurant2Menu.get(0),1)));
    foodDeliveryService.cancelOrder(order2.getOrderID());
}
}