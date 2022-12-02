package DesignParkingLot.Models;

public class ParkingSpot extends BaseModel {

    private int spotNumber;
    private ParkingFloor parkingFloor;
    private SpotType spotType;
    private ParkingSpotStatus parkingSpotStatus;

    public int getSpotNumber() {
        return this.spotNumber;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    public SpotType getSpotType() {
        return this.spotType;
    }

    public void setSpotType(SpotType spotType) {
        this.spotType = spotType;
    }

    public ParkingSpotStatus getParkingSpotStatus() {
        return this.parkingSpotStatus;
    }

    public void setParkingSpotStatus(ParkingSpotStatus spotStatus) {
        this.spotStatus = spotStatus;
    }

    public ParkingFloor getParkingFloor() {
        return this.parkingFloor;
    }

    public void setParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloor = parkingFloor;
    }
}