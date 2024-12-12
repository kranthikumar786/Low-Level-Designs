package Serives;

import Enumarators.DriverStatus;
import Enumarators.RideStatus;
import Enumarators.RideStatus.*;
import Models.Driver;
import Models.Location;
import Models.Passenger;
import Models.Ride;

import javax.lang.model.util.Elements;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

import static Enumarators.RideStatus.*;

public class RideService {

    private static RideService rideServiceInstance;
    private final Map<Integer, Passenger> passengers;
    private final Map<Integer, Driver> drivers;
    private final Map<Integer, Ride>rides;
    private final Queue<Ride> requestedRides;

    private RideService(){
        passengers = new ConcurrentHashMap<>();
        drivers = new ConcurrentHashMap<>();
        rides = new ConcurrentHashMap<>();
        requestedRides = new ConcurrentLinkedQueue<>();
    }
    public static synchronized RideService getInstance(){
        if(rideServiceInstance == null){
            rideServiceInstance = new RideService();
        }
        return rideServiceInstance;
    }

    public void addPassenger(Passenger passenger){
         passengers.put(passenger.getPassengerId(),passenger);
    }

    public void addDriver(Driver driver){
        drivers.put(driver.getDriverId(),driver);
    }

    public void requestedRide(Passenger passenger , Location sourceLocation , Location destinationLocation) {
        Ride ride = new Ride(generateRideId(),passenger,null,sourceLocation,destinationLocation,RideStatus.REQUESTED,0.0);
        requestedRides.offer(ride);
        notifyDrivers(ride);
    }

    public void acceptRide(Driver driver ,Ride ride) {
          if(ride.getRideStatus() == RideStatus.REQUESTED){
              ride.setDrivers(driver);
              ride.setRideStatus(ACCEPTED);
              driver.setDriverAvailable(DriverStatus.BUSY);
              notifyPassenger(ride);
          }
    }

    public void startRide(Ride ride){
        if(ride.getRideStatus() == RideStatus.ACCEPTED) {
             ride.setRideStatus(RideStatus.IN_PROGRESS);
             notifyPassenger(ride);
        }
    }
    public void completeRide(Ride ride) {
         if(ride.getRideStatus() == RideStatus.IN_PROGRESS){
             ride.setRideStatus(RideStatus.COMPLETED);
             ride.getDriver().setDriverAvailable(DriverStatus.AVAILABLE);
             double fare = calculateFare(ride);
             ride.setRideFare(fare);
             processPayment(ride,fare);
             notifyPassenger(ride);
             notifyDriver(ride);
         }
    }
    public void cancelRide(Ride ride){
        if(ride.getRideStatus() == RideStatus.REQUESTED || ride.getRideStatus() == ACCEPTED){
            ride.setRideStatus(RideStatus.CANCELLED);
            if(ride.getDriver() != null) {
                ride.getDriver().setDriverAvailable(DriverStatus.AVAILABLE);
            }
            notifyPassenger(ride);
            notifyDriver(ride);
        }
    }

    private void notifyDrivers(Ride ride) {
         for(Driver driver : drivers.values()) {
               if(driver.getDriverAvailable() == DriverStatus.AVAILABLE) {
                   double distance = calculateDistance(driver.getLocation(),ride.getSourceLocation());
                    if(distance <= 5.0) {
                        // send notification to the driver for ride
                        System.out.println("Notifying Driver" + driver.getDriverName() + "about ride request" + ride.getRideID());
                    }
               }
         }
    }

    private void notifyPassenger(Ride ride) {
          Passenger passenger = ride.getPassenger();
          String message = "";
          switch (ride.getRideStatus()) {

              case ACCEPTED :
                  message = "Your ride has been accepted by driver" + ride.getDriver().getDriverName();
                  break;
              case IN_PROGRESS:
                    message = "Your ride is in progress";
                    break;
              case  COMPLETED:
                    message = "Your ride has been completed.Fare :$" + ride.getRideFare();
                    break;
              case  CANCELLED:
                    message = "Your ride has been cancelled";
                     break;
          }

           // send notification to the passenger
           System.out.println("Notifying Passenger" + passenger.getPassengerName() +"-" + message);
    }

  private void notifyDriver(Ride ride) {
         Driver driver = ride.getDriver();
         if(driver != null) {
             String message = "";
             switch (ride.getRideStatus()) {
                 case COMPLETED :
                     message ="Ride Completed.Fare : $" + ride.getRideFare();
                      break;
                 case CANCELLED:
                      message = "Ride Cancelled by passengers";
                       break;
             }
              // send notfication to the driver
             System.out.println("Notifying driver :"  +driver.getDriverName() + "_" + message);
         }
  }
  private double calculateFare(Ride ride) {
          double baseFare = 2.0;
          double perKMFare = 1.5;
          double perMinuateFare = 0.25;
            double distance = calculateDistance(ride.getSourceLocation(),ride.getDestinationLocation());
            double duration = calculateDuration(ride.getSourceLocation(),ride.getDestinationLocation());
            double fare = baseFare + (distance * perKMFare) + (duration * perMinuateFare);
           return Math.round(fare * 100.0)/100.0; // Rounded to 2 decimal places
  }
  public double calculateDistance(Location sourceLocation , Location destinationLocation) {
         // Calculate the distance between two locations using a distance formula (e.g Haversine formula)
        // Here for Simplicity , assuming a random distance between 1 and 20 Km (extreme values included)
        return Math.random()*20 +1;
  }
  private double calculateDuration(Location sourceLocation , Location destinationLocation) {
        // Calculate the estmated duration between two locations based on distnace and average speed
       // For simplicity , assuming an average speed of 30 km/h
       double distance = calculateDistance(sourceLocation , destinationLocation);
        return (distance/30)*60; // converts hours to minutes
  }
   private void processPayment(Ride ride ,double amount) {
          // process the payment for the ride
    // ...
    }
    private int generateRideId(){
         return (int)(System.currentTimeMillis()/1000);
    }
    public Map<Integer,Ride> getRides(){
        return rides;
    }
  public Queue<Ride> getRequestedRides(){
         return requestedRides;
  }

}
