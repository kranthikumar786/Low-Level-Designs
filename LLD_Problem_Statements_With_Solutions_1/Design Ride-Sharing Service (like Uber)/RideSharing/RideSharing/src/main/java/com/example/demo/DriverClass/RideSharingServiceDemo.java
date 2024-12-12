package com.example.demo.DriverClass;

import Enumarators.DriverStatus;
import Models.Driver;
import Models.Location;
import Models.Passenger;
import Models.Ride;
import Serives.RideService;

public class RideSharingServiceDemo {

    public static void run(){
        RideService rideService = RideService.getInstance();
        // create passengers
        Passenger passenger1 = new Passenger(1 ,"John Doe",new Location(37.7749,-122.4194),"98765456");
        Passenger passenger2 = new Passenger(2 ,"Jane Smith",new Location(37.7860,-122.4070),"12345");
        rideService.addPassenger(passenger1);
        rideService.addPassenger(passenger2);

        Driver driver1 = new Driver(1,"ABCD" , "9876543210","ABC123" ,new Location(37.7749,-122.4149), DriverStatus.AVAILABLE);
        Driver driver2 = new Driver(2,"xyz" , "9876543211", "DEF456",new Location(37.7749,-122.4149), DriverStatus.AVAILABLE);
       rideService.addDriver(driver1);
       rideService.addDriver(driver2);

        // passenger 1 request a ride
       rideService.requestedRide(passenger1,passenger1.getLocation(),new Location(37.7887,-122.4098));


        // Driver 1 accepts  the ride
        Ride ride = rideService.getRequestedRides().poll();
        rideService.acceptRide(driver1,ride);

        // start the ride
         rideService.startRide(ride);
         // complete the ride
        rideService.completeRide(ride);

        // passenger 2 requests a ride
        rideService.requestedRide(passenger2,passenger2.getLocation(),new Location(37.7749,-122.4194));

        // Driver 2 accept the ride
         Ride ride2 = rideService.getRequestedRides().poll();
         rideService.acceptRide(driver2,ride2);
         //  passenger 2 cancels the ride
        rideService.cancelRide(ride2);
    }
}
