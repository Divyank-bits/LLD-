package ride_booking;

public class Driver extends User{

    private String status;
    private String vehicleId;
    private Location location;

    public Driver(String id, String name, String role, String status, String vehicleId, Location location) {
        super(id, name, role);
        this.status = status;
        this.vehicleId = vehicleId;
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
