package OnlineShoppingService;

import  java.util.List;

public  class OnlineShoppingServiceDemo {
   public class void run(){
        OnlineShoppingService onlineShoppingServiceInstance = OnlineShoppingService.getInstnace();
        // Register users
        User user1 = new User("U001", "John doe" , "john@example","pass1234");
        User user2 = new User("U002", "Jane Smith" , "jane@example","pass5678");
        onlineShoppingServiceInstance.register(user1);
        onlineShoppingServiceInstance.register(user2);

        // Add Prodcuts :
         Product product1 = new Product("P001", "smartPhone", "High-end smart phones", 9999.99,10);
        Product product2 = new Product("P002", "Laptop", "Powerful gaming laptop", 19999.99,5);
        onlineShoppingServiceInstance.addProduct(product1);
        onlineShoppingServiceInstance.addProduct(product2);

        // User 1 adds product to cart and places an order

        ShopingCart cart1 = new ShoppingCart();
       cart1.addItem(product1,2);
       cart1.addItem(product2,1);
       Payment payment1 = new CreditCardPayment();
       Order order1 = onlineShoppingServiceInstance.placeOrder(user1,cart1,payment1);
       System.out.println("Order placed" + order1.getOrderID());
        // User 2 searches for products and adds to cart

        List<Product> searchresults = onlineShoppingServiceInstance.searchProdducts("laptop");
        System.out.println("Search results");
        for(Product product : searchresults){
            System.out.println(product.getProdcutName());
        }


        ShoppingCart cart2 = new ShoppingCart();
        cart2.addItem(searchresults.get(0),1);
        Payment payment2 = new CreditCardPayment();
        Order order2 = onlineShoppingServiceInstance.placeOrder(user2,cart2,payment2);
        System.out.println("Order placed :" + order2.getOrderID());
         // user 1 vies  order history

  List<Order> userOrders = user1.getOrders();
  System.out.println("User 2 order history");
  for(Order order : userOrders){
       System.put.println("Order Id" + order.getOrderID());
       System.out.println("Total amount : $" + order.getToalAmout());
       System.out.println("Status:" + order.getStatus());

    }
}