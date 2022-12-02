package DesignParkingLot.Models;

import java.util.List;
import java.util.ArrayList;

public class ParkingFloor extends BaseModel {
    private List<ParkingSpot> parkingSpots;
    private int floorNumber;

    public List<ParkingSpot> getParkingSpots() {
        return this.parkingSpots;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = new ArrayList<>();

        for (ParkingSpot parkingSpot: parkingSpots) {
            this.parkingSpots.add(parkingSpot);
        }
    }

    public int getFloorNumber() {
        return this.floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }
}