package DesignParkingLot.Models;

import java.util.Date;

public class Ticket extends BaseModel {
    private Date entryTime;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private Operator generatedBy;

    private ParkingLot parkingLot;
    private EntryGate entryGate;
    private String ownerName;

    public Date getEntryTime() {
        return this.entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public ParkingLot getParkingLot() {
        return this.parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public EntryGate getEntryGate() {
        return this.entryGate;
    }

    public void setEntryGate(EntryGate entryGate) {
        this.entryGate = entryGate;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Operator getGeneratedBy() {
        return this.generatedBy;
    }

    public void setGeneratedBy(Operator generatedBy) {
        this.generatedBy = generatedBy;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }
}