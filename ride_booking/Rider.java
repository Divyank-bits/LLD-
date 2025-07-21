package ride_booking;

public class Rider extends User{

    public Rider(String id, String name, String role) {
        super(id, name, role);
    }

    public Ride bookRide(RideService rs, Location pickUpLocation) {
        Ride r = new Ride(this.getId(),"Requested", pickUpLocation);
        rs.addRide(r);
        return r;
    }

    public void cancelRide() {

    }
}
