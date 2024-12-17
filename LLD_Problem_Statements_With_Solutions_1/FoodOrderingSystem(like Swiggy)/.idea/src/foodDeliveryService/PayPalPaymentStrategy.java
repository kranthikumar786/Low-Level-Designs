public class PayPalPaymentStrategy implements PaymentStrategy{

    private String email ;

    public PayPalPaymentStrategy(String email) {
        this.email = email;
    }
    @override

    public void pay(double amount){
        System.out.println("Paid$" + amount + "Using Paypal:" + email);
    }
}