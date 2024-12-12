package Models;

import Enumarators.RideStatus;

public class Ride {
  private final int  rideID;
  //private String driverName;
  private final Passenger passenger;
    private Driver driver;

  //private String PassengerName;
  private final  Location sourceLocation;
  private final  Location destinationLocation;
  private RideStatus rideStatus;
  private double rideFare;

  public Ride(int rideID , Passenger drivers, Passenger passengers , Location sourceLocation, Location destinationLocation, RideStatus rideStatus, double rideFare){
      this.rideID = rideID;
      this.passenger = passengers;
      this.driver = drivers;
      this.sourceLocation = sourceLocation;
      this.destinationLocation = destinationLocation;
      this.rideStatus = rideStatus;
      this.rideFare = rideFare;
  }
    public void setDrivers(Driver drivers) {
        this.driver = drivers;
    }
    public void setRideFare(double rideFare){
      this.rideFare = rideFare;
    }
    public void setRideStatus(RideStatus rideStatus){
      this.rideStatus = rideStatus;
    }

    public int getRideID(){
      return  rideID;
    }
    public  Passenger getPassenger() {
         return passenger;
    }
    public Driver getDriver(){
       return  driver;
    }
    public Location getSourceLocation(){
       return sourceLocation;
    }
    public Location getDestinationLocation(){
       return destinationLocation;
    }

    public RideStatus getRideStatus(){
       return rideStatus;
    }
    public double getRideFare(){
        return rideFare;
    }
}
