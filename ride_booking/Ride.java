package ride_booking;

import java.time.LocalTime;
import java.util.UUID;

public class Ride {
    private String id;
    private String riderId;
    private String driverId;
    private LocalTime startTime;
    private LocalTime endTime;
    private String status;
    private Double amount;
    private int distanceCovered;
    private Location pickUpLocation;

    public Ride(String riderId, String status, Location pickUpLocation) {
        this.id = UUID.randomUUID().toString();
        this.riderId = riderId;
        this.status = status;
        this.pickUpLocation = pickUpLocation;
    }

    public String getId() {
        return id;
    }

    public String getRiderId() {
        return riderId;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public int getDistanceCovered() {
        return distanceCovered;
    }

    public void setDistanceCovered(int distanceCovered) {
        this.distanceCovered = distanceCovered;
    }

    public Location getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(Location pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }
}
