package OnlineShoppingService;
import java.util.ArrayList;
import java.util.HashMap;
import  java.util.List;
import  java.util.Map;

public class ShoppingCart {
   private  final Map<String ,OrderItem> items;

      public ShoppingCart(){
          this.items = new HashMap<>();
      }

      public void addItem(Product product int quantity){
          String productID = product.getProductID();
           if(items.containsKey(productID)){
               OrderItem item = items.get(productID);
               quantity += item.getQuantity();
           }
           items.put(productID,new OrderIte(product,quantity));
      }

      public  void removeItem(String productID){
          items.remove(productID);
      }

      public void updateItemQuantity(String productID , int quantity){
          OrderItem item = items.get(productID);
           if(item != null){
               items.put(productID, new OrderItem(item.getProdcut(),quantity));
           }

      }

      public List<OrderItem> getItems(){
          return new ArrayList<>(items.values());
      }

       public void clear() {
           items.clear();
       }
}