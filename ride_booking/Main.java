package ride_booking;

public class Main {

    public static void main(String[] args) {

        Location udaipur = new Location(24.5854, 73.7125);
        Location ahmedabad = new Location(23.0225, 72.5714);
        Location bengaluru = new Location(12.9716, 77.5946);
        DriverMatchingService dms = new DriverMatchingService();
        RideService rs = new RideService();

        Rider r1 = new Rider("r1", "Divyank", "rider");
        Driver d1 = new Driver("d1", "Driver 1", "driver", "ACTIVE", "v1", bengaluru);
        Driver d2 = new Driver("d2", "Driver 2", "driver", "ACTIVE", "v2", udaipur);
        Driver d3 = new Driver("d3", "Driver 3", "driver", "ACTIVE", "v3", ahmedabad);

        dms.addDriver(d1);
        dms.addDriver(d2);
        dms.addDriver(d3);

        System.out.println("All registered drivers:");
        for (Driver d : dms.getAlldrivers()) {
            System.out.println("- " + d.getName() + " at " + d.getLocation().getLatitude() + ", " + d.getLocation().getLongitude());
        }

        System.out.println("\nRider " + r1.getName() + " is booking a ride from Bengaluru...");
        Ride newRide = r1.bookRide(rs, bengaluru);
        System.out.println("Ride created: " + newRide.getId() + ", Status: " + newRide.getStatus());

        Driver availableDriver = dms.findNearestDriver(newRide.getPickUpLocation(), 10000); // 10km radius

        if (availableDriver != null) {
            System.out.println("Nearest driver found: " + availableDriver.getName());
            dms.acceptRide(availableDriver, newRide, newRide.getPickUpLocation());
            System.out.println("Ride accepted by: " + availableDriver.getName());

            dms.endRide(availableDriver, newRide, udaipur);
            System.out.println("Ride ended. Drop location: Udaipur");
            System.out.println("Total distance covered " + newRide.getDistanceCovered() + " km");
            double fare = rs.getRideFare(newRide);
            System.out.println("Ride Fare: Rs " + fare);
        } else {
            System.out.println("No driver found within 10km radius.");
        }
    }
}
