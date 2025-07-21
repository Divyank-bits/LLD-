package ride_booking;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DriverMatchingService {

    private List<Driver> drivers;

    public DriverMatchingService() {
        this.drivers = new ArrayList<>();
    }

    public Driver addDriver(Driver d) {
        drivers.add(d);
        return d;
    }

    public void removeDriver(String driverId) {
        for(Driver d: drivers) {
            if(driverId.equals(d.getId())){
                d.setStatus("INACTIVE");
            }
        }
    }
    public Driver findNearestDriver(Location pickupLocation, double radius) {
        Driver nearestDriver = null;
        double minDistance = Double.MAX_VALUE;

        for (Driver driver : drivers) {
            Location driverLocation = driver.getLocation();
            double distance = Location.distance(
                    pickupLocation, driverLocation,
                    0, 0 // ignoring elevation
            );

            if (distance <= radius && distance < minDistance) {
                minDistance = distance;
                nearestDriver = driver;
            }
        }

        return nearestDriver;
    }
    public List<Driver> getAlldrivers() {
        return drivers;
    }

    public void acceptRide(Driver d, Ride r,Location l) {
        r.setDriverId(d.getId());
        r.setStartTime(LocalTime.now());
        r.setStatus("PROGRESS");
        r.setPickUpLocation(l);
    }

    public void endRide(Driver d, Ride r, Location dropLocation) {
        int distanceCovered = (int) Location.distance(r.getPickUpLocation(),dropLocation,0,0)/1000;
        r.setDistanceCovered(distanceCovered);
        r.setAmount((double)distanceCovered*5+10);
        r.setEndTime(LocalTime.now());
    }
}
