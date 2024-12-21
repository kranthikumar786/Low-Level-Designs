package OnlineShoppingService;

public class Product {
  private final String productID;
  private final String prodcutName;
  private final String prodcutDescription;
  private final double prodcutPrice;
  private int prodcutQuantity;

  public Product(String productID ,String prodcutName,String prodcutDescription,double prodcutPrice, int prodcutQuantity){
      this.productID = productID;
      this.prodcutName = prodcutName;
      this.prodcutDescription = prodcutDescription;
      this.prodcutPrice = prodcutPrice;
      this.prodcutQuantity = prodcutQuantity;
  }

    public synchronized void updateQunatity(int prodcutQuantity){
      this.prodcutQuantity += prodcutQuantity;
    }

    public synchronized boolean isAvailble(int prodcutQuantity){
        return this.prodcutQuantity >= prodcutQuantity;
    }

    public String getProductID() {
        return productID;
    }

    public String getProdcutName() {
        return prodcutName;
    }

    public String getProdcutDescription() {
        return prodcutDescription;
    }

    public double getProdcutPrice() {
        return prodcutPrice;
    }

    public int getProdcutQuantity() {
        return prodcutQuantity;
    }
}