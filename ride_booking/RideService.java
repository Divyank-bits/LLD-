package ride_booking;

import java.util.ArrayList;
import java.util.List;

public class RideService {
    private List<Ride> rides;

    public RideService() {
        rides = new ArrayList<>();
    }

    public Ride addRide(Ride r) {
        rides.add(r);
        return r;
    }

    public Ride updateRide(Ride r) {
        return r;
    }

    public Double getRideFare(Ride r) {
        return r.getAmount();
    }
}
