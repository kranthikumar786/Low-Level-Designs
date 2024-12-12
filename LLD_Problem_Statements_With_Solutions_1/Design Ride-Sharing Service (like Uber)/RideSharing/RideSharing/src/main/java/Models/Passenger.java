package Models;

public class Passenger {
   private  final int  passengerId;
   private  final String passengerName;
   private final String passengerContactNumber;
   private final Location location;

    public Passenger(int  passengerId, String passengerName, Location location, String passengerContactNumber) {
        this.passengerId = passengerId;
        this.passengerName = passengerName;
        this.passengerContactNumber = passengerContactNumber;
       this.location = location;
    }

    public int getPassengerId() {
        return passengerId;
    }
    public String getPassengerName(){
         return passengerName;
    }
    public String getPassengerContactNumber(){
        return passengerContactNumber;
    }
  public Location getLocation(){
          return location;
  }
    //  private String pickUpLocation;
//  private String destinationLocation;
    //private  enum  desiredRide;
}
