package ride_booking;

public class Vehicle {

    private String id;
    private String driverId;
    private String vehicleType;

    public Vehicle(String id, String driverId, String vehicleType) {
        this.id = id;
        this.driverId = driverId;
        this.vehicleType = vehicleType;
    }

    public String getId() {
        return id;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

}
