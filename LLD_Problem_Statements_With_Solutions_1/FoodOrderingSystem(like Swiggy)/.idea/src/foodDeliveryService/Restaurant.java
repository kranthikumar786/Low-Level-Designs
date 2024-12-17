class  Restarunt {
    private final String restaruntID ;
    private final String restaruntName ;
    private final String restaruntAddress;
    private final List<MenuItem> menuItemList;

    public Restarunt(String  restaruntID ,String restaruntName,String  restaruntAddress) {
        this.restaruntID = restaruntID;
        this.restaruntName = restaruntName;
        this.restaruntAddress = restaruntAddress;
        this.menuItemList = menuItemList; // at begining it should be empty ArrayList<>();
    }

    public String getRestaruntId(){
        return restaruntID;}
    public String getRestaruntName(){
        return restaruntName;
    }
    public String getrestaruntAddress(){
        return restaruntAddress;
    }
    public void addmenuitem(MenuItem menuItem) {
        menuItemList.add(menuItem);
    }
    public   void removeMenuItem(MenuItem menuItem){
        menuItemList.remove(menuItem);
    }
    public List<MenuItem> getMenuItemList(){
        return menuItemList;
    }



}