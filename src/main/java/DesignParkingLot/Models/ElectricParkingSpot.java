package DesignParkingLot.Models;

public class ElectricParkingSpot extends BaseModel {
    private ElectricCharger electricCharger;

    public ElectricParkingSpot(ElectricCharger electricCharger) {
        this.electricCharger = electricCharger;
    }
}