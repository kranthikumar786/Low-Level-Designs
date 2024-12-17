package foodDeliverySerivce;
class Customer {
    private final String customerID ;
    private final String customerName ;
    private final String customerEmail;
    private final String customerContactNumber;

    public Customer(String customerID, String customerName ,String customerEmail,String customerContactNumber){
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerContactNumber = customerContactNumber;
    }

  //  no set method for this as we have declared all instance varibles as final

    public String getCustomerId(){
        return customerID;
    }
    public String getCustomerName(){
        return customerName;
    }

    public Stirng getCustomerEmail(){
        return customerEmail;
    }
    public String getCustomerContactNumber(){
        return customerContactNumber;
    }
}