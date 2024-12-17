public class PaymentContext {
private PaymentStrategy paymentStrategy;

 public void setPaymentStrategy(PaymentStrategy paymentStrategy){
     this.paymentStrategy = paymentStrategy;
 }
 public void pay(double amount) {
     if(paymentStrategy == null){
         throw new IllegalStateException("Payment method not set!");
     }
    paymentStrategy.pay(amount);
 }
}