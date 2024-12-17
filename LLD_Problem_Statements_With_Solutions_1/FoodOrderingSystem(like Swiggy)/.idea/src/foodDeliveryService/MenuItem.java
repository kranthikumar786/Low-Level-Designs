package foodDeliveryService;
public class MenuItem{
    private final String  menuItemID;
    private final String menuItemName ;
    private final String menuItemDescription;
    private final double menuItemPrice; // wihtout final this can be change like season and timing like afternoon heavy price and high demand:
    private boolean menuItemAvailable ; // this should not be a final becuase of item might get complete so we ahve to update the status using set method

    public MenuItem(String  menuItemID , String menuItemName , String menuItemDescription, double menuItemPrice){
        this.menuItemID = menuItemID;
        this.menuItemName = menuItemName ;
        this.menuItemDescription = menuItemDescription;
        this.menuItemPrice = menuItemPrice;
        this.menuItemAvailable = true;
    }

//    public void setMenuItemPrice(double menuItemPrice ){
//        this.menuItemPrice =menuItemPrice;}

    public void setMenuItemAvaible(boolean menuItemAvailable ){
        this.menuItemAvailable = menuItemAvailable;}

    public String getMenuItemID(){
        return menuItemID;}
    public String  getMenuItemName(){
        return menuItemName;}
    public String getMenuItemDescription(){
        return menuItemDescription;}
    public  double  getMenuItemPrice(){
        return menuItemPrice;}
    public boolean getMenuItemAvailable(){
        return menuItemAvailable;
    }
}

/*
*  All instnace variables always initilizes with bydefault values
* like int = 0
*  float = 0.0
*   doubble = 0.0
*   char = '\u000' (null character)
*   string = null
*   boolean = false;
*
* It is completely okay to initialize a field like this.available = true inside the constructor even if the constructor does not take available as an argument.

Why This Works:
Default Initialization:

In Java, when you declare a field like private boolean available;, it is automatically initialized to false by default.
The this.available = true; in your constructor overrides the default value and explicitly sets the available field to true.
Constructor Initialization:

Even if a field does not appear in the constructor's argument list, you can still initialize or set its value within the constructor.
* */