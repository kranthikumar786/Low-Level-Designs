package Models;

import Enumarators.DriverStatus;

public class Driver {
   private  int driverID;
   private String driverName;
   private String driverContactNumber;
   private String licencePlate;
   private Location location;
   //private String driverLocation;
   private DriverStatus driverStatus; // enum :

  public Driver(int driverID, String driverName, String driverContactNumber, String licencePlate, Location location, DriverStatus driverStatus) {
       this.driverID = driverID;
       this.driverName = driverName;
       this.driverContactNumber= driverContactNumber;
       this.licencePlate = licencePlate;
       this.location = location;
       this.driverStatus = driverStatus;

  }
  public void setDriverId(int driverId){
      this.driverID = driverID;
  }
  public  void setDriverName(String driverName) {
       this.driverName = driverName;
  }
  public void setDriverContactNumber(String driverContactNumber) {
       this.driverContactNumber = driverContactNumber;
  }
  public void setLicencePlate(String licencePlate) {
      this.licencePlate = licencePlate;
  }
  public  void setLocation(Location location) {
      this.location = location;
  }
  public void setDriverAvailable(DriverStatus driverAvailable){
      this.driverStatus = driverStatus;
  }

  public int getDriverId(){
     return driverID;
  }
  public String getDriverName(){
     return driverName;
  }
  public String getDriverContactNumber(){
     return driverContactNumber;
  }
  public String getLicencePlate(){
      return licencePlate;
  }
  public Location getLocation(){
      return location;
  }
  public DriverStatus getDriverAvailable(){
        return driverStatus;
  }
}
