public class UPIpaymentStrategy implements PaymentStrategy{

     private String upiId;
     public UPIpaymentStrategy(String upiId){
         this.upiId = upiId;
     }
     @override
    public void pay(double amount) {
         System.out.println("Paid$"  +amount + "Using UPI :" + upiId);
     }
}