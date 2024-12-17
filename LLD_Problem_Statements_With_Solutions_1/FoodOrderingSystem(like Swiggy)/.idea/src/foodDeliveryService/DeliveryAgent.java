package  foodDeliveryService;

class DeliveryAgent {
    private final String deliveryAgentID ;
    private final String deliveryAgentName ;
    private final String deliveryAgentContactNumber;
    private boolean  delvieryAgentCurrentStatus;
    public DeliveryAgent(int deliveryAgentID, String deliveryAgentName ,String deliveryAgentContactNumber,boolean  delvieryAgentCurrentStatus){
        this.deliveryAgentID = deliveryAgentID;
        this.deliveryAgentName = deliveryAgentName;
        this.deliveryAgentContactNumber = deliveryAgentContactNumber;
        this.delvieryAgentCurrentStatus = true;
    }

    public void setDeliveryAgentCurrentStatus(DeliveryAgentStatus deliveryAgentStatus){
        this.DeliveryAgentStatus = DeliveryAgentStatus;
    }

    public String getDeliveryAgentId(){
        return deliveryAgentID;
    }
    public String getDeliveryAgentName(){
        return deliveryAgentName;
    }
    public String getDeliveryAgentContactNumber(){
        return deliveryAgentContactNumber;
    }

    public boolean getdelvieryAgentCurrentStatus(){
        return delvieryAgentCurrentStatus;
    }
}