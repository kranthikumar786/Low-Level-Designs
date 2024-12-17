public class CrediteCardPaymentStrategy  implements PaymentStrategy{
  private String cardNumber;
  private String cardHolderName;

  public CrediteCardPaymentStrategy(String cardNumber,String cardHolderName){
      this.cardNumber = cardNumber;
      this.cardHolderName = cardHolderName;
  }
  @override
    public void pay(double amout) {
      System.out.println("Paid $" + amount + "Usgin credite Card:" + cardNumber);
  }

}