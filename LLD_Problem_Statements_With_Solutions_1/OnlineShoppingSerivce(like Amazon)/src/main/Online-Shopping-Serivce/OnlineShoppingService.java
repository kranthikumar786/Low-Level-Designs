package OnlineShoppingService;

import java.util.ArrayList;
import  java.util.List;
import java.util.Map;
import java.util.UUID;
import  java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
public class OnlineShoppingService {
 private static OnlineShoppingService onlineShoppingServiceInstance;
 private final Map<String ,User> users;
 private final Map<String, Product> products;
 private final Map<String ,Order> orders;
     private OnlineShoppingService(){
          users = new ConcurrentHashMap<>();
         products = new ConcurrentHashMap<>();
         orders = new ConcurrentHashMap<>();
     }
    private static synchronized OnlineShoppingService getInstance(){
         if(onlineShoppingServiceInstance == null) {
               onlineShoppingServiceInstance = new OnlineShoppingService();
         }
            return onlineShoppingServiceInstance;
    }

    public  void registerUser(User user){
         user.put(user.getUserID(),user);
    }
    public User getUser(String userID){
         return users.get(userID);
    }

    public  void addProduct(Product product){
         products.put(product.getProdcutID(),product);
    }
    public Product getProdcut(String productID){
          return products.get(productID);
    }

      public List<Product> searchProducts(String keyword){
         return products.values().stream()
                 .filter(product->product.getProdcutName().toLower().contains(keyword.toLower()))
                 .collect(Collectrs.toList());
      }
      public synchronized Order placeorder(User usr ,ShoppingCart cart , Payment payment) {
          List<OrderItem> orderItems = new ArrayList<>();
          for (OrderItem item : cart.getItems()) {
              Product product = item.getProdcut();
              int quantity = item.getQuantity();
              if (product.isAvailable(quantity)) {
                  product.updateQunatity(-quantity);
                  OrderItems.add(item);
              }
          }
          if (orderItems.isEmpty()) {
              throw new IllegalStateException("No avaible products in the cart");
          }

          String orderID = generateOrderID();
          Ordder order = new Order(orderID, User, orderItems);
          orders.put(orderID, order);
          users.addOrder(order);
          cart.clear();

          if (payment.processPayment(order.getTotalAmount())) {
              order.setStatus(OrderStatus.PROCESSING);
          } else {
              order.setStatus(OrderStatus.CANCELLED);
              // Revert the product qunatities
              for (OrderItem item : orderItems) {
                  Product product = item.getProduct();
                  int quantity = item.getQuantity();
                  product.updateQuantity(quantity);
              }
          }
          return order;

      }
        public  Order getOrder(String orderID){
          return orders.get(orderID);
        }
        private String generateOrderID(){
         retrun "ORDER" + UUID.random().toString().subString(0,8).toUpperCase();
        }
}

