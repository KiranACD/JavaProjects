package DesignParkingLot.Models;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class ParkingLot extends BaseModel {
    private String address;
    private List<ParkingFloor> parkingFloors;
    private List<EntryGate> entryGates;
    private List<ExitGate> exitGates;
    private Map<VehicleType, VehicleTypePrice> vehicleTypePriceMap;

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ParkingFloor> getParkingFloors() {
        return this.parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        
        this.parkingFloors = new ArrayList<>();

        for (ParkingFloor parkingfloor: parkingFloors) {
            this.parkingFloor.add(parkingfloor);
        }
    }

    public List<EntryGate> getEntryGates() {
        return this.entryGates;
    }

    public void setEntryGates(List<EntryGate> entryGates) {
        
        this.entryGates = new ArrayList<>();

        for (EntryGate entryGate: entryGates) {
            this.entryGates.add(entryGate);
        }
    }

    public List<ExitGate> getExitGates() {
        return this.exitGates;
    }

    public void setEntryGates(List<ExitGate> exitGates) {
        
        this.exitGates = new ArrayList<>();

        for (ExitGate exitGate: exitGates) {
            this.exitGates.add(exitGate);
        }
    }
}