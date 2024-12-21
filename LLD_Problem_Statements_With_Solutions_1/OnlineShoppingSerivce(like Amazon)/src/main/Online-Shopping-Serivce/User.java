package OnlineShoppingService;
import java.util.ArrayList;
import java.util.List;
public  class User {
  private  final String userId;
  private final String userName;
  private final String userEmail;
  private final String userPassword;
  private final List<Order> orders;

    public User(String userId ,String userName ,String userEmail,String userPassword) {
         this.userId = userId;
         this.userName = userName;
         this.userEmail =userEmail;
         this.userPassword = userPassword;
         this.orders = new ArrayList<>();
    }

     public void addOrder(Order order) {
        orders.add(order);
     }
     public  String getUserId(){
        return  userId;
     }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public List<Order> getOrders() {
        return orders;
    }
}