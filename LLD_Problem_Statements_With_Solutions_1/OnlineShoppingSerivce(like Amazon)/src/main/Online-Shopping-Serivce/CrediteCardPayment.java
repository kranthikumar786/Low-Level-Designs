package OnlineShoppingService;

public class CrediteCardPayment implements Payment{

    @override
    public boolean processPayment( double amount){
         //  process credite card payment
        return true;
    }
}